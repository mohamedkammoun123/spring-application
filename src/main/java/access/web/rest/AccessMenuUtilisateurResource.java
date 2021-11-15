package com.csys.template.access.web.rest;

import com.csys.template.access.domain.AccessMenuUtilisateurPK;
import com.csys.template.access.dto.AccessMenuDTO;
import com.csys.template.access.service.AccessMenuUtilisateurService;
import com.csys.template.util.RestPreconditions;
import java.lang.String;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing AccessMenuUtilisateur.
 */
@RestController
@RequestMapping("/api")
public class AccessMenuUtilisateurResource {

    private static final String ENTITY_NAME = "accessMenuUtilisateur";

    private final AccessMenuUtilisateurService accessMenuUtilisateurService;

    private final Logger log = LoggerFactory.getLogger(AccessMenuUtilisateurService.class);

    public AccessMenuUtilisateurResource(AccessMenuUtilisateurService accessMenuUtilisateurService) {
        this.accessMenuUtilisateurService = accessMenuUtilisateurService;
    }

    @GetMapping("/access-menu-utilisateur/{id}")
    public ResponseEntity<AccessMenuDTO> getAccessMenuUtilisateur(@PathVariable AccessMenuUtilisateurPK id) {
        log.debug("Request to get AccessMenuUtilisateur: {}", id);
        AccessMenuDTO dto = accessMenuUtilisateurService.findOne(id);
        RestPreconditions.checkFound(dto, "accessmenuutilisateur.NotFound");
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/access-menu-utilisateur")
    public Collection<AccessMenuDTO> getAllAccessMenuUtilisateurs() {
        log.debug("Request to get all  AccessMenuUtilisateurs : {}");
        return accessMenuUtilisateurService.findAll();
    }

    @RequestMapping(value = "/access-menu-utilisateur/findAccessMenuUser", method = RequestMethod.GET)
    public Collection<AccessMenuDTO> findAccessMenuUser(@RequestParam(required = false) String module) {
        log.debug("Request to get all  AccessMenuUsers findByCodeModule: {}");
        return accessMenuUtilisateurService.findAccessMenuUser(module);
    }
}
