package com.csys.template.parametrage.dto;

import com.csys.template.parametrage.domain.TraceJourPK;
import java.lang.String;
import java.time.LocalDateTime;
import javax.validation.constraints.Size;

public class TraceJourDTO {

    private String codJou;
    private LocalDateTime dateM;
    private String codeSoc;
    @Size(
            min = 0,
            max = 40
    )
    private String libJou;

    @Size(
            min = 0,
            max = 50
    )
    private String userName;

    @Size(
            min = 0,
            max = 1
    )
    private String type;

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
}
