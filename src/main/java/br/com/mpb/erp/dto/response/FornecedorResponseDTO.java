package br.com.mpb.erp.dto.response;

import java.time.LocalDate;

public record FornecedorResponseDTO(
        Integer id,
        LocalDate dataInc,
        LocalDate dataAlt,
        String nome,
        String cnpj,
        String ie,
        String cep,
        String nomeRua,
        String numRua,
        String bairro,
        String cidade,
        String telefone,
        String cel,
        String contato,
        String email,
        String www
) {}
