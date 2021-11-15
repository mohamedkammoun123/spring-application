package com.csys.template.access.repository;

import com.csys.template.access.domain.AccessButton;
import com.csys.template.access.domain.AccessButtonUtilisateurPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the AccessButton entity.
 */
@Repository
public interface AccessButtonRepository extends JpaRepository<AccessButton, AccessButtonUtilisateurPK>, QueryDslPredicateExecutor<AccessButton> {
}

