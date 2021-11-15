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
public class AccessMenuUtilisateurPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size( max = 50)
    @Column(name = "code_menu", nullable = false, length = 50)
    private String codeMenu;
    @Basic(optional = false)
    @NotNull
    @Size( max = 3)
    @Column(name = "code_module", nullable = false, length = 3)
    private String codeModule;
    @Basic(optional = false)
    @NotNull
    @Size( max = 20)
    @Column(nullable = false, length = 20)
    private String utilisateur;

    public AccessMenuUtilisateurPK() {
    }

    public AccessMenuUtilisateurPK(String codeMenu, String codeModule, String utilisateur) {
        this.codeMenu = codeMenu;
        this.codeModule = codeModule;
        this.utilisateur = utilisateur;
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

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeMenu != null ? codeMenu.hashCode() : 0);
        hash += (codeModule != null ? codeModule.hashCode() : 0);
        hash += (utilisateur != null ? utilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessMenuUtilisateurPK)) {
            return false;
        }
        AccessMenuUtilisateurPK other = (AccessMenuUtilisateurPK) object;
        if ((this.codeMenu == null && other.codeMenu != null) || (this.codeMenu != null && !this.codeMenu.equals(other.codeMenu))) {
            return false;
        }
        if ((this.codeModule == null && other.codeModule != null) || (this.codeModule != null && !this.codeModule.equals(other.codeModule))) {
            return false;
        }
        if ((this.utilisateur == null && other.utilisateur != null) || (this.utilisateur != null && !this.utilisateur.equals(other.utilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.access.domain.AccessMenuUtilisateurPK[ codeMenu=" + codeMenu + ", codeModule=" + codeModule + ", utilisateur=" + utilisateur + " ]";
    }
    
}
