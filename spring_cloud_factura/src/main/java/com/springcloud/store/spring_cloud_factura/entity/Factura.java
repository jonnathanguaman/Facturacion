package com.springcloud.store.spring_cloud_factura.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "factura")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroFactura;
    private String descripcion;
    private Long idCliente;
    private Date fechaCreacion;
    private String estado;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idFactura")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<ItemFactura> itemFacturas;


    @PrePersist
    public void prePersist(){
        this.fechaCreacion = new Date();
    }
}
