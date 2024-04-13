package br.com.clinicaacupuntura.sistemadeagendamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
