/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.parametrage.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "Trace_Jour")
@NamedQueries({
    @NamedQuery(name = "TraceJour.findAll", query = "SELECT t FROM TraceJour t")})
public class TraceJour implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TraceJourPK traceJourPK;
    @Size(max = 40)
    @Column(name = "LibJou")
    private String libJou;
    @Size(max = 50)
    @Column(name = "UserName")
    private String userName;
    @Size(max = 1)
    @Column(name = "Type")
    private String type;

    @PrePersist
    void prePersist() {
        this.userName = SecurityContextHolder.getContext().getAuthentication().getName();

    }

    public TraceJour() {
    }

    public TraceJour(TraceJourPK traceJourPK) {
        this.traceJourPK = traceJourPK;
    }

    public TraceJour(String codJou, LocalDateTime dateM, String codeSoc) {
        this.traceJourPK = new TraceJourPK(codJou, dateM, codeSoc);
    }

    public TraceJourPK getTraceJourPK() {
        return traceJourPK;
    }

    public void setTraceJourPK(TraceJourPK traceJourPK) {
        this.traceJourPK = traceJourPK;
    }

    public String getLibJou() {
        return libJou;
    }

    public void setLibJou(String libJou) {
        this.libJou = libJou;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traceJourPK != null ? traceJourPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraceJour)) {
            return false;
        }
        TraceJour other = (TraceJour) object;
        if ((this.traceJourPK == null && other.traceJourPK != null) || (this.traceJourPK != null && !this.traceJourPK.equals(other.traceJourPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.parametrage.domain.TraceJour[ traceJourPK=" + traceJourPK + " ]";
    }

}
