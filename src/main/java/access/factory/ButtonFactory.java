package com.csys.template.access.factory;

import com.csys.template.access.domain.Button;
import com.csys.template.access.dto.AccessButtonDTO;
import com.csys.template.access.dto.ButtonDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ButtonFactory {

    public static ButtonDTO buttonToButtonDTO(Button button) {
        ButtonDTO buttonDTO = new ButtonDTO();
        buttonDTO.setCode(button.getButtonPK().getCode());
        buttonDTO.setCodeMenu(button.getButtonPK().getCodeMenu());
        buttonDTO.setCodeModule(button.getButtonPK().getCodeModule());
        buttonDTO.setDesignation(button.getDesignation());
        buttonDTO.setDesignationsec(button.getDesignationsec());
        buttonDTO.setLogo(button.getLogo());
        buttonDTO.setOrderButton(button.getOrderButton());
        Collection<AccessButtonDTO> accessButtonUtilisateurCollectionDtos = new ArrayList<>();
        button.getAccessButtonUtilisateurCollection().forEach(x -> {
            AccessButtonDTO accessbuttonutilisateurDto = AccessButtonUtilisateurFactory.accessbuttonutilisateurToAccessButtonUtilisateurDTO(x);
            accessButtonUtilisateurCollectionDtos.add(accessbuttonutilisateurDto);
        });
        if (buttonDTO.getAccessButtonUtilisateurCollection() != null) {
            buttonDTO.getAccessButtonUtilisateurCollection().clear();
            buttonDTO.getAccessButtonUtilisateurCollection().addAll(accessButtonUtilisateurCollectionDtos);
        } else {
            buttonDTO.setAccessButtonUtilisateurCollection(accessButtonUtilisateurCollectionDtos);
        }      
        return buttonDTO;
    }

    public static Collection<ButtonDTO> buttonToButtonDTOs(Collection<Button> buttons) {
        List<ButtonDTO> buttonsDTO = new ArrayList<>();
        buttons.forEach(x -> {
            buttonsDTO.add(buttonToButtonDTO(x));
        });
        return buttonsDTO;
    }

    public static ButtonDTO lazybuttonToButtonDTO(Button button) {
        ButtonDTO buttonDTO = new ButtonDTO();
        buttonDTO.setCode(button.getButtonPK().getCode());
        buttonDTO.setCodeMenu(button.getButtonPK().getCodeMenu());
        buttonDTO.setCodeModule(button.getButtonPK().getCodeModule());
        buttonDTO.setDesignation(button.getDesignation());
        buttonDTO.setDesignationsec(button.getDesignationsec());
        buttonDTO.setLogo(button.getLogo());
        buttonDTO.setOrderButton(button.getOrderButton());
        return buttonDTO;
    }

    public static Collection<ButtonDTO> lazybuttonToButtonDTOs(Collection<Button> buttons) {
        List<ButtonDTO> buttonsDTO = new ArrayList<>();
        buttons.forEach(x -> {
            buttonsDTO.add(lazybuttonToButtonDTO(x));
        });
        return buttonsDTO;
    }
}
