package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Consulta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultaId;

    @OneToOne
    private Especialista especialista;

    @OneToOne
    private Paciente paciente;

    @Column
    private LocalDate data;

    @Column
    private LocalTime hora;

    public Long getConsultaId() {
        return consultaId;
    }

    /*public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }*/

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
