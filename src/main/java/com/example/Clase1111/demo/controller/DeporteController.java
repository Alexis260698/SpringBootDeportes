package com.example.Clase1111.demo.controller;

import com.example.Clase1111.demo.dto.DeporteDTO;
import com.example.Clase1111.demo.entity.Deporte;
import com.example.Clase1111.demo.repostiroy.DeporteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/deportes")
public class DeporteController {

    @Autowired
    private DeporteRepository deporteRepository;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public ArrayList<Deporte> getDeportes() {
        return deporteRepository.getListaDeportes();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Deporte> getDeportes(@PathVariable String name) throws DeporteInexistenteException {
        Optional<Deporte> optionalDeporte = deporteRepository.buscarDeporte(name);
        if(optionalDeporte.isEmpty()){
            throw new DeporteInexistenteException();
        }
        return ResponseEntity.ok(optionalDeporte.get());
    }

    @PostMapping
    public void crearDeporte(DeporteDTO deporteDTO){
        /*
        Deporte deporte = new Deporte();
        deporte.setDescripcion(deporteDTO.getDescripcion());
        deporte.setNombre(deporteDTO.getNombre());
        deporte.setCantJugadores(deporteDTO.getCantJugadores());

         */

        Deporte deporte = modelMapper.map(deporteDTO, Deporte.class);
        deporteRepository.getListaDeportes().add(deporte);
    }

    @DeleteMapping
    public void eliminarDeporte(String deporte){
          Optional<Deporte> optionalDeporte= deporteRepository.buscarDeporte(deporte);
          optionalDeporte.ifPresent(value -> deporteRepository.getListaDeportes().remove(value));
    }

    @PutMapping
    public void modificarDeporte(Deporte deporte){
        eliminarDeporte(deporte.getNombre());
        deporteRepository.getListaDeportes().add(deporte);
    }






}
