package com.springcloud.store.spring_cloud_product.services;

import com.springcloud.store.spring_cloud_product.entity.Categoria;
import com.springcloud.store.spring_cloud_product.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();
    public Producto findById(Long id);
    public Producto save(Producto producto);
    public void delete(Long id);
    public List<Producto> findByCategoria(Categoria categoria);
    public Producto updateStock(Long id, Double cantidad);
}
