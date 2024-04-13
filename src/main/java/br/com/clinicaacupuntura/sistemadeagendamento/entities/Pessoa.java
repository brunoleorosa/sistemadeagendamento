package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public class Pessoa {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(length = 60, nullable = false)
    private String nome;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    private LocalDate dataDeNascimento;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Endereco endereco;

    @Getter
    @Setter
    @Column(length = 10)
    private String telefone;

    @Getter
    @Setter
    @Column(length = 11)
    private String celular;

    @Getter
    @Setter
    @Column(length = 60)
    private String email;

    public void setDataDeNascimento(int i, int i2, int i3){
        this.dataDeNascimento = LocalDate.of(i, i2, i3);
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", dataDeNascimento=" + dataDeNascimento + ", endereco=" + endereco
                + ", telefone=" + telefone + ", celular=" + celular + ", email=" + email + "]";
    }
}