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
public class ButtonPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size( max = 50)
    @Column(nullable = false, length = 50)
    private String code;
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

    public ButtonPK() {
    }

    public ButtonPK(String code, String codeMenu, String codeModule) {
        this.code = code;
        this.codeMenu = codeMenu;
        this.codeModule = codeModule;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        hash += (codeMenu != null ? codeMenu.hashCode() : 0);
        hash += (codeModule != null ? codeModule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ButtonPK)) {
            return false;
        }
        ButtonPK other = (ButtonPK) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        if ((this.codeMenu == null && other.codeMenu != null) || (this.codeMenu != null && !this.codeMenu.equals(other.codeMenu))) {
            return false;
        }
        if ((this.codeModule == null && other.codeModule != null) || (this.codeModule != null && !this.codeModule.equals(other.codeModule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.access.domain.ButtonPK[ code=" + code + ", codeMenu=" + codeMenu + ", codeModule=" + codeModule + " ]";
    }
    
}
