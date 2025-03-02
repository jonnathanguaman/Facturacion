package com.springcloud.store.spring_cloud_client.service;

import com.springcloud.store.spring_cloud_client.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> findAll();
    public Cliente findById(Long id);
    public Cliente save(Cliente producto);
    public void delete(Long id);
    public Cliente findByCedula(String cedula);
}
