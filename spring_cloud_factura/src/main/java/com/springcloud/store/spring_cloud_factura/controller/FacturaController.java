package com.springcloud.store.spring_cloud_factura.controller;

import com.springcloud.store.spring_cloud_factura.entity.Factura;
import com.springcloud.store.spring_cloud_factura.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private IFacturaService facturaService;

    @GetMapping
    public ResponseEntity<List<Factura>> listaDeFacturas(){
        return ResponseEntity.ok(facturaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> buscarFacturaById(@PathVariable Long id){
        return ResponseEntity.ok(facturaService.findById(id));
    }

    @GetMapping("/buscarPorNumero/{numeroFactura}")
    public ResponseEntity<Factura> buscarPorNumero(@PathVariable String numeroFactura){
        Factura factura = facturaService.findByNumeroFactura(numeroFactura);
        return ResponseEntity.ok(factura);
    }

    @GetMapping("/listaDeFacturasPorCliente/{id}")
    public ResponseEntity<List<Factura>> listaDeFacturasPorCliente(@PathVariable  Long id){
        return ResponseEntity.ok(facturaService.findByIdCliente(id));
    }

    @PostMapping
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura){
        return ResponseEntity.ok(facturaService.save(factura));
    }

    @DeleteMapping("/{id}")
    public void eliminar(Long id){
        facturaService.delete(id);
    }

}
