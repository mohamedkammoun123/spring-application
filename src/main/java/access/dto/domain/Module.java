/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.access.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "Module")
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m")})
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size( max = 3)
    @Column(name = "NumModule")
    private String numModule;
    @Size(max = 100)
    @Column(name = "DesModule")
    private String desModule;
    @Basic(optional = false)
    @NotNull
    @Size( max = 3)
    @Column(name = "CodeModule")
    private String codeModule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Revision")
    private int revision;
    @Basic(optional = false)
    @NotNull
    @Size( max = 50)
    @Column(name = "Grp")
    private String grp;
    @Basic(optional = false)
    @NotNull
    @Size( max = 50)
    @Column(name = "Chemin")
    private String chemin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Afficher")
    private boolean afficher;
    @Lob
    @Column(name = "Image")
    private byte[] image;
    @Size(max = 50)
    @Column(name = "NomImage")
    private String nomImage;
    @Basic(optional = false)
    @NotNull
    @Size( max = 20)
    @Column(name = "Processus_Name")
    private String processusName;
    @Basic(optional = false)
    @NotNull
    @Size( max = 50)
    @Column(name = "Version_Database")
    private String versionDatabase;
    @Basic(optional = false)
    @NotNull
    @Size( max = 50)
    @Column(name = "descModule")
    private String descModule;
    @Size(max = 1073741823)
    @Column(name = "DesModuleBrut")
    private String desModuleBrut;
    @Basic(optional = false)
    @NotNull
    @Size( max = 200)
    @Column(name = "centres")
    private String centres;
    @Basic(optional = false)
    @NotNull
    @Size( max = 10)
    @Column(name = "Version_Module")
    private String versionModule;
    @Size(max = 100)
    @Column(name = "designation_sec")
    private String designationSec;

    public Module() {
    }

    public String getNumModule() {
        return numModule;
    }

    public void setNumModule(String numModule) {
        this.numModule = numModule;
    }

    public String getDesModule() {
        return desModule;
    }

    public void setDesModule(String desModule) {
        this.desModule = desModule;
    }

    public String getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(String codeModule) {
        this.codeModule = codeModule;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public boolean getAfficher() {
        return afficher;
    }

    public void setAfficher(boolean afficher) {
        this.afficher = afficher;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }

    public String getProcessusName() {
        return processusName;
    }

    public void setProcessusName(String processusName) {
        this.processusName = processusName;
    }

    public String getVersionDatabase() {
        return versionDatabase;
    }

    public void setVersionDatabase(String versionDatabase) {
        this.versionDatabase = versionDatabase;
    }

    public String getDescModule() {
        return descModule;
    }

    public void setDescModule(String descModule) {
        this.descModule = descModule;
    }

    public String getDesModuleBrut() {
        return desModuleBrut;
    }

    public void setDesModuleBrut(String desModuleBrut) {
        this.desModuleBrut = desModuleBrut;
    }

    public String getCentres() {
        return centres;
    }

    public void setCentres(String centres) {
        this.centres = centres;
    }

    public String getVersionModule() {
        return versionModule;
    }

    public void setVersionModule(String versionModule) {
        this.versionModule = versionModule;
    }

    public String getDesignationSec() {
        return designationSec;
    }

    public void setDesignationSec(String designationSec) {
        this.designationSec = designationSec;
    }

}
