package br.com.clinicaacupuntura.sistemadeagendamento.service;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Agenda;
import br.com.clinicaacupuntura.sistemadeagendamento.exceptions.AgendaNotFoundException;
import br.com.clinicaacupuntura.sistemadeagendamento.repositories.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired private AgendaRepository agendaRepository;

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

    public void delete(Long id) throws AgendaNotFoundException {
        Long count = agendaRepository.countById(id);
        if (count == null || count == 0) {
            throw new AgendaNotFoundException("Não foi possível encontrar agendamento informado.");
        }
        agendaRepository.deleteById(id);
    }
}
