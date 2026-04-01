package br.com.mpb.erp.controller;

import br.com.mpb.erp.entity.Cliente;
import br.com.mpb.erp.repository.ClienteRepository;
import br.com.mpb.erp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    // Endpoint GET /clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return service.listar();
    }

//    Padrão de endpoints para CRUD de Cliente
//|  |  |  |  |
//        | Listar todos | GET | /clientes |  |
//            | Buscar por ID | GET | /clientes/{id} |  |
//            | Criar | POST | /clientes |  |
//            | Atualizar | PUT | /clientes/{id} |  |
//            | Remover | DELETE | /clientes/{id} |  |

}