package com.springcloud.store.spring_cloud_client.service;

import com.springcloud.store.spring_cloud_client.dao.IClienteDao;
import com.springcloud.store.spring_cloud_client.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplements implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    public Cliente save(Cliente producto) {
        return clienteDao.save(producto);
    }

    @Override
    public void delete(Long id) {
        Cliente cliente = clienteDao.findById(id).orElse(null);
        if (cliente == null){
            return;
        }
        cliente.setEstado("Eliminado");
        clienteDao.save(cliente);
    }

    @Override
    public Cliente findByCedula(String cedula) {
        return clienteDao.findByCedula(cedula);
    }
}
