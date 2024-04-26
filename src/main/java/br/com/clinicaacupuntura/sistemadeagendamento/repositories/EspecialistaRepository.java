package br.com.clinicaacupuntura.sistemadeagendamento.repositories;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Especialista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EspecialistaRepository extends JpaRepository<Especialista, Long> {

    Long countById(Long id);

    @Query("SELECT e FROM Especialista e WHERE e.nome LIKE %?1%"
            + " OR CONCAT('%', e.crm) LIKE %?1%"
            + " OR e.especialidade LIKE %?1%")
    List<Especialista> findAll(String keyword);
}