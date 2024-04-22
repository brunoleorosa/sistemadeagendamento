package br.com.clinicaacupuntura.sistemadeagendamento.repositories;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Agenda;
import org.springframework.data.repository.CrudRepository;

public interface AgendaRepository extends CrudRepository<Agenda, Long> {
    Long countById(Long id);
}