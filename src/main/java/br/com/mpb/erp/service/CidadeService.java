package br.com.mpb.erp.service;

import br.com.mpb.erp.entity.Cidade;
import br.com.mpb.erp.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public List<Cidade> listar() {
        return repository.findAll();
    }
}
