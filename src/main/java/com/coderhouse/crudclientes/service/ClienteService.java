package com.coderhouse.crudclientes.service;

import com.coderhouse.crudclientes.model.ClienteEntity;
import com.coderhouse.crudclientes.model.ClienteEdad;
import java.util.List;

public interface ClienteService {

    ClienteEdad buscarPorDni(Long dni);
    List<ClienteEntity> buscarTodos();
    ClienteEntity crear(ClienteEntity cliente) throws Exception;
    ClienteEntity actualizar(ClienteEntity cliente) throws Exception;
    void EliminarCliente(Long dni);
}
