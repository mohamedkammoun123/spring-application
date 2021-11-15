/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.parametrage.domain;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "Journaux")
@NamedQueries({
    @NamedQuery(name = "Journaux.findAll", query = "SELECT j FROM Journaux j")})
public class Journaux implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JournauxPK journauxPK;
    @Basic(optional = false)
    @NotNull
    @Size( max = 30)
    @Column(name = "LibJr", nullable = false, length = 30)
    private String libJr;
    @Size(max = 10)
    @Column(name = "NumCpt", length = 10)
    private String numCpt;
    @Basic(optional = false)
    @NotNull
    @Size( max = 1)
    @Column(name = "TypeSaisie", nullable = false, length = 1)
    private String typeSaisie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Controle", nullable = false)
    private boolean controle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Manuelle", nullable = false)
    private boolean manuelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "controleUser", nullable = false)
    private boolean controleUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journaux", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AccessJournal> accessJournalList;
    @Basic(optional = false)
    @Size(max = 2)
    @Column(name = "[order]", nullable = false, length = 2)
    private String order;

    public Journaux() {
    }

    public Journaux(JournauxPK journauxPK) {
        this.journauxPK = journauxPK;
    }

    public Journaux(JournauxPK journauxPK, String libJr, String typeSaisie, boolean controle, boolean manuelle, boolean controleUser) {
        this.journauxPK = journauxPK;
        this.libJr = libJr;
        this.typeSaisie = typeSaisie;
        this.controle = controle;
        this.manuelle = manuelle;
        this.controleUser = controleUser;
    }


    public Journaux(String codJou, String codeSoc) {
        this.journauxPK = new JournauxPK(codJou, codeSoc);
    }

    public JournauxPK getJournauxPK() {
        return journauxPK;
    }

    public void setJournauxPK(JournauxPK journauxPK) {
        this.journauxPK = journauxPK;
    }

    public String getLibJr() {
        return libJr;
    }

    public void setLibJr(String libJr) {
        this.libJr = libJr;
    }

    public String getNumCpt() {
        return numCpt;
    }

    public void setNumCpt(String numCpt) {
        this.numCpt = numCpt;
    }

    public String getTypeSaisie() {
        return typeSaisie;
    }

    public void setTypeSaisie(String typeSaisie) {
        this.typeSaisie = typeSaisie;
    }

    public boolean getControle() {
        return controle;
    }

    public void setControle(boolean controle) {
        this.controle = controle;
    }

    public boolean getManuelle() {
        return manuelle;
    }

    public void setManuelle(boolean manuelle) {
        this.manuelle = manuelle;
    }

    public boolean getControleUser() {
        return controleUser;
    }

    public void setControleUser(boolean controleUser) {
        this.controleUser = controleUser;
    }


    public List<AccessJournal> getAccessJournalList() {
        return accessJournalList;
    }

    public void setAccessJournalList(List<AccessJournal> accessJournalList) {
        this.accessJournalList = accessJournalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (journauxPK != null ? journauxPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Journaux)) {
            return false;
        }
        Journaux other = (Journaux) object;
        if ((this.journauxPK == null && other.journauxPK != null) || (this.journauxPK != null && !this.journauxPK.equals(other.journauxPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.parametrage.domain.Journaux[ journauxPK=" + journauxPK + " ]";
    }



    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

}
