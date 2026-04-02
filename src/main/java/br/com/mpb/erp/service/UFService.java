package br.com.mpb.erp.service;

import br.com.mpb.erp.entity.UF;
import br.com.mpb.erp.repository.UFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UFService {

    @Autowired
    private UFRepository repository;

    public List<UF> listar() {
        return repository.findAll();
    }
}
