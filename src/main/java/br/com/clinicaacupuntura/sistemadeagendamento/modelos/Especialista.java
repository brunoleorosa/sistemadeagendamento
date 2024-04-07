package br.com.clinicaacupuntura.sistemadeagendamento.modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Especialista extends Pessoa {

    private int crm;
    private String especialidade;
    private ArrayList<LocalDate> diasDisponiveis= new ArrayList<>();
    private ArrayList<LocalTime> horariosDisponiveis = new ArrayList<>();

    public Especialista(String nome, LocalDate dataDeNascimento, Endereco endereco, String telefone, String celular,
            String email, int crm, String especialidade, ArrayList<LocalDate> diasDisponiveis, ArrayList<LocalTime> horariosDisponiveis) {
        super(nome, dataDeNascimento, endereco, telefone, celular, email);
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
