package com.csys.template.access.service;

import com.csys.template.access.domain.GroupeUser;
import com.csys.template.access.dto.GroupeUserDTO;
import com.csys.template.access.factory.GroupeUserFactory;
import com.csys.template.access.repository.GroupeUserRepository;
import com.google.common.base.Preconditions;
import java.lang.String;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing GroupeUser.
 */
@Service
@Transactional
public class GroupeUserService {
  private final Logger log = LoggerFactory.getLogger(GroupeUserService.class);

  private final GroupeUserRepository groupeuserRepository;

  public GroupeUserService(GroupeUserRepository groupeuserRepository) {
    this.groupeuserRepository=groupeuserRepository;
  }

  @Transactional(
      readOnly = true
  )
  public GroupeUserDTO findOne(String id) {
    log.debug("Request to get GroupeUser: {}",id);
    GroupeUser groupeuser= groupeuserRepository.findOne(id);
    GroupeUserDTO dto = GroupeUserFactory.groupeuserToGroupeUserDTO(groupeuser);
    return dto;
  }

  @Transactional(
      readOnly = true
  )
  public GroupeUser findGroupeUser(String id) {
    log.debug("Request to get GroupeUser: {}",id);
    GroupeUser groupeuser= groupeuserRepository.findOne(id);
    return groupeuser;
  }

  @Transactional(
      readOnly = true
  )
  public Collection<GroupeUserDTO> findAll() {
    log.debug("Request to get All GroupeUsers");
    Collection<GroupeUser> result= groupeuserRepository.findAll();
    return GroupeUserFactory.groupeuserToGroupeUserDTOs(result);
  }

}

