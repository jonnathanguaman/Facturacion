package com.springcloud.store.spring_cloud_client.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.store.spring_cloud_client.entity.Cliente;
import com.springcloud.store.spring_cloud_client.error.ErrorMessage;
import com.springcloud.store.spring_cloud_client.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listaClientes(){
        List<Cliente> clienteList = clienteService.findAll();
        if (clienteList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clienteList);
    }

    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<Cliente> findByCedula(@PathVariable String cedula){
        Cliente cliente = clienteService.findByCedula(cedula);
        if (cliente == null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Cliente cliente = clienteService.findById(id);

        if (cliente == null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        Cliente cliente1 = clienteService.save(cliente);
        return ResponseEntity.ok(cliente1);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        clienteService.delete(id);
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
