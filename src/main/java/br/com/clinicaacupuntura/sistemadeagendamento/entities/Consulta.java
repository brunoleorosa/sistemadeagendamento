package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Entity
public class Consulta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultaId;

    @Setter
    @OneToOne
    private Especialista especialista;

    @Setter
    @OneToOne
    private Paciente paciente;

    @Setter
    @Column
    private LocalDate data;

    @Setter
    @Column
    private LocalTime hora;

    /*public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }*/

}
