package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Endereco {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(length = 120)
    private String rua;

    @Getter @Setter
    @Column
    private int numero;

    @Getter @Setter
    @Column(length = 35)
    private String cidade;

    @Getter @Setter
    @Column(length = 20)
    private String estado;

    @Getter @Setter
    @Column(length = 9)
    private String cep;
}