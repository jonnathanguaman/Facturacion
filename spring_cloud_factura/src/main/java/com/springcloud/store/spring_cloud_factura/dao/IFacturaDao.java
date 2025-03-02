package com.springcloud.store.spring_cloud_factura.dao;

import com.springcloud.store.spring_cloud_factura.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFacturaDao extends JpaRepository<Factura,Long> {

    public List<Factura> findByIdCliente(Long id);
    public Factura findByNumeroFactura(String numeroFactura);
}
