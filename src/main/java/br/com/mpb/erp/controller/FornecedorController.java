package br.com.mpb.erp.controller;

import br.com.mpb.erp.entity.Fornecedor;
import br.com.mpb.erp.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController{

    @Autowired
    private FornecedorService service;

    // Endpoint GET /fornecedores
    @GetMapping
    public List<Fornecedor> listar() {
        return service.listar();
    }
}
