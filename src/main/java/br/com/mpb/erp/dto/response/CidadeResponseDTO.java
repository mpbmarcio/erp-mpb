package br.com.mpb.erp.dto.response;

import java.time.LocalDate;

public record CidadeResponseDTO(
        int id,
        String nome,
        LocalDate dataInc,
        LocalDate dataAlt,
        int ufId
) {}