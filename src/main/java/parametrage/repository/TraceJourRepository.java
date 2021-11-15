package com.csys.template.parametrage.repository;

import com.csys.template.parametrage.domain.TraceJour;
import com.csys.template.parametrage.domain.TraceJourPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the TraceJour entity.
 */
@Repository
public interface TraceJourRepository extends JpaRepository<TraceJour, TraceJourPK> {
}

