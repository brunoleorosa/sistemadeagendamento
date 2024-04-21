package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@Entity @Table(name = "Pacientes")
public class Paciente extends Pessoa {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private int numeroDeInscricao;

    @Column
    private boolean prioridade;

    @Column
    private String convenio;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Agenda> agendas;
}