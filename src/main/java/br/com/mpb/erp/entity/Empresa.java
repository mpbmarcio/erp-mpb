package br.com.mpb.erp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "empresas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dataInc;
    private LocalDate dataAlt;
    private LocalDate dataFund;

    private String nome;
    private String cep;
    private String nomeRua;
    private String numRua;
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "cidade_id", foreignKey = @ForeignKey(name = "fk_empresa_cidade"))
    private Cidade cidade;

    private String telefone;
    private String celular;
    private String fantasia;
    private String cnpj;
    private String ie;
    private String email;

    @Lob
    private byte[] logo;

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cidade=" + cidade +
                ", uf=" + cidade.getUf().getNome() +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
