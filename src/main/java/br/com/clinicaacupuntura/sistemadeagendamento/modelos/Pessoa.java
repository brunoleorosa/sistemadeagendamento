package br.com.clinicaacupuntura.sistemadeagendamento.modelos;

import java.time.LocalDate;

public class Pessoa {

    private String nome;
    private LocalDate dataDeNascimento;
    private Endereco endereco;
    private String telefone;
    private String celular;
    private String email;

    public Pessoa(String nome, LocalDate dataDeNascimento, Endereco endereco, 
            String telefone, String celular, String email) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", dataDeNascimento=" + dataDeNascimento + ", endereco=" + endereco
                + ", telefone=" + telefone + ", celular=" + celular + ", email=" + email + "]";
    }
}
