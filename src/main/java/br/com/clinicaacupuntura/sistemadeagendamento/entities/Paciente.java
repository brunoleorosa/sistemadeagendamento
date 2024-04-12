package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pacientes")
public class Paciente extends Pessoa {

    @Column(name = "Número de Inscrição")
    private int numeroDeInscricao;

    @Column
    private boolean prioridade;

    @Column
    private String convenio;

    public void temPrioridade(){
        //TODO
    }

    @Override
    public String toString() {
        return "Paciente [numeroDeInscricao=" + numeroDeInscricao + ", prioridade=" + prioridade + ", convenio="
                + convenio + "]";
    }
}
