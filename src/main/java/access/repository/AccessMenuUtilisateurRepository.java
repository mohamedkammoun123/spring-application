package com.csys.template.access.repository;

import com.csys.template.access.domain.AccessMenuUtilisateur;
import com.csys.template.access.domain.AccessMenuUtilisateurPK;
import com.querydsl.core.types.Predicate;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the AccessMenuUtilisateur entity.
 */
@Repository
public interface AccessMenuUtilisateurRepository extends JpaRepository<AccessMenuUtilisateur, AccessMenuUtilisateurPK>, QueryDslPredicateExecutor<AccessMenuUtilisateur> {
    @Override
    @EntityGraph(value = "AccessMenuUtilisateur.menu", type = EntityGraph.EntityGraphType.LOAD)
    public List<AccessMenuUtilisateur> findAll(Predicate predicate);
}

