package com.csys.template.access.service;

import com.csys.template.access.domain.AccessButtonUtilisateur;
import com.csys.template.access.domain.ParamG;
import com.csys.template.access.domain.QAccessButtonUtilisateur;
import com.csys.template.access.dto.AccessButtonDTO;
import com.csys.template.access.factory.AccessButtonUtilisateurFactory;
import com.csys.template.access.repository.AccessButtonUtilisateurRepository;
import com.csys.template.access.repository.ParamGRepository;
import com.csys.template.util.WhereClauseBuilder;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing AccessButtonUtilisateur.
 */
@Service
@Transactional
public class AccessButtonUtilisateurService {

    private final Logger log = LoggerFactory.getLogger(AccessButtonUtilisateurService.class);
    private final ParamGRepository paramGRepository;
    private final AccessButtonUtilisateurRepository accessButtonUtilisateurRepository;
    private final AccessButtonService accessButtonService;

    public AccessButtonUtilisateurService(ParamGRepository paramGRepository, AccessButtonUtilisateurRepository accessButtonUtilisateurRepository, AccessButtonService accessButtonService) {
        this.paramGRepository = paramGRepository;
        this.accessButtonUtilisateurRepository = accessButtonUtilisateurRepository;
        this.accessButtonService = accessButtonService;
    }

    @Transactional(
            readOnly = true
    )
    public Collection<AccessButtonDTO> findAll() {
        log.debug("Request to get All AccessButtonUtilisateurs");
        Collection<AccessButtonUtilisateur> result = accessButtonUtilisateurRepository.findAll();
        return AccessButtonUtilisateurFactory.accessbuttonutilisateurToAccessButtonUtilisateurDTOs(result);
    }

    @Transactional(
            readOnly = true
    )
    public Collection<AccessButtonDTO> findByCodeMenuAndModule(String menu, String module) {
        log.debug("Request to get All AccessButtonUtilisateur findByCodeMenuAndModule");
        QAccessButtonUtilisateur qQAccessButtonUtilisateur = QAccessButtonUtilisateur.accessButtonUtilisateur;
        WhereClauseBuilder builder = new WhereClauseBuilder()
                .and(qQAccessButtonUtilisateur.accessButtonUtilisateurPK().codeMenu.eq(menu))
                .and(qQAccessButtonUtilisateur.accessButtonUtilisateurPK().codeModule.eq(module))
                .and(qQAccessButtonUtilisateur.accessButtonUtilisateurPK().utilisateur.eq(SecurityContextHolder.getContext().getAuthentication().getName()))
                .and(qQAccessButtonUtilisateur.visible.eq(Boolean.TRUE));
        List<AccessButtonUtilisateur> result = (List<AccessButtonUtilisateur>) accessButtonUtilisateurRepository.findAll(builder);
        return AccessButtonUtilisateurFactory.accessbuttonutilisateurToAccessButtonUtilisateurDTOs(result);
    }

    @Transactional(
            readOnly = true
    )
    public Collection<AccessButtonDTO> findAccessUserBouton(String menu, String module) {
        ParamG paramVersionSec = paramGRepository.findOne("new_version_securite");
        Collection<AccessButtonDTO> accessButton;
        if (paramVersionSec != null && paramVersionSec.getValeur().equalsIgnoreCase("true")) {
            accessButton = findByCodeMenuAndModule(menu, module);
        } else {
            accessButton = accessButtonService.findByCodeMenuAndModule(menu, module);
        }
        return accessButton;
    }
}
