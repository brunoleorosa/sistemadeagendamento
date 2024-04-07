package br.com.clinicaacupuntura.sistemadeagendamento.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Endereços")
public class Endereco {

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

    public Endereco(String rua, int numero, String cidade, String estado, String cep) {
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
