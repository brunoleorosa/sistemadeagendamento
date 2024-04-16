package br.com.clinicaacupuntura.sistemadeagendamento.repositories;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {

    Long countById(Long id);
}