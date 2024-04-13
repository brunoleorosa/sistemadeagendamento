package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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

    @Column
    private int crm;

    @Column (length = 60)
    private String especialidade;

    @Setter
    @Getter
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Endereco endereco;

    private ArrayList<LocalDate> diasDisponiveis= new ArrayList<>();
    private ArrayList<LocalTime> horariosDisponiveis = new ArrayList<>();
}