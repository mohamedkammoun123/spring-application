package com.csys.template.access.dto;

import com.csys.template.access.domain.Menu;
import com.csys.template.access.domain.MenuPK;
import com.csys.template.access.domain.Module;
import java.lang.String;
import java.util.Collection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MenuDTO {

    private String code;
    private String codeModule;
    @NotNull
    @Size(
            
            max = 200
    )
    private String designation;

    @Size(
            min = 0,
            max = 50
    )
    private String logo;

    @Size(
            min = 0,
            max = 100
    )
    private String designationsec;

    private Collection<ButtonDTO> buttonCollection;

    private Collection<AccessMenuDTO> accessMenuUtilisateurCollection;

    private Collection<MenuDTO> menuCollection;

    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(String codeModule) {
        this.codeModule = codeModule;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDesignationsec() {
        return designationsec;
    }

    public void setDesignationsec(String designationsec) {
        this.designationsec = designationsec;
    }

    public Collection<ButtonDTO> getButtonCollection() {
        return buttonCollection;
    }

    public void setButtonCollection(Collection<ButtonDTO> buttonCollection) {
        this.buttonCollection = buttonCollection;
    }

    public Collection<AccessMenuDTO> getAccessMenuUtilisateurCollection() {
        return accessMenuUtilisateurCollection;
    }

    public void setAccessMenuUtilisateurCollection(Collection<AccessMenuDTO> accessMenuUtilisateurCollection) {
        this.accessMenuUtilisateurCollection = accessMenuUtilisateurCollection;
    }

    public Collection<MenuDTO> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<MenuDTO> menuCollection) {
        this.menuCollection = menuCollection;
    }

}
