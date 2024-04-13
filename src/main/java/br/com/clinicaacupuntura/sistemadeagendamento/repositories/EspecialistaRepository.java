package br.com.clinicaacupuntura.sistemadeagendamento.repositories;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Especialista;
import org.springframework.data.repository.CrudRepository;

public interface EspecialistaRepository extends CrudRepository<Especialista, Long> {
    public Long countById(Long id);
}