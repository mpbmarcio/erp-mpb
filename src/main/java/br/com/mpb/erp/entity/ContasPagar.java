package br.com.mpb.erp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "contas_pagar")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContasPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", foreignKey = @ForeignKey(name = "fk_contas_pagar_fornecedor"))
    private Fornecedor fornecedor;

    private LocalDate dataLancamento;
    private String numeroDocumento;
    private LocalDate dataDocumento;
    private String totalParcelas;
    private BigDecimal valorTotal;
    private String numeroParcela;
    private BigDecimal valorParcela;
    private LocalDate dataVencimento;
    private String liquidado;
    private LocalDate dataPagamento;
    private BigDecimal valorPago;
    private LocalDate dataInc;
    private LocalDate dataAlt;
}
