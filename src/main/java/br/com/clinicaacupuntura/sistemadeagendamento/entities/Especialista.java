package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Especialistas")
public class Especialista extends Pessoa {

    @Column
    private int crm;

    @Column (length = 60)
    private String especialidade;

    private ArrayList<LocalDate> diasDisponiveis= new ArrayList<>();
    private ArrayList<LocalTime> horariosDisponiveis = new ArrayList<>();

    @Override
    public String toString() {
        return "Especialista [crm=" + crm + ", especialidade=" + especialidade + ", diasDisponiveis=" + diasDisponiveis
                + ", horariosDisponiveis=" + horariosDisponiveis + ", toString()=" + super.toString() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + "]";
    }
}
