package br.com.mpb.erp.controller;

import br.com.mpb.erp.entity.Cidade;
import br.com.mpb.erp.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService service;

    // Endpoint GET /clientes
    @GetMapping
    public List<Cidade> listarClientes() {
        return service.listar();
    }
}
