package br.com.clinicaacupuntura.sistemadeagendamento.controllers;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Especialista;
import br.com.clinicaacupuntura.sistemadeagendamento.exceptions.EspecialistaNotFoundException;
import br.com.clinicaacupuntura.sistemadeagendamento.service.EspecialistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EspecialistaController {

    @Autowired private EspecialistaService service;

    @GetMapping("/especialistas")
    public String novoEspecialista(Model model){
        List<Especialista> listEspecialistas = service.listAll();
        model.addAttribute("listEspecialistas", listEspecialistas);
        return"especialistas";
    }

    @GetMapping("/especialistas/novo")
    public String showNewForm(Model model) {
        model.addAttribute("especialista", new Especialista());
        model.addAttribute("pageTitle", "Adicione Especialista");
        return "especialista_form";
    }

    @PostMapping("/especialistas/save")
    public String salvaEspecialista(Especialista especialista, RedirectAttributes ra) {
        service. save(especialista);
        ra.addFlashAttribute("message", "O especialista foi adicionado com sucesso!");
        return "redirect:/especialistas";
    }

    @GetMapping("/especialistas/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Especialista especialista = service.get(id);
            model.addAttribute("especialista", especialista);
            model.addAttribute("pageTitle", "Edite o Especialista (ID: " + id + ")");
            return "especialista_form";
        } catch (EspecialistaNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/especialistas";
        }
    }

    @GetMapping("/especialistas/delete/{id}")
    public String deleteEspecialista(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "O especialista foi deletado com sucesso!");
        } catch (EspecialistaNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/especialistas";
    }
}