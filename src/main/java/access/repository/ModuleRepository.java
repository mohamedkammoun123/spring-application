package com.csys.template.access.repository;

import com.csys.template.access.domain.Module;
import java.lang.String;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Module entity.
 */
@Repository
public interface ModuleRepository extends JpaRepository<Module, String> {
}

