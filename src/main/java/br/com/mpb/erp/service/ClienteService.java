package br.com.mpb.erp.service;

import br.com.mpb.erp.entity.Cliente;
import br.com.mpb.erp.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listar() {
        return repository.findAll();
    }
}
