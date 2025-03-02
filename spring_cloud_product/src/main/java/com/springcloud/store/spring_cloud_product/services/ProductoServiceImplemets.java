package com.springcloud.store.spring_cloud_product.services;

import com.springcloud.store.spring_cloud_product.Dao.IProductoDao;
import com.springcloud.store.spring_cloud_product.entity.Categoria;
import com.springcloud.store.spring_cloud_product.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductoServiceImplemets implements IProductoService {

    @Autowired
    private IProductoDao productoDao;

    @Override
    public List<Producto> findAll() {
        return productoDao.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public void delete(Long id) {
        Producto producto = productoDao.findById(id).orElse(null);
        if (producto == null){
            return;
        }
        producto.setEstado("Eliminado   ");
        productoDao.save(producto);
    }

    @Override
    public List<Producto> findByCategoria(Categoria categoria) {
        return productoDao.findByCategoria(categoria);
    }

    @Override
    public Producto updateStock(Long id, Double cantidad) {
        Producto producto = productoDao.findById(id).orElse(null);
        if (producto == null){
            return null;
        }

        Double stock = producto.getStock() + cantidad;
        producto.setStock(stock);
        return productoDao.save(producto);
    }
}
