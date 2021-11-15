/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.parametrage.domain;

import com.csys.template.access.domain.User;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "ACCESS_JOURNAL")
@NamedQueries({
    @NamedQuery(name = "AccessJournal.findAll", query = "SELECT a FROM AccessJournal a")})
public class AccessJournal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccessJournalPK accessJournalPK;
    @JoinColumns({
        @JoinColumn(name = "CodJou", referencedColumnName = "CodJou", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CodeSoc", referencedColumnName = "CodeSoc", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Journaux journaux;
    @JoinColumn(name = "UserName", referencedColumnName = "username", updatable = false, insertable = false, nullable = true)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccessJournal() {
    }

    public AccessJournal(AccessJournalPK accessJournalPK) {
        this.accessJournalPK = accessJournalPK;
    }

    public AccessJournal(String userName, String codJou, String codeSoc) {
        this.accessJournalPK = new AccessJournalPK(userName, codJou, codeSoc);
    }

    public AccessJournalPK getAccessJournalPK() {
        return accessJournalPK;
    }

    public void setAccessJournalPK(AccessJournalPK accessJournalPK) {
        this.accessJournalPK = accessJournalPK;
    }

    public Journaux getJournaux() {
        return journaux;
    }

    public void setJournaux(Journaux journaux) {
        this.journaux = journaux;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessJournalPK != null ? accessJournalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessJournal)) {
            return false;
        }
        AccessJournal other = (AccessJournal) object;
        if ((this.accessJournalPK == null && other.accessJournalPK != null) || (this.accessJournalPK != null && !this.accessJournalPK.equals(other.accessJournalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.parametrage.domain.AccessJournal[ accessJournalPK=" + accessJournalPK + " ]";
    }

}
