/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.access.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Embeddable
public class AccessButtonUtilisateurPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size( max = 50)
    @Column(name = "code_button", nullable = false, length = 50)
    private String codeButton;
    @Basic(optional = false)
    @NotNull
    @Size( max = 3)
    @Column(name = "code_module", nullable = false, length = 3)
    private String codeModule;
    @Basic(optional = false)
    @NotNull
    @Size( max = 50)
    @Column(name = "code_menu", nullable = false, length = 50)
    private String codeMenu;
    @Basic(optional = false)
    @NotNull
    @Size( max = 20)
    @Column(nullable = false, length = 20)
    private String utilisateur;

    public AccessButtonUtilisateurPK() {
    }

    public AccessButtonUtilisateurPK(String codeButton, String codeModule, String codeMenu, String utilisateur) {
        this.codeButton = codeButton;
        this.codeModule = codeModule;
        this.codeMenu = codeMenu;
        this.utilisateur = utilisateur;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeButton != null ? codeButton.hashCode() : 0);
        hash += (codeModule != null ? codeModule.hashCode() : 0);
        hash += (codeMenu != null ? codeMenu.hashCode() : 0);
        hash += (utilisateur != null ? utilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessButtonUtilisateurPK)) {
            return false;
        }
        AccessButtonUtilisateurPK other = (AccessButtonUtilisateurPK) object;
        if ((this.codeButton == null && other.codeButton != null) || (this.codeButton != null && !this.codeButton.equals(other.codeButton))) {
            return false;
        }
        if ((this.codeModule == null && other.codeModule != null) || (this.codeModule != null && !this.codeModule.equals(other.codeModule))) {
            return false;
        }
        if ((this.codeMenu == null && other.codeMenu != null) || (this.codeMenu != null && !this.codeMenu.equals(other.codeMenu))) {
            return false;
        }
        if ((this.utilisateur == null && other.utilisateur != null) || (this.utilisateur != null && !this.utilisateur.equals(other.utilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.access.domain.AccessButtonUtilisateurPK[ codeButton=" + codeButton + ", codeModule=" + codeModule + ", codeMenu=" + codeMenu + ", utilisateur=" + utilisateur + " ]";
    }
    
}
