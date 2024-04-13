package br.com.clinicaacupuntura.sistemadeagendamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

}
