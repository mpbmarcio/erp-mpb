package br.com.mpb.erp.dto.response;

import java.time.LocalDate;

public record ClienteResponseDTO(
        int id,
        LocalDate dataInc,
        LocalDate dataAlt,
        String nome,
        String tipo,
        String cep,
        String nomeRua,
        String numRua,
        String bairro,
        int cidadeId,
        String telefone,
        String celular,
        String fantasiaOuApelido,
        String cpf,
        String rg,
        String email,
        String observacao,
        String status
) {}