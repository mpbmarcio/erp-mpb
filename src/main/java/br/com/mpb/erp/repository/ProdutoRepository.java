package br.com.mpb.erp.repository;

import br.com.mpb.erp.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
