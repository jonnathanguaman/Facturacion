package com.springcloud.store.spring_cloud_product.Dao;

import com.springcloud.store.spring_cloud_product.entity.Categoria;
import com.springcloud.store.spring_cloud_product.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductoDao extends JpaRepository<Producto,Long> {

    public List<Producto> findByCategoria(Categoria categoria);

}
