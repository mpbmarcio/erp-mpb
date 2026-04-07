package br.com.mpb.erp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "contas_receber")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContasReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numeroDocumento;
    private LocalDate dataEmissao;

    @ManyToOne
    @JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "fk_contas_receber_cliente"))
    private Cliente cliente;

    private String totalParcelas;
    private BigDecimal valorTotal;
    private String numeroParcela;
    private LocalDate dataVencimento;
    private BigDecimal valorParcela;
    private BigDecimal jurosParcela;
    private BigDecimal parcelaCorrigida;
    private String liquidado;
    private LocalDate dataPagamento;

    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento", foreignKey = @ForeignKey(name = "fk_contas_pagar_forma_pagamento"))
    private FormaPagamento formaPagamento;

    private BigDecimal valorPago;
    private LocalDate dataAlt;
    private LocalDate dataInc;
}