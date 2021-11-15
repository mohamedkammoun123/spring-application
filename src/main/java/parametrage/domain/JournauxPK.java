/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.parametrage.domain;

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
public class JournauxPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size( max = 4)
    @Column(name = "CodJou", nullable = false, length = 4)
    private String codJou;
    @Basic(optional = false)
    @NotNull
    @Size( max = 3)
    @Column(name = "CodeSoc", nullable = false, length = 3)
    private String codeSoc;

    public JournauxPK() {
    }

    public JournauxPK(String codJou, String codeSoc) {
        this.codJou = codJou;
        this.codeSoc = codeSoc;
    }

    public String getCodJou() {
        return codJou;
    }

    public void setCodJou(String codJou) {
        this.codJou = codJou;
    }

    public String getCodeSoc() {
        return codeSoc;
    }

    public void setCodeSoc(String codeSoc) {
        this.codeSoc = codeSoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codJou != null ? codJou.hashCode() : 0);
        hash += (codeSoc != null ? codeSoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JournauxPK)) {
            return false;
        }
        JournauxPK other = (JournauxPK) object;
        if ((this.codJou == null && other.codJou != null) || (this.codJou != null && !this.codJou.equals(other.codJou))) {
            return false;
        }
        if ((this.codeSoc == null && other.codeSoc != null) || (this.codeSoc != null && !this.codeSoc.equals(other.codeSoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.parametrage.domain.JournauxPK[ codJou=" + codJou + ", codeSoc=" + codeSoc + " ]";
    }
    
}
