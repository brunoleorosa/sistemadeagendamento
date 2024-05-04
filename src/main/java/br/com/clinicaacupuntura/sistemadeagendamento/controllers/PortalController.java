package br.com.clinicaacupuntura.sistemadeagendamento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalController {

    @GetMapping("/portal")
    public String portal() { return "portal"; }
}
