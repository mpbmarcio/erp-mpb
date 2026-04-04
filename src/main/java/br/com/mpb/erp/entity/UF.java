package br.com.mpb.erp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ufs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private LocalDate dataInc;
    private LocalDate dataAlt;
    private String regiao;
    private String sigla;

    @OneToMany(mappedBy = "uf")
    private List<Cidade> cidades;
}