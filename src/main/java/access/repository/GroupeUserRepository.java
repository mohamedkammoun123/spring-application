package com.csys.template.access.repository;

import com.csys.template.access.domain.GroupeUser;
import java.lang.Boolean;
import java.lang.String;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the GroupeUser entity.
 */
@Repository
public interface GroupeUserRepository extends JpaRepository<GroupeUser, String> {
  Collection<GroupeUser> findByActif(Boolean actif);
}

