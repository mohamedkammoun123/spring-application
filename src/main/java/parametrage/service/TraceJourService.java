package com.csys.template.parametrage.service;

import com.csys.template.parametrage.repository.TraceJourRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing TraceJour.
 */
@Service
@Transactional
public class TraceJourService {
  private final Logger log = LoggerFactory.getLogger(TraceJourService.class);

  private final TraceJourRepository tracejourRepository;

  public TraceJourService(TraceJourRepository tracejourRepository) {
    this.tracejourRepository=tracejourRepository;
  }

}

