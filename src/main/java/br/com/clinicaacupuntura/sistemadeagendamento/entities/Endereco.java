package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enderecoId;

    @Column(length = 120)
    private String rua;

    @Column
    private int numero;

    @Column(length = 35)
    private String cidade;

    @Column(length = 20)
    private String estado;

    @Column(length = 9)
    private String cep;

    public Endereco(Long enderecoId, String rua, int numero, String cidade, String estado, String cep) {
        this.enderecoId = enderecoId;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Endereco [rua=" + rua + ", numero=" + numero + ", cidade=" + cidade + ", estado=" + estado + ", cep="
                + cep + "]";
    }
}
