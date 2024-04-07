package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@MappedSuperclass
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    private LocalDate dataDeNascimento;

    @Column(length = 120, nullable = false)
    private Endereco endereco;

    @Column(length = 10)
    private String telefone;

    @Column(length = 11)
    private String celular;

    @Column(length = 60)
    private String email;

    public Pessoa(Long id, String nome, LocalDate dataDeNascimento, Endereco endereco, 
            String telefone, String celular, String email) {
        this.id = id;
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
