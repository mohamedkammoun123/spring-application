/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.access.web.rest;

/**
 *
 * @author DELL
 */
import com.csys.template.access.dto.UserDTO;
import com.csys.template.access.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRessource {

    private final UserService userService;

    public UserRessource(UserService utilisateurService) {
        this.userService = utilisateurService;
    }

    @GetMapping("/utilisateur")
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/utilisateur/is-authenticated")
    public UserDTO isAuthenticated() {
        return userService.findUser();
    }
}
