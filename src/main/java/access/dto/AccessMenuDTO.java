package com.csys.template.access.dto;

import javax.validation.constraints.NotNull;

public class AccessMenuDTO {

   private String codeMenu;

    private String codeModule;

    private String groupe;
    @NotNull
    private boolean visible;

    private MenuDTO menu;

    private GroupeUserDTO groupeUser;
    private UserDTO utilisateur1;
// 
    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public MenuDTO getMenu() {
        return menu;
    }

    public void setMenu(MenuDTO menu) {
        this.menu = menu;
    }

    public String getCodeMenu() {
        return codeMenu;
    }

    public void setCodeMenu(String codeMenu) {
        this.codeMenu = codeMenu;
    }

    public String getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(String codeModule) {
        this.codeModule = codeModule;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public GroupeUserDTO getGroupeUser() {
        return groupeUser;
    }

    public void setGroupeUser(GroupeUserDTO groupeUser) {
        this.groupeUser = groupeUser;
    }

    public UserDTO getUtilisateur1() {
        return utilisateur1;
    }

    public void setUtilisateur1(UserDTO utilisateur1) {
        this.utilisateur1 = utilisateur1;
    }

}
