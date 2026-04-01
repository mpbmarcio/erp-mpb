package br.com.mpb.erp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table (name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate dataInc;
    private LocalDate dataAlt;
    private LocalDate dataNasc;

    private String nome;
    private String tipo;
    private String cep;
    private String nomeRua;
    private String numRua;
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "cidade_id", foreignKey = @ForeignKey(name = "fk_cliente_cidade"))
    private Cidade cidade;

    private String telefone;
    private String celular;
    private String fantasiaOuApelido;
    private String cpf;
    private String rg;
    private String email;
    private String observacao;

    @Enumerated(EnumType.STRING)
    private StatusCliente status;

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", dataInc=" + dataInc +
                ", dataAlt=" + dataAlt +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cep='" + cep + '\'' +
                ", nomeRua='" + nomeRua + '\'' +
                ", numRua='" + numRua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade=" + cidade +
                ", uf=" + cidade.getUf().getNome() +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", fantasiaOuApelido='" + fantasiaOuApelido + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", email='" + email + '\'' +
                ", observacao='" + observacao + '\'' +
                ", status=" + status +
                '}';
    }
}
