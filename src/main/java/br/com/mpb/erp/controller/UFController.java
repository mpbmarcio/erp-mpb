package br.com.mpb.erp.controller;

import br.com.mpb.erp.entity.UF;
import br.com.mpb.erp.service.UFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ufs")
public class UFController {

    @Autowired
    private UFService service;

    @GetMapping
    public List<UF> listar() {
        return service.listar();
    }
}
