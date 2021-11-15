/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.parametrage.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DELL
 */
@Embeddable
public class TraceJourPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size( max = 4)
    @Column(name = "CodJou")
    private String codJou;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateM", nullable = false)
    private LocalDateTime dateM;
    @Basic(optional = false)
    @NotNull
    @Size( max = 3)
    @Column(name = "CodeSoc")
    private String codeSoc;

    @PrePersist
    void prePersist() {
        this.dateM = LocalDateTime.now();
    }

    public TraceJourPK() {
    }

    public TraceJourPK(String codJou, LocalDateTime dateM, String codeSoc) {
        this.codJou = codJou;
        this.dateM = dateM;
        this.codeSoc = codeSoc;
    }

    public String getCodJou() {
        return codJou;
    }

    public void setCodJou(String codJou) {
        this.codJou = codJou;
    }

    public LocalDateTime getDateM() {
        return dateM;
    }

    public void setDateM(LocalDateTime dateM) {
        this.dateM = dateM;
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
        hash += (dateM != null ? dateM.hashCode() : 0);
        hash += (codeSoc != null ? codeSoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraceJourPK)) {
            return false;
        }
        TraceJourPK other = (TraceJourPK) object;
        if ((this.codJou == null && other.codJou != null) || (this.codJou != null && !this.codJou.equals(other.codJou))) {
            return false;
        }
        if ((this.dateM == null && other.dateM != null) || (this.dateM != null && !this.dateM.equals(other.dateM))) {
            return false;
        }
        if ((this.codeSoc == null && other.codeSoc != null) || (this.codeSoc != null && !this.codeSoc.equals(other.codeSoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.parametrage.domain.TraceJourPK[ codJou=" + codJou + ", dateM=" + dateM + ", codeSoc=" + codeSoc + " ]";
    }

}
