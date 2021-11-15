package com.csys.template.access.repository;

import com.csys.template.access.domain.Menu;
import com.csys.template.access.domain.MenuPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Menu entity.
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, MenuPK> , QueryDslPredicateExecutor<Menu> {
}

