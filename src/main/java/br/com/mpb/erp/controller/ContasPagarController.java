package br.com.mpb.erp.controller;

import br.com.mpb.erp.entity.ContasPagar;
import br.com.mpb.erp.service.ContasPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contas-pagar")
public class ContasPagarController {

    @Autowired
    private ContasPagarService service;

    @GetMapping
    public List<ContasPagar> listar() {
        return service.listar();
    }
}
