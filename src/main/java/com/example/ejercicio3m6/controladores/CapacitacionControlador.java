package com.example.ejercicio3m6.controladores;

import com.example.ejercicio3m6.modelos.Capacitacion;

import com.example.ejercicio3m6.dao.CapacitacionDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class CapacitacionControlador {

    @GetMapping("/crear_capacitacion")
    public String crearCapacitacion() {
        return "crear_capacitacionVista";
    }

    @PostMapping("/crearCapacitacion")
    public String crearCapacitacion(@RequestParam("nombre") String nombre, @RequestParam("detalle") String detalle, @RequestParam("rutCliente") String rutCliente, @RequestParam("diaSemana") String diaSemana, @RequestParam("hora") String hora, @RequestParam("lugar") String lugar, @RequestParam("duracion") String duracion, @RequestParam("cantAsistentes") int cantAsistentes) {
        // Crea un objeto Capacitacion con los datos recibidos
        Capacitacion capacitacion = new Capacitacion(0,nombre, detalle, rutCliente, diaSemana, hora, lugar, duracion, cantAsistentes);
        // Lógica para guardar la capacitación en el listado o en una base de datos
        return "redirect:/listadoCapacitaciones"; // Redirige a la página de listado de capacitaciones
    }

    @GetMapping("/capacitacion")
    public String listarCapacitacion( Model m){
        CapacitacionDao capacitacionDao = new CapacitacionDao();
        List<Capacitacion> lista = capacitacionDao.obtenerCapacitaciones();
        m.addAttribute("lista" , lista);

        return "listar_capacitacionVista";
    }
    @PostMapping("/capacitacion")
    public String grabarCapacitacion (@RequestParam ("nombre") String nombre,
                                      @RequestParam ("detalle") String detalle,
                                      @RequestParam ("rutCliente") String rut,
                                      @RequestParam ("diaSemana") String dia,
                                      @RequestParam ("hora") String hora,
                                      @RequestParam ("lugar") String lugar,
                                      @RequestParam ("duracion") String duracion,
                                      @RequestParam ("cantAsistentes") int asistentes,
                                      Model m) {
        Capacitacion capacitacion = new Capacitacion(0, nombre, detalle, rut, dia, hora, lugar, duracion, asistentes);
        CapacitacionDao capacitacionDao = new CapacitacionDao();
        boolean creado = capacitacionDao.crearCapacitacion(capacitacion);
        return "listar_capacitacionVista";
    }
}