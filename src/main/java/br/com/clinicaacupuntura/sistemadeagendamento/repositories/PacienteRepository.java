package br.com.clinicaacupuntura.sistemadeagendamento.repositories;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Long countById(Long id);

    @Query("SELECT p FROM Paciente p WHERE p.nome LIKE %?1%"
            + " OR CONCAT('%', p.numeroDeInscricao) LIKE %?1%"
            + " OR p.convenio LIKE %?1%")
    List<Paciente> findAll(String keyword);
}