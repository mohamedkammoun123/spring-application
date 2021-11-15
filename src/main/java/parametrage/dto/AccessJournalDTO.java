package com.csys.template.parametrage.dto;

import com.csys.template.access.dto.UserDTO;

public class AccessJournalDTO {

    private String userName;
    private String codJou;
    private String codeSoc;

    private JournauxDTO journaux;
    private UserDTO user;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

 

    public JournauxDTO getJournaux() {
        return journaux;
    }

    public void setJournaux(JournauxDTO journaux) {
        this.journaux = journaux;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
    
    
}
