package com.example.Clase1111.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @GetMapping("/filtrado")
    @ResponseBody
    public String getFoos(@RequestParam String nombre) {
        return "Nombre: " + nombre;
    }
}
