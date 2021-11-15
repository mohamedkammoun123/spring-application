package com.csys.template.parametrage.repository;

import com.csys.template.parametrage.domain.AccessJournal;
import com.csys.template.parametrage.domain.AccessJournalPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the AccessJournal entity.
 */
@Repository
public interface AccessJournalRepository extends JpaRepository<AccessJournal, AccessJournalPK> {
}

