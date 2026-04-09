package br.com.mpb.erp.dto.response;

import java.time.LocalDate;

public record FormaPagamentoResponseDTO(
        Integer id,
        String nome,
        LocalDate dataInc,
        LocalDate dataAlt
) {}
