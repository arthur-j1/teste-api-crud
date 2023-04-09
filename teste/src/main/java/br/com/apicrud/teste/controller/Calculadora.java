package br.com.apicrud.teste.controller;

import org.springframework.web.bind.annotation.*;

@RestController()
public class Calculadora {


    @GetMapping("/calculadora/{id}")
    public int num(@PathVariable int id){
        return id;
    }
    
    @PostMapping("/calcular/{id1}/{id2}")
    public int calcular(@PathVariable int id1, @PathVariable int id2){
        return id1+id2;
    }





}