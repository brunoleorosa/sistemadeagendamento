package br.com.clinicaacupuntura.sistemadeagendamento.service;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Endereco;
import br.com.clinicaacupuntura.sistemadeagendamento.entities.Paciente;
import br.com.clinicaacupuntura.sistemadeagendamento.exceptions.PacienteNotFoundException;
import br.com.clinicaacupuntura.sistemadeagendamento.repositories.EnderecoRepository;
import br.com.clinicaacupuntura.sistemadeagendamento.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Paciente> listAll() {

        return (List<Paciente>) pacienteRepository.findAll();
    }

    public List<Paciente> listAll(String keyword) {

        if (keyword != null) return (List<Paciente>) pacienteRepository.findAll(keyword);
        return (List<Paciente>) pacienteRepository.findAll();
    }

    @Transactional
    public void save(Paciente paciente) {
        Endereco endereco = paciente.getEndereco();
        if (endereco.getId() == null || !enderecoRepository.existsById(endereco.getId())) {
            endereco = enderecoRepository.save(endereco);
        }
        paciente.setEndereco(endereco);
        pacienteRepository.save(paciente);
    }

    public Paciente get(Long id) throws PacienteNotFoundException {
        Optional<Paciente> result = pacienteRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new PacienteNotFoundException("Não foi possível encontrar um paciente com o ID: " + id + " informado.");
    }

    public void delete(Long id) throws PacienteNotFoundException {
        Long count = pacienteRepository.countById(id);
        if (count == null || count == 0) {
            throw new PacienteNotFoundException("Não foi possível encontrar um paciente com o ID: " + id + " informado.");
        }
        pacienteRepository.deleteById(id);
    }
}