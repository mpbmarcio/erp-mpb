package br.com.mpb.erp.dto.response;

import java.time.LocalDate;
import br.com.mpb.erp.entity.Cidade;

public record EmpresaResponseDTO(
        Integer id,
        LocalDate dataInc,
        LocalDate dataAlt,
        LocalDate dataFund,
        String nome,
        String nomeRua,
        String numRua,
        String bairro,
        String cep,
        String telefone,
        String celular,
        String fantasia,
        String cnpj,
        String ie,
        String email,
        Cidade cidade
) {}
