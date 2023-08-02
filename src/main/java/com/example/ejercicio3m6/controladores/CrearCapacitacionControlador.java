package com.example.ejercicio3m6.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CrearCapacitacionControlador {

    @GetMapping("/crear_capacitacion")
    public String crearCapacitacion() {
        return "crear_capacitacionVista";
    }
}
