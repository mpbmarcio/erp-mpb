package br.com.mpb.erp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "cidades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "uf_id", foreignKey = @ForeignKey(name = "fk_cidade_uf"))
    private UF uf;
    private LocalDate dataInc;
    private LocalDate dataAlt;
}
