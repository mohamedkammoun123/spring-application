package com.csys.template.access.repository;

import com.csys.template.access.domain.AccessButtonUtilisateur;
import com.csys.template.access.domain.AccessButtonUtilisateurPK;
import com.querydsl.core.types.Predicate;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the AccessButtonUtilisateur entity.
 */
@Repository
public interface AccessButtonUtilisateurRepository extends JpaRepository<AccessButtonUtilisateur, AccessButtonUtilisateurPK>, QueryDslPredicateExecutor<AccessButtonUtilisateur> {

    @Override
    @EntityGraph(value = "AccessButtonUtilisateur.button", type = EntityGraph.EntityGraphType.LOAD)
    public List<AccessButtonUtilisateur> findAll(Predicate predicate);
}
