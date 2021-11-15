package com.csys.template.access.factory;

import com.csys.template.access.domain.AccessMenuUtilisateur;
import com.csys.template.access.dto.AccessMenuDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccessMenuUtilisateurFactory {

    public static AccessMenuDTO accessmenuutilisateurToAccessMenuUtilisateurDTO(AccessMenuUtilisateur accessmenuutilisateur) {
        AccessMenuDTO accessmenuutilisateurDTO = new AccessMenuDTO();
        accessmenuutilisateurDTO.setCodeMenu(accessmenuutilisateur.getAccessMenuUtilisateurPK().getCodeMenu());
        accessmenuutilisateurDTO.setCodeModule(accessmenuutilisateur.getAccessMenuUtilisateurPK().getCodeModule());
        accessmenuutilisateurDTO.setVisible(accessmenuutilisateur.getVisible());
        accessmenuutilisateurDTO.setMenu(MenuFactory.lazymenuToMenuDTO(accessmenuutilisateur.getMenu()));
        accessmenuutilisateurDTO.setUtilisateur1(UserFactory.userToUserDTO(accessmenuutilisateur.getUtilisateur1()));
        return accessmenuutilisateurDTO;
    }

    public static Collection<AccessMenuDTO> accessmenuutilisateurToAccessMenuUtilisateurDTOs(Collection<AccessMenuUtilisateur> accessmenuutilisateurs) {
        List<AccessMenuDTO> accessmenuutilisateursDTO = new ArrayList<>();
        accessmenuutilisateurs.forEach(x -> {
            accessmenuutilisateursDTO.add(accessmenuutilisateurToAccessMenuUtilisateurDTO(x));
        });
        return accessmenuutilisateursDTO;
    }
}
