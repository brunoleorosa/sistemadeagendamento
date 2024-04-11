package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@MappedSuperclass
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    private LocalDate dataDeNascimento;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", dataDeNascimento=" + dataDeNascimento + ", endereco=" + endereco
                + ", telefone=" + telefone + ", celular=" + celular + ", email=" + email + "]";
    }
}
