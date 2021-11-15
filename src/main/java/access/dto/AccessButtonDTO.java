package com.csys.template.access.dto;

import javax.validation.constraints.NotNull;

public class AccessButtonDTO {

   private String codeButton;

    private String codeModule;

    private String codeMenu;

    private String utilisateur;
    @NotNull
    private boolean visible;

    private ButtonDTO button;

    private GroupeUserDTO groupe;

    private UserDTO utilisateur1;
   
    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getCodeButton() {
        return codeButton;
    }

    public void setCodeButton(String codeButton) {
        this.codeButton = codeButton;
    }

    public String getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(String codeModule) {
        this.codeModule = codeModule;
    }

    public String getCodeMenu() {
        return codeMenu;
    }

    public void setCodeMenu(String codeMenu) {
        this.codeMenu = codeMenu;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public ButtonDTO getButton() {
        return button;
    }

    public void setButton(ButtonDTO button) {
        this.button = button;
    }

    public GroupeUserDTO getGroupe() {
        return groupe;
    }

    public void setGroupe(GroupeUserDTO groupe) {
        this.groupe = groupe;
    }

    public UserDTO getUtilisateur1() {
        return utilisateur1;
    }

    public void setUtilisateur1(UserDTO utilisateur1) {
        this.utilisateur1 = utilisateur1;
    }

}
