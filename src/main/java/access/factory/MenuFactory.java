package com.csys.template.access.factory;

import com.csys.template.access.domain.Menu;
import com.csys.template.access.dto.AccessMenuDTO;
import com.csys.template.access.dto.ButtonDTO;
import com.csys.template.access.dto.MenuDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MenuFactory {

    public static MenuDTO menuToMenuDTO(Menu menu) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setCode(menu.getMenuPK().getCode());
        menuDTO.setCodeModule(menu.getMenuPK().getCodeModule());
        menuDTO.setDesignation(menu.getDesignation());
        menuDTO.setLogo(menu.getLogo());
        menuDTO.setDesignationsec(menu.getDesignationsec());
        Collection<ButtonDTO> buttonCollectionDtos = new ArrayList<>();
        menu.getButtonCollection().forEach(x -> {
            ButtonDTO buttonDto = ButtonFactory.buttonToButtonDTO(x);
            buttonCollectionDtos.add(buttonDto);
        });
        if (menuDTO.getButtonCollection() != null) {
            menuDTO.getButtonCollection().clear();
            menuDTO.getButtonCollection().addAll(buttonCollectionDtos);
        } else {
            menuDTO.setButtonCollection(buttonCollectionDtos);
        }
        Collection<AccessMenuDTO> accessMenuUtilisateurCollectionDtos = new ArrayList<>();
        menu.getAccessMenuUtilisateurCollection().forEach(x -> {
            AccessMenuDTO accessmenuutilisateurDto = AccessMenuUtilisateurFactory.accessmenuutilisateurToAccessMenuUtilisateurDTO(x);
            accessMenuUtilisateurCollectionDtos.add(accessmenuutilisateurDto);
        });
        if (menuDTO.getAccessMenuUtilisateurCollection() != null) {
            menuDTO.getAccessMenuUtilisateurCollection().clear();
            menuDTO.getAccessMenuUtilisateurCollection().addAll(accessMenuUtilisateurCollectionDtos);
        } else {
            menuDTO.setAccessMenuUtilisateurCollection(accessMenuUtilisateurCollectionDtos);
        }
        Collection<MenuDTO> menuCollectionDtos = new ArrayList<>();
        if (menuDTO.getMenuCollection() != null) {
            menuDTO.getMenuCollection().clear();
            menuDTO.getMenuCollection().addAll(menuCollectionDtos);
        } else {
            menuDTO.setMenuCollection(menuCollectionDtos);
        }
        return menuDTO;
    }

    public static Collection<MenuDTO> menuToMenuDTOs(Collection<Menu> menus) {
        List<MenuDTO> menusDTO = new ArrayList<>();
        menus.forEach(x -> {
            menusDTO.add(menuToMenuDTO(x));
        });
        return menusDTO;
    }

    public static MenuDTO lazymenuToMenuDTO(Menu menu) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setCode(menu.getMenuPK().getCode());
        menuDTO.setCodeModule(menu.getMenuPK().getCodeModule());
        menuDTO.setDesignation(menu.getDesignation());
        menuDTO.setLogo(menu.getLogo());
        menuDTO.setDesignationsec(menu.getDesignationsec());
        return menuDTO;
    }

    public static Collection<MenuDTO> lazymenuToMenuDTOs(Collection<Menu> menus) {
        List<MenuDTO> menusDTO = new ArrayList<>();
        menus.forEach(x -> {
            menusDTO.add(lazymenuToMenuDTO(x));
        });
        return menusDTO;
    }

}
