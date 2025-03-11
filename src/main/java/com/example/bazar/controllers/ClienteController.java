package com.example.bazar.controllers;

import com.example.bazar.models.Cliente;
import com.example.bazar.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    IClienteService clienteService;

    @PostMapping("/guardar")
    public String saveCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);
        return "Cliente creado exitosamente";
    }

    @GetMapping("/traer")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }

    @GetMapping("/traer/{id_cliente}")
    public Cliente getClienteById(@PathVariable Long id_cliente){
        return clienteService.getClienteById(id_cliente);
    }

    @DeleteMapping("/borrar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){

        if(this.getClienteById(id_cliente) != null){
            clienteService.deleteCliente(id_cliente);
            return "Cliente eliminado exitosamente.";
        }else{
            return "Cliente no encontrado.";
        }

    }

    @PutMapping("/editar")
    public String editCliente(@RequestBody Cliente cliente){
        clienteService.editCliente(cliente);
        return "Se ha editado exitosamente.";
    }

}
