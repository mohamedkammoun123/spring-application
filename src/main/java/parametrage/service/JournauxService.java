package com.csys.template.parametrage.service;

import com.csys.template.parametrage.domain.AccessJournal;
import com.csys.template.parametrage.domain.Journaux;
import com.csys.template.parametrage.domain.JournauxPK;
import com.csys.template.parametrage.domain.QJournaux;
import com.csys.template.parametrage.domain.TraceJour;
import com.csys.template.parametrage.dto.AccessJournalDTO;
import com.csys.template.parametrage.dto.JournauxDTO;
import com.csys.template.parametrage.factory.AccessJournalFactory;
import com.csys.template.parametrage.factory.JournauxFactory;
import com.csys.template.parametrage.factory.TraceJourFactory;
import com.csys.template.parametrage.repository.JournauxRepository;
import com.csys.template.parametrage.repository.TraceJourRepository;
import com.csys.template.util.Preconditions;
import com.csys.template.util.WhereClauseBuilder;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing Journaux.
 */
@Service
@Transactional
public class JournauxService {

    private final Logger log = LoggerFactory.getLogger(JournauxService.class);

    private final JournauxRepository journauxRepository;
    private final TraceJourRepository traceJourRepository;

    public JournauxService(JournauxRepository journauxRepository, TraceJourRepository traceJourRepository) {
        this.journauxRepository = journauxRepository;
        this.traceJourRepository = traceJourRepository;
    }



    @Transactional(
            readOnly = true
    )
    public JournauxDTO findOne(String CodJou, String codeSoc) {
        log.debug("Request to get Journaux: CodJou {} codeSoc {}", CodJou, codeSoc);
        JournauxPK pk = new JournauxPK();
        pk.setCodeSoc(codeSoc);
        pk.setCodJou(CodJou);
        Journaux journaux = journauxRepository.findOne(pk);
        JournauxDTO dto = JournauxFactory.journauxToJournauxDTO(journaux, Boolean.FALSE);
        return dto;
    }

    @Transactional(
            readOnly = true
    )
    public Journaux findJournaux(JournauxPK id) {
        log.debug("Request to get Journaux: {}", id);
        Journaux journaux = journauxRepository.findOne(id);
        return journaux;
    }

    @Transactional(
            readOnly = true
    )
    public List<JournauxDTO> findByFilters(String societe, List<Boolean> manuelle, Boolean controle, List<String> codjous) {
        log.debug("Request to find Journaux By Filters societe :{} manuelle :{} controle :{} codjou : {}", societe, manuelle, controle, codjous);
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        QJournaux qJournaux = QJournaux.journaux;
        WhereClauseBuilder builder = new WhereClauseBuilder()
                .optionalAnd(societe, () -> qJournaux.journauxPK().codeSoc.eq(societe))
                .optionalAnd(manuelle, () -> qJournaux.manuelle.in(manuelle))
                .optionalAnd(codjous, () -> qJournaux.journauxPK().codJou.in(codjous))
                .booleanAnd(controle, () -> qJournaux.accessJournalList.any().accessJournalPK().userName.eq(user).and(qJournaux.controleUser.eq(true)).or(qJournaux.controleUser.eq(false)));

        List<Journaux> result = (List<Journaux>) journauxRepository.findAll(builder);
        return JournauxFactory.journauxToJournauxDTOs(result, Boolean.TRUE);
    }

    public JournauxDTO save(JournauxDTO journauxDTO) {
        log.debug("Request to save Journaux: {}", journauxDTO);
        JournauxPK pk = new JournauxPK();
        pk.setCodJou(journauxDTO.getCodJou());
        pk.setCodeSoc(journauxDTO.getCodeSoc());
        Journaux journal = journauxRepository.findOne(pk);
        Preconditions.checkBusinessLogique(journal == null, "Le journal est déja existant");
        List<JournauxDTO> lisJournaux = findByFilters(journauxDTO.getCodeSoc(), null, false, null);
        boolean existJou = lisJournaux.stream().anyMatch(t -> t.getLibJr().equals(journauxDTO.getLibJr()));
        Preconditions.checkBusinessLogique(!existJou, "Le libéllé du journal est déja existant");
        Journaux journaux = JournauxFactory.createJournaux(journauxDTO);
        journaux = journauxRepository.save(journaux);
        TraceJour traceJ = TraceJourFactory.tracejourDTOToTraceJour(journaux, "A");
        traceJourRepository.save(traceJ);
        JournauxDTO resultDTO = JournauxFactory.journauxToJournauxDTO(journaux, Boolean.FALSE);
        return resultDTO;
    }

    public JournauxDTO update(JournauxDTO journauxDTO) {
        log.debug("Request to save Journaux: {}", journauxDTO);
        JournauxPK pk = new JournauxPK();
        pk.setCodJou(journauxDTO.getCodJou());
        pk.setCodeSoc(journauxDTO.getCodeSoc());
        Journaux journaux = journauxRepository.findOne(pk);
        Preconditions.checkBusinessLogique(journaux != null, "Le journal n'existe pas");
        Preconditions.checkBusinessLogique(!journauxRepository.existsByJournauxPK_CodeSocAndLibJrAndJournauxPK_CodJouNot(journauxDTO.getCodeSoc(), journauxDTO.getLibJr(), journauxDTO.getCodJou()), "Le libéllé du journal est déja existant");
        TraceJour traceJ = TraceJourFactory.tracejourDTOToTraceJour(journaux, "M");
        traceJourRepository.save(traceJ);
        JournauxFactory.journauxDTOToJournaux(journauxDTO, journaux);
        List<AccessJournal> accessJournalList = new ArrayList<>();
        if (journauxDTO.getAccessJournalList() != null) {
            for (AccessJournalDTO accessJournalDTO : journauxDTO.getAccessJournalList()) {
                AccessJournal accessjournal = AccessJournalFactory.accessjournalDTOToAccessJournal(accessJournalDTO);
                accessjournal.setJournaux(journaux);
                accessJournalList.add(accessjournal);
            }
        }
        if (journaux.getAccessJournalList() != null) {
            journaux.getAccessJournalList().clear();
            journaux.getAccessJournalList().addAll(accessJournalList);
        } else {
            journaux.setAccessJournalList(accessJournalList);
        }
        journaux = journauxRepository.save(journaux);
        JournauxDTO resultDTO = JournauxFactory.journauxToJournauxDTO(journaux, Boolean.FALSE);
        return resultDTO;
    }

    public Boolean delete(String codJou, String codeSoc) {
        log.debug("Request to delete Journaux codJou: {} codeSoc: {}", codJou, codeSoc);
        JournauxPK pk = new JournauxPK();
        pk.setCodJou(codJou);
        pk.setCodeSoc(codeSoc);
        Journaux journal = journauxRepository.findOne(pk);
        Preconditions.checkBusinessLogique(journal != null, "Le journal n'existe pas");
        TraceJour traceJ = TraceJourFactory.tracejourDTOToTraceJour(journal, "S");
        traceJourRepository.save(traceJ);
        journauxRepository.delete(pk);
        return true;
    }


}
