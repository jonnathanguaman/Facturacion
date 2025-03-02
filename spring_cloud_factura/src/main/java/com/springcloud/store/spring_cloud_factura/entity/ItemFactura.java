package com.springcloud.store.spring_cloud_factura.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "itemFactura")
public class ItemFactura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double cantidad;
    private Double precio;
    private Long idProducto;
    @Transient
    private Double subtotal;

    public Double getSubtotal(){
        return this.cantidad * this.precio;
    }
}
