package br.com.mpb.erp.service;

import br.com.mpb.erp.entity.Empresa;
import br.com.mpb.erp.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public List<Empresa> listar() {
        return repository.findAll();
    }
}
