package com.coderhouse.crudclientes.controller;

import com.coderhouse.crudclientes.model.ClienteEdad;
import com.coderhouse.crudclientes.model.ClienteEntity;
import com.coderhouse.crudclientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public List<ClienteEntity> obtenerClientes() {
        return clienteService.buscarTodos();
    }

    @GetMapping("/{dni}")
    public ClienteEdad buscarClientePorDni(@PathVariable Long dni) {
        return clienteService.buscarPorDni(dni);
    }

    @PostMapping("/actualizar")
    public ClienteEntity actualizarCliente(@RequestBody ClienteEntity cliente) throws Exception {
        return clienteService.actualizar(cliente);
    }

    @PostMapping("/crear")
    public ClienteEntity crearCliente(@RequestBody ClienteEntity cliente) throws Exception {
        return clienteService.crear(cliente);
    }
    @DeleteMapping("/{dni}")
    public void borrarCliente(@PathVariable Long dni){
        clienteService.EliminarCliente(dni);
    }

}
