package com.springcloud.store.spring_cloud_product;

import com.springcloud.store.spring_cloud_product.Dao.IProductoDao;
import com.springcloud.store.spring_cloud_product.entity.Categoria;
import com.springcloud.store.spring_cloud_product.entity.Producto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductoDaoMockTest {

    @Autowired
    private IProductoDao productoDao;

    @Test
    public void cuandoBuscamosByCategoria_thenReturnListProductos(){

        Categoria categoria = Categoria.builder()
                .id(1L)
                .nombre("tecnologia")
                .build();

        Producto producto = Producto.builder()
                .nombre("computadora")
                .descripcion("")
                .categoria(categoria)
                .stock(Double.parseDouble("18"))
                .precio(Double.parseDouble("1250"))
                .estado("Creado")
                .fecha_creacion(new Date())
                .build();

        productoDao.save(producto);

        List<Producto> founds = productoDao.findByCategoria(producto.getCategoria());

        Assertions.assertThat(founds.size()).isEqualTo(1);
    }
}
