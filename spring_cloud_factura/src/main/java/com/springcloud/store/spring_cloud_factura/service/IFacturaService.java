package com.springcloud.store.spring_cloud_factura.service;

import com.springcloud.store.spring_cloud_factura.entity.Factura;

import java.util.List;

public interface IFacturaService {

    public List<Factura> findAll();
    public Factura findById(Long id);
    public Factura save(Factura factura);
    public void delete(Long id);
    public Factura findByNumeroFactura(String numeroFactura);
    public List<Factura> findByIdCliente(Long idCliente);
}
