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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "paramG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParamG.findAll", query = "SELECT p FROM ParamG p"),
    @NamedQuery(name = "ParamG.findByCode", query = "SELECT p FROM ParamG p WHERE p.code = :code"),
    @NamedQuery(name = "ParamG.findByValeur", query = "SELECT p FROM ParamG p WHERE p.valeur = :valeur"),
    @NamedQuery(name = "ParamG.findByDescription", query = "SELECT p FROM ParamG p WHERE p.description = :description"),
    @NamedQuery(name = "ParamG.findByNature", query = "SELECT p FROM ParamG p WHERE p.nature = :nature"),
    @NamedQuery(name = "ParamG.findByModule", query = "SELECT p FROM ParamG p WHERE p.module = :module")})
public class ParamG implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size( max = 30)
    @Column(name = "Code")
    @Id
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size( max = 300)
    @Column(name = "Valeur")
    private String valeur;
    @Size(max = 200)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size( max = 10)
    @Column(name = "Nature")
    private String nature;
    @Basic(optional = false)
    @NotNull
    @Size( max = 20)
    @Column(name = "Module")
    private String module;

    public ParamG() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
    
}
