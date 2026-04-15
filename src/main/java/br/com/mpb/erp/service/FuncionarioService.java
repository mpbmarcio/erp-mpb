package br.com.mpb.erp.service;

import br.com.mpb.erp.entity.Funcionario;
import br.com.mpb.erp.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> listar() {
        return repository.findAll();
    }
}
