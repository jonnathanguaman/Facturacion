package com.springcloud.spring_cloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "greeting")
public class GreetignController {

    //AtomicLong: es como una función en la que cada que queramos un numero diferente este nos genera
    private final AtomicLong counter = new AtomicLong();

    //%s: Asigana el valor que llega de la ruta al saludo de forma dimanica
    private static final String templete = "Hola mundo %s";

    @GetMapping
    public Greeting saludar(@RequestParam(value = "name",defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),String.format(templete,name));
    }
}
