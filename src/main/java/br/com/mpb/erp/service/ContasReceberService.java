package br.com.mpb.erp.service;

import br.com.mpb.erp.entity.ContasReceber;
import br.com.mpb.erp.repository.ContasReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContasReceberService {

    @Autowired
    private ContasReceberRepository repository;

    public List<ContasReceber> listar() {
        return repository.findAll();
    }
}
