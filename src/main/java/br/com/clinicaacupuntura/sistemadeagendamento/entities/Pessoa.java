package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public class Pessoa {

    @Getter @Setter
    @Column(length = 60, nullable = false)
    private String nome;

    @Getter @Setter
    @Temporal(TemporalType.DATE)
    private LocalDate dataDeNascimento;

    @Setter @Getter
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Endereco endereco;

    @Getter @Setter
    @Column
    private String telefone;

    @Getter @Setter
    @Column
    private String celular;

    @Getter @Setter
    @Column(length = 60)
    private String email;

    public void setDataDeNascimento(int i, int i2, int i3){
        this.dataDeNascimento = LocalDate.of(i, i2, i3);
    }
}