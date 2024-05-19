package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@Entity @Table(name = "Especialistas")
public class Especialista extends Pessoa {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long crm;

    @Column (length = 60)
    private String especialidade;

    @OneToMany(mappedBy = "especialista", cascade = CascadeType.ALL)
    private List<Agenda> agendas;
}