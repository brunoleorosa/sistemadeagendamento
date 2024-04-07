package br.com.clinicaacupuntura.sistemadeagendamento.modelos;

import java.time.LocalDate;

public class Paciente extends Pessoa {

    private int numeroDeInscricao;
    private boolean prioridade;
    private String convenio;

    public Paciente(String nome, LocalDate dataDeNascimento, Endereco endereco, String telefone, String celular,
            String email, int numeroDeInscricao, boolean prioridade, String convenio) {
        
        super(nome, dataDeNascimento, endereco, telefone, celular, email);
        this.numeroDeInscricao = numeroDeInscricao;
        this.prioridade = prioridade;
        this.convenio = convenio;
    }

    public void temPrioridade(){
        //TODO
    }

    @Override
    public String toString() {
        return "Paciente [numeroDeInscricao=" + numeroDeInscricao + ", prioridade=" + prioridade + ", convenio="
                + convenio + "]";
    }
}
