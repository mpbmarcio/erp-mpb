package br.com.mpb.erp.dto.response;

import br.com.mpb.erp.entity.Cliente;
import br.com.mpb.erp.entity.FormaPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContasReceberResponseDTO(
        Integer id,
        Integer numeroDocumento,
        LocalDate dataEmissao,
        Cliente cliente,
        String totalParcelas,
        BigDecimal valorTotal,
        String numeroParcela,
        LocalDate dataVencimento,
        BigDecimal valorParcela,
        BigDecimal jurosParcela,
        BigDecimal parcelaCorrigida,
        String liquidado,
        LocalDate dataPagamento,
        FormaPagamento formaPagamento,
        BigDecimal valorPago,
        LocalDate dataAlt,
        LocalDate dataInc
) {}