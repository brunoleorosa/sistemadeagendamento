package br.com.clinicaacupuntura.sistemadeagendamento.controllers;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Endereco;
import br.com.clinicaacupuntura.sistemadeagendamento.entities.Paciente;
import br.com.clinicaacupuntura.sistemadeagendamento.exceptions.PacienteNotFoundException;
import br.com.clinicaacupuntura.sistemadeagendamento.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PacienteController {

    @Autowired private PacienteService service;

    @GetMapping("/pacientes")
    public String novoPacientes(Model model) {
        List<Paciente> pacienteList = service.listAll();
        model.addAttribute("pacienteList", pacienteList);
        return "pacientes";
    }

    @GetMapping("/pacientes/novo")
    public String novoPaciente(Model model) {

        model.addAttribute("paciente", new Paciente());
        model.addAttribute("pageTitle", "Novo Paciente");
        return "paciente_form";
    }

    @GetMapping("/pacientes/view/{id}")
    public String pacienteView(Model model, @PathVariable("id") Long id) throws PacienteNotFoundException {
        Paciente paciente = service.get(id);
        model.addAttribute("paciente", paciente);
        model.addAttribute("pageTitle", "Visualização"); 
        return "paciente_view";
    }

    @PostMapping("/pacientes/save")
    public String save(Paciente paciente, RedirectAttributes redirectAttributes) throws PacienteNotFoundException {

        try {
            if (paciente.getId() != null) {
                Paciente existente = service.get(paciente.getId());
                Endereco enderecoExistente = existente.getEndereco();

                Endereco novoEndereco = paciente.getEndereco();
                enderecoExistente.setRua(novoEndereco.getRua());
                enderecoExistente.setNumero(novoEndereco.getNumero());
                enderecoExistente.setCidade(novoEndereco.getCidade());
                enderecoExistente.setEstado(novoEndereco.getEstado());
                enderecoExistente.setCep(novoEndereco.getCep());

                paciente.setEndereco(enderecoExistente);
            }

            service.save(paciente);
            redirectAttributes.addFlashAttribute("message", "O paciente foi adicionado com sucesso!");
            return "redirect:/pacientes";

        } catch (DataIntegrityViolationException e) {
        redirectAttributes.addFlashAttribute("message", "Não foi possível cadastrar paciente. Número da carteirinha já existe");
        return "redirect:/pacientes/novo";
        }
    }

    @GetMapping("/pacientes/edit/{id}")
    public String editPaciente(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Paciente paciente = service.get(id);
            model.addAttribute("paciente", paciente);
            model.addAttribute("pageTitle", "Edite o Paciente (ID: " + id + ")");
            return "paciente_form";
        } catch (PacienteNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/pacientes";
        }
    }

    @GetMapping("/pacientes/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            service.delete(id);
            redirectAttributes.addFlashAttribute("message", "O especialista foi deletado com sucesso!");
        } catch (PacienteNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/pacientes";
    }
}