package br.com.clinicaacupuntura.sistemadeagendamento.controllers;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Agenda;
import br.com.clinicaacupuntura.sistemadeagendamento.entities.Especialista;
import br.com.clinicaacupuntura.sistemadeagendamento.entities.Paciente;
import br.com.clinicaacupuntura.sistemadeagendamento.exceptions.AgendaNotFoundException;
import br.com.clinicaacupuntura.sistemadeagendamento.exceptions.PacienteNotFoundException;
import br.com.clinicaacupuntura.sistemadeagendamento.service.AgendaService;
import br.com.clinicaacupuntura.sistemadeagendamento.service.EspecialistaService;
import br.com.clinicaacupuntura.sistemadeagendamento.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AgendaController {

    @Autowired private AgendaService agendaService;

    @Autowired private PacienteService pacienteService;

    @Autowired private EspecialistaService especialistaService;

    @GetMapping("/agenda")
    public String consultas(Model model) {
        List<Agenda> agendaList = agendaService.listAll();
        model.addAttribute("agendaList", agendaList);
        return "agenda";
    }

    @GetMapping("/agenda/novo")
    public String novo(Model model) {
        List<Paciente> pacientes = pacienteService.listAll();
        List<Especialista> especialistas = especialistaService.listAll();
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("especialistas", especialistas);
        model.addAttribute("agenda", new Agenda());
        model.addAttribute("pageTitle", "Agende uma consulta");
        return "agenda_form";
    }

    @PostMapping("/agenda/save")
    public String save(Agenda agenda, RedirectAttributes redirectAttributes) throws AgendaNotFoundException {
        try {
            agendaService.save(agenda);
            redirectAttributes.addFlashAttribute("success", "Agenda salva com sucesso!");
        } catch (DataAccessException e) {
            System.out.println("Erro ao acessar os dados: " + e.getMessage());
            throw new AgendaNotFoundException("Erro ao salvar a agenda");
        } catch (IllegalStateException e) {
            System.out.println("Erro ao invocar o método save: " + e.getMessage());
        }
        return "redirect:/agenda";
    }
    @GetMapping("/agenda/edit/{id}")
    public String editAgenda(Model model, @PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            Agenda agenda = agendaService.get(id);
            model.addAttribute("agenda", agenda);
            model.addAttribute("pageTitle", "Edite o Agendamento (ID: " + id + ")");
            return "agenda_form";
        } catch (AgendaNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/agenda";
        }
    }

    @GetMapping("/agenda/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            agendaService.delete(id);
            redirectAttributes.addFlashAttribute("message", "O agendamento foi deletado com sucesso!");
        } catch (AgendaNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/agenda";
    }

    @GetMapping("/pacientes/{id}")
    @ResponseBody
    public Paciente getPaciente(@PathVariable Long id) throws PacienteNotFoundException {
        return pacienteService.get(id);
    }
}