package com.example.Clase1111.demo.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Deporte {
    private Integer cantJugadores;
    private String nombre;
    private String descripcion;
    private List<Entrenador> entrenadores;

}
