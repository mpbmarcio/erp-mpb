package br.com.mpb.erp.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.mpb.erp.entity.Categoria;

public record ProdutoResponseDTO(
        Integer id,
        LocalDate dataInc,
        LocalDate dataAlt,
        String nome,
        String ean,
        String ncm,
        Categoria categoria,
        String garantia,
        BigDecimal precoCusto,
        BigDecimal percentual,
        BigDecimal precoVenda,
        BigDecimal estoqueMinimo,
        BigDecimal estoqueDisponivel,
        Boolean relatorioEstoque
) {}
