package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Especialistas")
public class Especialista extends Pessoa {

    @Column
    private int crm;

    @Column (length = 60)
    private String especialidade;

    private ArrayList<LocalDate> diasDisponiveis= new ArrayList<>();
    private ArrayList<LocalTime> horariosDisponiveis = new ArrayList<>();

    public Especialista(Long id, String nome, LocalDate dataDeNascimento, Endereco endereco, String telefone, String celular,
            String email, int crm, String especialidade, ArrayList<LocalDate> diasDisponiveis, ArrayList<LocalTime> horariosDisponiveis) {
        super(id, nome, dataDeNascimento, endereco, telefone, celular, email);
        this.crm = crm;
        this.especialidade = especialidade;
        this.diasDisponiveis = diasDisponiveis;
        this.horariosDisponiveis = horariosDisponiveis;
    }

    @Override
    public String toString() {
        return "Especialista [crm=" + crm + ", especialidade=" + especialidade + ", diasDisponiveis=" + diasDisponiveis
                + ", horariosDisponiveis=" + horariosDisponiveis + ", toString()=" + super.toString() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + "]";
    }

}
