package com.example.Clase1111.demo.dto;

import com.example.Clase1111.demo.entity.Entrenador;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class DeporteDTO {
    private Integer cantJugadores;
    private String nombre;
    private String descripcion;
    private List<String> entrenadores;
}
