package com.springcloud.store.spring_cloud_factura.dao;

import com.springcloud.store.spring_cloud_factura.entity.ItemFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemFactura extends JpaRepository<ItemFactura,Long> {
}
