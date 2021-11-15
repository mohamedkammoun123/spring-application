package com.csys.template.access.repository;

import com.csys.template.access.domain.Button;
import com.csys.template.access.domain.ButtonPK;
import com.csys.template.access.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Button entity.
 */
@Repository
public interface ButtonRepository extends JpaRepository<Button, ButtonPK>  , QueryDslPredicateExecutor<Button>{
}

