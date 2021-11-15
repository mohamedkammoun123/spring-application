package com.csys.template.access.factory;

import com.csys.template.access.domain.GroupeUser;
import com.csys.template.access.dto.GroupeUserDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GroupeUserFactory {
  public static GroupeUserDTO groupeuserToGroupeUserDTO(GroupeUser groupeuser) {
    GroupeUserDTO groupeuserDTO=new GroupeUserDTO();
    groupeuserDTO.setGroupe(groupeuser.getGroupe());
    groupeuserDTO.setDescription(groupeuser.getDescription());
    groupeuserDTO.setActif(groupeuser.getActif());
    return groupeuserDTO;
  }

  public static GroupeUser groupeuserDTOToGroupeUser(GroupeUserDTO groupeuserDTO) {
    GroupeUser groupeuser=new GroupeUser();
    groupeuser.setGroupe(groupeuserDTO.getGroupe());
    groupeuser.setDescription(groupeuserDTO.getDescription());
    groupeuser.setActif(groupeuserDTO.getActif());
    return groupeuser;
  }

  public static Collection<GroupeUserDTO> groupeuserToGroupeUserDTOs(Collection<GroupeUser> groupeusers) {
    List<GroupeUserDTO> groupeusersDTO=new ArrayList<>();
    groupeusers.forEach(x -> {
      groupeusersDTO.add(groupeuserToGroupeUserDTO(x));
    } );
    return groupeusersDTO;
  }
}

