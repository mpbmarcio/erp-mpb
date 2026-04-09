package br.com.mpb.erp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "formas_pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private LocalDate dataInc;
    private LocalDate dataAlt;
}
