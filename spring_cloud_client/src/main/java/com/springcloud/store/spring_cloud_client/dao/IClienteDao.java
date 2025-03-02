package com.springcloud.store.spring_cloud_client.dao;

import com.springcloud.store.spring_cloud_client.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClienteDao extends JpaRepository<Cliente,Long> {
    public Cliente findByCedula(String celuda);
}
