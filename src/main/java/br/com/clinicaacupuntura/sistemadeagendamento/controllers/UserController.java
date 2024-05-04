package br.com.clinicaacupuntura.sistemadeagendamento.controllers;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.UserModel;
import br.com.clinicaacupuntura.sistemadeagendamento.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new UserModel());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute UserModel userModel) {
        userService.register(userModel);
        return "redirect:/login?success";
    }
}