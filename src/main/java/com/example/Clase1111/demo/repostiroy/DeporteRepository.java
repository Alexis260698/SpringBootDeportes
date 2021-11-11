package com.example.Clase1111.demo.repostiroy;

import com.example.Clase1111.demo.entity.Deporte;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
@Getter @Setter
public class DeporteRepository {

    private ArrayList<Deporte> listaDeportes= new ArrayList<>();

    public Optional<Deporte> buscarDeporte(String nombre){
        return listaDeportes.stream().filter(d -> d.getNombre().equals(nombre)).findFirst();
    }

}
