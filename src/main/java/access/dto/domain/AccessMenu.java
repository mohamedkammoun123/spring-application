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
@Table(name = "Acces_Menu")
@NamedEntityGraphs({
    @NamedEntityGraph(name = "AccessMenu.menu",
            attributeNodes = {
                @NamedAttributeNode("menu")
            })
})
public class AccessMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccessMenuPK accessMenuPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean visible;
    @JoinColumns({
        @JoinColumn(name = "code_menu", referencedColumnName = "Code", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "code_module", referencedColumnName = "code_module", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Menu menu;
    @JoinColumn(name = "groupe", referencedColumnName = "groupe", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GroupeUser groupe;

    public AccessMenu() {
    }

    public AccessMenu(AccessMenuPK accessMenuPK) {
        this.accessMenuPK = accessMenuPK;
    }

    public AccessMenu(AccessMenuPK accessMenuPK, boolean visible) {
        this.accessMenuPK = accessMenuPK;
        this.visible = visible;
    }

    public AccessMenu(String codeMenu, String codeModule, String groupe) {
        this.accessMenuPK = new AccessMenuPK(codeMenu, codeModule, groupe);
    }

    public AccessMenuPK getAccessMenuPK() {
        return accessMenuPK;
    }

    public void setAccessMenuPK(AccessMenuPK accessMenuPK) {
        this.accessMenuPK = accessMenuPK;
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
  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessMenuPK != null ? accessMenuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessMenu)) {
            return false;
        }
        AccessMenu other = (AccessMenu) object;
        if ((this.accessMenuPK == null && other.accessMenuPK != null) || (this.accessMenuPK != null && !this.accessMenuPK.equals(other.accessMenuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.access.domain.AccessMenuUtilisateur[ accessMenuUtilisateurPK=" + accessMenuPK + " ]";
    }

    public GroupeUser getGroupe() {
        return groupe;
    }

    public void setGroupe(GroupeUser groupe) {
        this.groupe = groupe;
    }
    
}
