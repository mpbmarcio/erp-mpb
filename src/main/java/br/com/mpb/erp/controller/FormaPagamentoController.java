package br.com.mpb.erp.controller;

import br.com.mpb.erp.entity.FormaPagamento;
import br.com.mpb.erp.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService service;

    @GetMapping
    public List<FormaPagamento> listar() {
        return service.listar();
    }
}
