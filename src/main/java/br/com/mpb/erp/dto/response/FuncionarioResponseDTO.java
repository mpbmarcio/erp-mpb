package br.com.mpb.erp.dto.response;

import java.time.LocalDate;
import java.math.BigDecimal;

public record FuncionarioResponseDTO(
        Integer id,
        String nome,
        BigDecimal percentual,
        LocalDate dataInc,
        LocalDate dataAlt,
        String celular,
        String telefone
) {}
