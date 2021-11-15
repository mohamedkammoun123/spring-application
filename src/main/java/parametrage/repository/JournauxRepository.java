package com.csys.template.parametrage.repository;

import com.csys.template.parametrage.domain.Journaux;
import com.csys.template.parametrage.domain.JournauxPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Journaux entity.
 */
@Repository
public interface JournauxRepository extends JpaRepository<Journaux, JournauxPK> , QueryDslPredicateExecutor<Journaux>{ 
      Boolean existsByJournauxPK_CodeSocAndLibJrAndJournauxPK_CodJouNot(String codeSoc, String designation, String codJou);

}
