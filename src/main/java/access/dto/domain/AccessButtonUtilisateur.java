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
@Table(name = "Access_Button_Utilisateur")
@NamedEntityGraphs({
    @NamedEntityGraph(name = "AccessButtonUtilisateur.button",
            attributeNodes = {
                @NamedAttributeNode("button")
            })
})
public class AccessButtonUtilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccessButtonUtilisateurPK accessButtonUtilisateurPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean visible;
    @JoinColumns({
        @JoinColumn(name = "code_button", referencedColumnName = "Code", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "code_menu", referencedColumnName = "code_menu", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "code_module", referencedColumnName = "code_module", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Button button;
    @JoinColumn(name = "Utilisateur", referencedColumnName = "UserName", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User utilisateur1;

    public AccessButtonUtilisateur() {
    }

    public AccessButtonUtilisateur(AccessButtonUtilisateurPK accessButtonUtilisateurPK) {
        this.accessButtonUtilisateurPK = accessButtonUtilisateurPK;
    }

    public AccessButtonUtilisateur(AccessButtonUtilisateurPK accessButtonUtilisateurPK, boolean visible) {
        this.accessButtonUtilisateurPK = accessButtonUtilisateurPK;
        this.visible = visible;
    }

    public AccessButtonUtilisateur(String codeButton, String codeModule, String codeMenu, String utilisateur) {
        this.accessButtonUtilisateurPK = new AccessButtonUtilisateurPK(codeButton, codeModule, codeMenu, utilisateur);
    }

    public AccessButtonUtilisateurPK getAccessButtonUtilisateurPK() {
        return accessButtonUtilisateurPK;
    }

    public void setAccessButtonUtilisateurPK(AccessButtonUtilisateurPK accessButtonUtilisateurPK) {
        this.accessButtonUtilisateurPK = accessButtonUtilisateurPK;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
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
        hash += (accessButtonUtilisateurPK != null ? accessButtonUtilisateurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessButtonUtilisateur)) {
            return false;
        }
        AccessButtonUtilisateur other = (AccessButtonUtilisateur) object;
        if ((this.accessButtonUtilisateurPK == null && other.accessButtonUtilisateurPK != null) || (this.accessButtonUtilisateurPK != null && !this.accessButtonUtilisateurPK.equals(other.accessButtonUtilisateurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.access.domain.AccessButtonUtilisateur[ accessButtonUtilisateurPK=" + accessButtonUtilisateurPK + " ]";
    }
    
}
