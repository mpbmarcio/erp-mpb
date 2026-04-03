package br.com.mpb.erp.controller;

import br.com.mpb.erp.entity.Cliente;
import br.com.mpb.erp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    // Endpoint GET /clientes
    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }
}