package com.csys.template.parametrage.dto;

import java.lang.String;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class JournauxDTO {

    @NotNull
    @Size( max = 4)
    private String codJou;

    @NotNull
    @Size( max = 4)
    private String codeSoc;

    @Size(
            min = 0,
            max = 40
    )
    private String libJr;

    @Size(
            min = 0,
            max = 10
    )
    private String numCpt;

    @NotNull
    @Size(
            
            max = 1
    )
    private String typeSaisie;

    @NotNull
    private boolean controle;

    @NotNull
    private boolean manuelle;

    @NotNull
    private boolean controleUser;

    private String nomSoc;
    private List<AccessJournalDTO> accessJournalList;

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

    public String getNomSoc() {
        return nomSoc;
    }

    public void setNomSoc(String nomSoc) {
        this.nomSoc = nomSoc;
    }

    public List<AccessJournalDTO> getAccessJournalList() {
        return accessJournalList;
    }

    public void setAccessJournalList(List<AccessJournalDTO> accessJournalList) {
        this.accessJournalList = accessJournalList;
    }

}
