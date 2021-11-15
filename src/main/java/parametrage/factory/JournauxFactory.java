package com.csys.template.parametrage.factory;

import com.csys.template.parametrage.domain.AccessJournal;
import com.csys.template.parametrage.domain.Journaux;
import com.csys.template.parametrage.domain.JournauxPK;
import com.csys.template.parametrage.dto.JournauxDTO;
import java.util.ArrayList;
import java.util.List;

public class JournauxFactory {

    public static JournauxDTO journauxToJournauxDTO(Journaux journaux, Boolean lazy) {
        if (journaux == null) {
            return null;
        }
        JournauxDTO journauxDTO = new JournauxDTO();
        journauxDTO.setCodJou(journaux.getJournauxPK().getCodJou());
        journauxDTO.setCodeSoc(journaux.getJournauxPK().getCodeSoc());
        journauxDTO.setLibJr(journaux.getLibJr());
        journauxDTO.setNumCpt(journaux.getNumCpt());
        journauxDTO.setTypeSaisie(journaux.getTypeSaisie());
        journauxDTO.setControle(journaux.getControle());
        journauxDTO.setManuelle(journaux.getManuelle());
        journauxDTO.setControleUser(journaux.getControleUser());
        if (!lazy) {
            journauxDTO.setAccessJournalList(AccessJournalFactory.accessjournalToAccessJournalDTOs(journaux.getAccessJournalList()));
        }
        return journauxDTO;
    }

    public static void journauxDTOToJournaux(JournauxDTO journauxDTO, Journaux journaux) {
        journaux.setLibJr(journauxDTO.getLibJr());
        journaux.setNumCpt(journauxDTO.getNumCpt());
        journaux.setTypeSaisie(journauxDTO.getTypeSaisie());
        journaux.setControle(journauxDTO.getControle());
        journaux.setManuelle(journauxDTO.getManuelle());
        journaux.setControleUser(journauxDTO.getControleUser());
    }

    public static List<JournauxDTO> journauxToJournauxDTOs(List<Journaux> journauxs, Boolean lazy) {
        List<JournauxDTO> journauxsDTO = new ArrayList<>();
        journauxs.forEach(x -> {
            journauxsDTO.add(journauxToJournauxDTO(x, lazy));
        });
        return journauxsDTO;
    }

    public static Journaux createJournaux(JournauxDTO journauxDTO) {
        if (journauxDTO == null) {
            return null;
        }
        Journaux journaux = new Journaux();
        JournauxPK journauxPK = new JournauxPK();
        journauxPK.setCodeSoc(journauxDTO.getCodeSoc());
        journauxPK.setCodJou(journauxDTO.getCodJou());
        journaux.setJournauxPK(journauxPK);
        journaux.setLibJr(journauxDTO.getLibJr());
        journaux.setControle(journauxDTO.getControle());
        journaux.setManuelle(journauxDTO.getManuelle());
        journaux.setControleUser(journauxDTO.getControleUser());
        journaux.setNumCpt(journauxDTO.getNumCpt());
        journaux.setTypeSaisie(journauxDTO.getTypeSaisie());
        journaux.setOrder("2");
        List<AccessJournal> accessJournalList = new ArrayList<>();
        if (journauxDTO.getAccessJournalList() != null) {
            journauxDTO.getAccessJournalList().forEach(x -> {
                AccessJournal accessjournal = AccessJournalFactory.accessjournalDTOToAccessJournal(x);
                accessJournalList.add(accessjournal);
            });
        }
        journaux.setAccessJournalList(accessJournalList);
        return journaux;
    }
}
