package br.com.clinicaacupuntura.sistemadeagendamento.service;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Agenda;
import br.com.clinicaacupuntura.sistemadeagendamento.exceptions.AgendaNotFoundException;
import br.com.clinicaacupuntura.sistemadeagendamento.repositories.AgendaRepository;
import br.com.clinicaacupuntura.sistemadeagendamento.repositories.EspecialistaRepository;
import br.com.clinicaacupuntura.sistemadeagendamento.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired private AgendaRepository agendaRepository;

    @Autowired private PacienteRepository pacienteRepository;

    @Autowired private EspecialistaRepository especialistaRepository;

    public List<Agenda> listAll() { return (List<Agenda>) agendaRepository.findAll();
    }

    public void save(Agenda agenda) {
        agendaRepository.save(agenda);
    }

    public Agenda get(Long id) throws AgendaNotFoundException {
        Optional<Agenda> agenda = agendaRepository.findById(id);
        if (agenda.isPresent()) {
            return agenda.get();
        }
        throw new AgendaNotFoundException("Não foi possível encontrar o agendamento");
    }
}
