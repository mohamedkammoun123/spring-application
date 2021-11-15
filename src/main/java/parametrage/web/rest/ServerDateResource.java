/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.parametrage.web.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrateur
 */
@RestController
@RequestMapping("/api")
public class ServerDateResource {
    @GetMapping("/server-date/date")
    public LocalDate date() {
        return LocalDate.now();
    }

    @GetMapping("/server-date/date-time")
    public LocalDateTime dateTime() {
        return LocalDateTime.now();
    }
}
