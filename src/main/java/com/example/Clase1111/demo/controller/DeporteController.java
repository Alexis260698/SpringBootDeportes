package com.example.Clase1111.demo.controller;

import com.example.Clase1111.demo.entity.Deporte;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController("/deportes")
public class DeporteController {

    private ArrayList<Deporte> listaDeportes= new ArrayList<>();


    @GetMapping
    public ArrayList<Deporte> getDeportes() {
        return listaDeportes;

    }

    @PostMapping
    public void crearDeporte(Deporte deporte){
        listaDeportes.add(deporte);
    }

    @DeleteMapping
    public void eliminarDeporte(String deporte){
          Optional<Deporte> optionalDeporte=buscarDeporte(deporte);
          optionalDeporte.ifPresent(value -> listaDeportes.remove(value));
    }

    @PutMapping
    public void modificarDeporte(Deporte deporte){
        eliminarDeporte(deporte.getNombre());
        listaDeportes.add(deporte);
    }



    public Optional<Deporte> buscarDeporte(String nombre){
        return listaDeportes.stream().filter(d -> d.getNombre().equals(nombre)).findFirst();
    }


}
