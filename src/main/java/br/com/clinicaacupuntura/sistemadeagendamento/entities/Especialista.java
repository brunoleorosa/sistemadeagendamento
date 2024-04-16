package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Especialistas")
public class Especialista extends Pessoa {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private int crm;

    @Column (length = 60)
    private String especialidade;
}