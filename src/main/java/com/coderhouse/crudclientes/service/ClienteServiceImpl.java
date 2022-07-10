package com.coderhouse.crudclientes.service;

import com.coderhouse.crudclientes.dao.ClienteRepository;
import com.coderhouse.crudclientes.model.ClienteEdad;
import com.coderhouse.crudclientes.model.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteEdad buscarPorDni(Long dni) {


        ClienteEntity w=clienteRepository.findById(dni).orElse(null);
        if(w==null)return null;
        ClienteEdad cliente=new ClienteEdad();
        cliente.setDni(w.getDni());
        cliente.setApellido(w.getApellido());
        cliente.setNombre(w.getNombre());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(w.getFechaNac(), formatter);
        Period edad = Period.between(fechaNacimiento, LocalDate.now());
        cliente.setEdad(edad.getYears());
        return cliente;
    }

    @Override
    public List<ClienteEntity> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity crear(ClienteEntity cliente) throws Exception {
        if (buscarPorDni(cliente.getDni()) == null) {
            return clienteRepository.save(cliente);
        }
        else {
            throw new Exception( "Cliente ya existe");
        }
    }

    @Override
    public ClienteEntity actualizar(ClienteEntity cliente) throws Exception {
        if (buscarPorDni(cliente.getDni()) != null) {
            return clienteRepository.save(cliente);
        } else {
            throw new Exception( "Cliente no existe" );
        }

    }

    @Override
    public void EliminarCliente(Long dni) {
        clienteRepository.deleteById(dni);
    }
}
