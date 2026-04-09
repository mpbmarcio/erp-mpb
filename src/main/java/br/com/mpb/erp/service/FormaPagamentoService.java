package br.com.mpb.erp.service;

import br.com.mpb.erp.entity.FormaPagamento;
import br.com.mpb.erp.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository repository;

    public List<FormaPagamento> listar() {
        return repository.findAll();
    }
}
