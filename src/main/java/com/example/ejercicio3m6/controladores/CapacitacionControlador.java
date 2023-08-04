package com.example.ejercicio3m6.controladores;

import com.example.ejercicio3m6.modelos.Capacitacion;
import com.example.ejercicio3m6.dao.CapacitacionDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class CapacitacionControlador {

    @GetMapping("/crear_capacitacion")
    public String crearCapacitacion() {
        return "crear_capacitacionVista";
    }

    @GetMapping("/capacitacion")


    public String listarCapacitacion( Model m){
        CapacitacionDao capacitacionDao = new CapacitacionDao();
        List<Capacitacion> lista = capacitacionDao.obtenerCapacitaciones();
        m.addAttribute("lista" , lista);

        return "listar_capacitacionVista";
    }
}
