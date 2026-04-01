package br.com.mpb.erp.dto.response;

import java.time.LocalDate;

public record UFResponseDTO(
        int id,
        String nome,
        String uf,
        String regiao,
        LocalDate dataInc,
        LocalDate dataAlt
) {}