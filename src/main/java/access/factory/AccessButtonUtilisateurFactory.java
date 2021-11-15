package com.csys.template.access.factory;

import com.csys.template.access.domain.AccessButtonUtilisateur;
import com.csys.template.access.dto.AccessButtonDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccessButtonUtilisateurFactory {

    public static AccessButtonDTO accessbuttonutilisateurToAccessButtonUtilisateurDTO(AccessButtonUtilisateur accessbuttonutilisateur) {
        AccessButtonDTO accessbuttonutilisateurDTO = new AccessButtonDTO();
        accessbuttonutilisateurDTO.setCodeButton(accessbuttonutilisateur.getAccessButtonUtilisateurPK().getCodeButton());
        accessbuttonutilisateurDTO.setCodeModule(accessbuttonutilisateur.getAccessButtonUtilisateurPK().getCodeModule());
        accessbuttonutilisateurDTO.setCodeMenu(accessbuttonutilisateur.getAccessButtonUtilisateurPK().getCodeMenu());
        accessbuttonutilisateurDTO.setVisible(accessbuttonutilisateur.getVisible());
        accessbuttonutilisateurDTO.setButton(ButtonFactory.lazybuttonToButtonDTO(accessbuttonutilisateur.getButton()));
        accessbuttonutilisateurDTO.setUtilisateur1(UserFactory.userToUserDTO(accessbuttonutilisateur.getUtilisateur1()));
        return accessbuttonutilisateurDTO;
    }

    public static Collection<AccessButtonDTO> accessbuttonutilisateurToAccessButtonUtilisateurDTOs(Collection<AccessButtonUtilisateur> accessbuttonutilisateurs) {
        List<AccessButtonDTO> accessbuttonutilisateursDTO = new ArrayList<>();
        accessbuttonutilisateurs.forEach(x -> {
            accessbuttonutilisateursDTO.add(accessbuttonutilisateurToAccessButtonUtilisateurDTO(x));
        });
        return accessbuttonutilisateursDTO;
    }
}
