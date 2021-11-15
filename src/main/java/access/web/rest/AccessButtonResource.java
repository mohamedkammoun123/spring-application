package com.csys.template.access.web.rest;

import com.csys.template.access.domain.AccessButtonUtilisateurPK;
import com.csys.template.access.dto.AccessButtonDTO;
import com.csys.template.access.service.AccessButtonService;
import com.csys.template.util.RestPreconditions;
import java.lang.String;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing AccessButton.
 */
@RestController
@RequestMapping("/api")
public class AccessButtonResource {
  private static final String ENTITY_NAME = "accessbutton";

  private final AccessButtonService accessbuttonService;

  private final Logger log = LoggerFactory.getLogger(AccessButtonService.class);

  public AccessButtonResource(AccessButtonService accessbuttonService) {
    this.accessbuttonService=accessbuttonService;
  }

  
  @GetMapping("/accessbuttons/{id}")
  public ResponseEntity<AccessButtonDTO> getAccessButton(@PathVariable AccessButtonUtilisateurPK id) {
    log.debug("Request to get AccessButton: {}",id);
    AccessButtonDTO dto = accessbuttonService.findOne(id);
    RestPreconditions.checkFound(dto, "accessbutton.NotFound");
    return ResponseEntity.ok().body(dto);
  }

 
  @GetMapping("/accessbuttons")
  public Collection<AccessButtonDTO> getAllAccessButtons() {
    log.debug("Request to get all  AccessButtons : {}");
    return accessbuttonService.findAll();
  }
}

