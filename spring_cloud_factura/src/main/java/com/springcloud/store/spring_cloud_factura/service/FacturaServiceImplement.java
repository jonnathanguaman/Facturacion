package com.springcloud.store.spring_cloud_factura.service;

import com.springcloud.store.spring_cloud_factura.dao.IFacturaDao;
import com.springcloud.store.spring_cloud_factura.dao.IItemFactura;
import com.springcloud.store.spring_cloud_factura.entity.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImplement implements IFacturaService{

    @Autowired
    private IFacturaDao facturaDao;

    @Autowired
    private IItemFactura itemFactura;

    @Override
    public List<Factura> findAll() {
        return facturaDao.findAll();
    }

    @Override
    public Factura findById(Long id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Override
    public Factura save(Factura factura) {
        factura.setEstado("creado");
        return facturaDao.save(factura);
    }

    @Override
    public void delete(Long id) {
        Factura factura = facturaDao.findById(id).orElse(null);
        if(factura == null){
            return;
        }
        factura.setEstado("cancelado");
        facturaDao.save(factura);
    }

    @Override
    public Factura findByNumeroFactura(String numeroFactura) {
        return facturaDao.findByNumeroFactura(numeroFactura);
    }

    @Override
    public List<Factura> findByIdCliente(Long idCliente) {
        return facturaDao.findByIdCliente(idCliente);
    }
}
