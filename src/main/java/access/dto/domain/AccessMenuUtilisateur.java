/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.access.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "Access_Menu_Utilisateur")
@NamedEntityGraphs({
    @NamedEntityGraph(name = "AccessMenuUtilisateur.menu",
            attributeNodes = {
                @NamedAttributeNode("menu")
            })
})
public class AccessMenuUtilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccessMenuUtilisateurPK accessMenuUtilisateurPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean visible;
    @JoinColumns({
        @JoinColumn(name = "code_menu", referencedColumnName = "Code", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "code_module", referencedColumnName = "code_module", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Menu menu;
    @JoinColumn(name = "Utilisateur", referencedColumnName = "UserName", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User utilisateur1;

    public AccessMenuUtilisateur() {
    }

    public AccessMenuUtilisateur(AccessMenuUtilisateurPK accessMenuUtilisateurPK) {
        this.accessMenuUtilisateurPK = accessMenuUtilisateurPK;
    }

    public AccessMenuUtilisateur(AccessMenuUtilisateurPK accessMenuUtilisateurPK, boolean visible) {
        this.accessMenuUtilisateurPK = accessMenuUtilisateurPK;
        this.visible = visible;
    }

    public AccessMenuUtilisateur(String codeMenu, String codeModule, String utilisateur) {
        this.accessMenuUtilisateurPK = new AccessMenuUtilisateurPK(codeMenu, codeModule, utilisateur);
    }

    public AccessMenuUtilisateurPK getAccessMenuUtilisateurPK() {
        return accessMenuUtilisateurPK;
    }

    public void setAccessMenuUtilisateurPK(AccessMenuUtilisateurPK accessMenuUtilisateurPK) {
        this.accessMenuUtilisateurPK = accessMenuUtilisateurPK;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public User getUtilisateur1() {
        return utilisateur1;
    }

    public void setUtilisateur1(User utilisateur1) {
        this.utilisateur1 = utilisateur1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessMenuUtilisateurPK != null ? accessMenuUtilisateurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessMenuUtilisateur)) {
            return false;
        }
        AccessMenuUtilisateur other = (AccessMenuUtilisateur) object;
        if ((this.accessMenuUtilisateurPK == null && other.accessMenuUtilisateurPK != null) || (this.accessMenuUtilisateurPK != null && !this.accessMenuUtilisateurPK.equals(other.accessMenuUtilisateurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.access.domain.AccessMenuUtilisateur[ accessMenuUtilisateurPK=" + accessMenuUtilisateurPK + " ]";
    }
    
}
