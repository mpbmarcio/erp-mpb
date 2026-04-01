package br.com.mpb.erp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "fornecedores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dataInc;
    private LocalDate dataAlt;

    @Column(nullable = false, length = 100)
    private String nome;

    private String cnpj;
    private String ie;
    private String cep;
    private String nomeRua;
    private String numRua;
    private String bairro;

    @Column(name = "cidade_uf")
    private String cidade;

    private String telefone;
    private String cel;
    private String contato;
    private String email;
    private String www;
}