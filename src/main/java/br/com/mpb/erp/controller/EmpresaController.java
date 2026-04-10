package br.com.mpb.erp.controller;

import br.com.mpb.erp.entity.Empresa;
import br.com.mpb.erp.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @GetMapping
    public List<Empresa> listar() {
        return service.listar();
    }
}
