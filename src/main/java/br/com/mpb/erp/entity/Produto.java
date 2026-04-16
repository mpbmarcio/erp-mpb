package br.com.mpb.erp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dataInc;
    private LocalDate dataAlt;
    private String nome;
    private String ean;
    private String ncm;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private String garantia;
    private BigDecimal precoCusto;
    private BigDecimal percentual;
    private BigDecimal precoVenda;
    private BigDecimal estoqueMinimo;
    private BigDecimal estoqueDisponivel;

    private Boolean relatorioEstoque; // true = sim, false = não
}

