package com.csys.template.parametrage.web.rest;

import com.csys.template.parametrage.service.TraceJourService;
import java.lang.String;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing TraceJour.
 */
@RestController
@RequestMapping("/api")
public class TraceJourResource {
  private static final String ENTITY_NAME = "tracejour";

  private final TraceJourService tracejourService;

  private final Logger log = LoggerFactory.getLogger(TraceJourService.class);

  public TraceJourResource(TraceJourService tracejourService) {
    this.tracejourService=tracejourService;
  }

}

