package com.csys.template.access.web.rest;

import com.csys.template.access.dto.AccessButtonDTO;
import com.csys.template.access.service.AccessButtonUtilisateurService;
import java.lang.String;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing AccessButtonUtilisateur.
 */
@RestController
@RequestMapping("/api")
public class AccessButtonUtilisateurResource {

    private static final String ENTITY_NAME = "accessbuttonutilisateur";

    private final AccessButtonUtilisateurService accessButtonUtilisateurService;

    private final Logger log = LoggerFactory.getLogger(AccessButtonUtilisateurService.class);

    public AccessButtonUtilisateurResource(AccessButtonUtilisateurService accessButtonUtilisateurService) {
        this.accessButtonUtilisateurService = accessButtonUtilisateurService;
    }

  
    @GetMapping("/access-button-utilisateur")
    public Collection<AccessButtonDTO> getAllAccessButtonUtilisateurs() {
        log.debug("Request to get all  AccessButtonUtilisateurs : {}");
        return accessButtonUtilisateurService.findAll();
    }

    @GetMapping("/access-button-utilisateur/findByCodeMenuAndModule")
    public Collection<AccessButtonDTO> findAccessUserBouton(@RequestParam(required = false) String module, @RequestParam(required = false) String menu) {
        log.debug("Request to get all  AccessMenuUsers findByCodeMenuAndModule: {}");
        return accessButtonUtilisateurService.findAccessUserBouton(menu, module);
    }

}
