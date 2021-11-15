package com.csys.template.access.service;

import com.csys.template.access.domain.AccessMenuUtilisateur;
import com.csys.template.access.domain.AccessMenuUtilisateurPK;
import com.csys.template.access.domain.ParamG;
import com.csys.template.access.domain.QAccessMenuUtilisateur;
import com.csys.template.access.dto.AccessMenuDTO;
import com.csys.template.access.factory.AccessMenuUtilisateurFactory;
import com.csys.template.access.repository.AccessMenuUtilisateurRepository;
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
 * Service Implementation for managing AccessMenuUtilisateur.
 */
@Service
@Transactional
public class AccessMenuUtilisateurService {

    private final Logger log = LoggerFactory.getLogger(AccessMenuUtilisateurService.class);

    private final AccessMenuUtilisateurRepository accessMenuUtilisateurRepository;
    private final ParamGRepository paramGRepository;
    private final AccessMenuService accessMenuService;

    public AccessMenuUtilisateurService(AccessMenuUtilisateurRepository accessMenuUtilisateurRepository, ParamGRepository paramGRepository, AccessMenuService accessMenuService) {
        this.accessMenuUtilisateurRepository = accessMenuUtilisateurRepository;
        this.paramGRepository = paramGRepository;
        this.accessMenuService = accessMenuService;
    }

    @Transactional(
            readOnly = true
    )
    public AccessMenuDTO findOne(AccessMenuUtilisateurPK id) {
        log.debug("Request to get AccessMenuUtilisateur: {}", id);
        AccessMenuUtilisateur accessmenuutilisateur = accessMenuUtilisateurRepository.findOne(id);
        AccessMenuDTO dto = AccessMenuUtilisateurFactory.accessmenuutilisateurToAccessMenuUtilisateurDTO(accessmenuutilisateur);
        return dto;
    }

    @Transactional(
            readOnly = true
    )
    public AccessMenuUtilisateur findAccessMenuUtilisateur(AccessMenuUtilisateurPK id) {
        log.debug("Request to get AccessMenuUtilisateur: {}", id);
        AccessMenuUtilisateur accessmenuutilisateur = accessMenuUtilisateurRepository.findOne(id);
        return accessmenuutilisateur;
    }

    @Transactional(
            readOnly = true
    )
    public Collection<AccessMenuDTO> findAll() {
        log.debug("Request to get All AccessMenuUtilisateurs");
        Collection<AccessMenuUtilisateur> result = accessMenuUtilisateurRepository.findAll();
        return AccessMenuUtilisateurFactory.accessmenuutilisateurToAccessMenuUtilisateurDTOs(result);
    }

    @Transactional(
            readOnly = true
    )
    public Collection<AccessMenuDTO> findByCodeModule(String module) {
        log.debug("Request to get All AccessMenuUtilisateurs findByCodeModule");
        QAccessMenuUtilisateur qQAccessMenuUtilisateur = QAccessMenuUtilisateur.accessMenuUtilisateur;
        WhereClauseBuilder builder = new WhereClauseBuilder()
                .and(qQAccessMenuUtilisateur.accessMenuUtilisateurPK().codeModule.eq(module))
                .and(qQAccessMenuUtilisateur.accessMenuUtilisateurPK().utilisateur.eq(SecurityContextHolder.getContext().getAuthentication().getName()))
                .and(qQAccessMenuUtilisateur.visible.eq(Boolean.TRUE));
        List<AccessMenuUtilisateur> result = (List<AccessMenuUtilisateur>) accessMenuUtilisateurRepository.findAll(builder);
        return AccessMenuUtilisateurFactory.accessmenuutilisateurToAccessMenuUtilisateurDTOs(result);
    }

    @Transactional(
            readOnly = true
    )
    public Collection<AccessMenuDTO> findAccessMenuUser(String module) {
        ParamG paramVersionSec = paramGRepository.findOne("new_version_securite");
        log.debug("test version sec {}",paramVersionSec.getValeur());
        Collection<AccessMenuDTO> accessMenu;
        if (paramVersionSec != null && paramVersionSec.getValeur().equalsIgnoreCase("true")) {
            accessMenu = findByCodeModule(module);
        } else {
            accessMenu = accessMenuService.findByCodeModule(module);
        }
        return accessMenu;
    }
}
