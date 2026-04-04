package br.com.mpb.erp.service;

import br.com.mpb.erp.entity.ContasPagar;
import br.com.mpb.erp.repository.ContasPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContasPagarService {

    @Autowired
    private ContasPagarRepository repository;

    public List<ContasPagar> listar() {
        return repository.findAll();
    }
}
