package com.springcloud.store.spring_cloud_product.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.store.spring_cloud_product.entity.Categoria;
import com.springcloud.store.spring_cloud_product.entity.Producto;
import com.springcloud.store.spring_cloud_product.error.ErrorMessage;
import com.springcloud.store.spring_cloud_product.services.IProductoService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;


    @GetMapping
    public ResponseEntity<List<Producto>> listaProductos(@RequestParam(name = "idCategoria",required = false) Long idCategoria){

        List<Producto>  productos = new ArrayList<>();
        if(idCategoria == null){
            productos = productoService.findAll();
            if(productos.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }else{
            productos = productoService.findByCategoria(Categoria.builder().id(idCategoria).build());
            if(productos.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }

        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable("id") Long id){
        Producto producto = productoService.findById(id);

        if(producto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@Valid @RequestBody Producto producto, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }

        Producto producto1 = productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto1);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable("id") Long id){
        productoService.delete(id);
    }

    private String formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messsage(errors).build();

        //Tranforma el objeto a un string
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {

            jsonString = mapper.writeValueAsString(errorMessage);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return jsonString;
    }
}
