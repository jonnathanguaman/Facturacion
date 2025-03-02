package com.springcloud.store.spring_cloud_client.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String email;
    private String urlFoto;
    private String estado = "Creado";

    private Date fecha_creacion = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRegion")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Region region;
}
