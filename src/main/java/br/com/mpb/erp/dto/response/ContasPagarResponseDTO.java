package br.com.mpb.erp.dto.response;

import br.com.mpb.erp.entity.Fornecedor;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContasPagarResponseDTO(
        Integer id,
        Fornecedor fornecedor,
        LocalDate dataLancamento,
        String numeroDocumento,
        LocalDate dataDocumento,
        String totalParcelas,
        BigDecimal valorTotal,
        String numeroParcela,
        BigDecimal valorParcela,
        LocalDate dataVencimento,
        String liquidado,
        LocalDate dataPagamento,
        BigDecimal valorPago,
        LocalDate dataInc,
        LocalDate dataAlt
) {}