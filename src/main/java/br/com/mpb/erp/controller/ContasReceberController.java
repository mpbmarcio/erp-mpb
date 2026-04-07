package br.com.mpb.erp.controller;

import br.com.mpb.erp.entity.ContasReceber;
import br.com.mpb.erp.service.ContasReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contas-receber")
public class ContasReceberController {

    @Autowired
    private ContasReceberService service;

    // Endpoint GET /contas-receber
    @GetMapping
    public List<ContasReceber> listar() {
        return service.listar();
    }
}
