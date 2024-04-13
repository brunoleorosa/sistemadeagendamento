package br.com.clinicaacupuntura.sistemadeagendamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
