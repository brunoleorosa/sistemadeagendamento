package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter @Getter
@Entity
public class Agenda {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    private Especialista especialista;

    @Column
    private LocalDate data;

    @Column
    private LocalTime hora;

    @Column
    private Integer numeroDeSessoes;

    @Column
    private String observacoes;
}