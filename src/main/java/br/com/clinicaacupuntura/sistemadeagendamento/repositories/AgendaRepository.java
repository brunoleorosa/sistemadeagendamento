package br.com.clinicaacupuntura.sistemadeagendamento.repositories;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Agenda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    Long countById(Long id);

    @Query("SELECT a FROM Agenda a WHERE a.especialista.nome LIKE %?1%"
            + " OR a.paciente.nome LIKE %?1%"
            + " OR concat('%', a.data) LIKE %?1%")
    List<Agenda> findAll(String keyword);
}