package br.com.clinicaacupuntura.sistemadeagendamento.controllers;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Endereco;
import br.com.clinicaacupuntura.sistemadeagendamento.entities.Especialista;
import br.com.clinicaacupuntura.sistemadeagendamento.entities.Paciente;
import br.com.clinicaacupuntura.sistemadeagendamento.exceptions.EspecialistaNotFoundException;
import br.com.clinicaacupuntura.sistemadeagendamento.exceptions.PacienteNotFoundException;
import br.com.clinicaacupuntura.sistemadeagendamento.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/pacientes/save")
    public String save(Paciente paciente, RedirectAttributes redirectAttributes) throws PacienteNotFoundException {

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
        redirectAttributes.addFlashAttribute("message", "O especialista foi adicionado com sucesso!");
        return "redirect:/pacientes";
    }
}
