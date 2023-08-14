package com.example.ejercicio3m6.controladores;

import com.example.ejercicio3m6.modelos.Capacitacion;

import com.example.ejercicio3m6.dao.CapacitacionDao;
import com.example.ejercicio3m6.servicios.ConvertirHoraServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.util.logging.*;
import java.util.List;


@Controller
public class CapacitacionControlador {

    private final static Logger LOG_MONITOREO = Logger.getLogger("com.example.ejercicio3m6.controladores");

    @GetMapping("/crear_capacitacion")
    public String crearCapacitacion() {
        LOG_MONITOREO.log(Level.INFO, "CapacitacionControlador : crear capacitacion formulario");
        return "crear_capacitacionVista";
    }

    @Autowired
    private ConvertirHoraServicio convertirHoraServicio;

    @PostMapping("/crearCapacitacion")
    public String crearCapacitacion(@RequestParam("nombre") String nombre,
                                    @RequestParam("detalle") String detalle,
                                    @RequestParam("rutCliente") String rutCliente,
                                    @RequestParam("diaSemana") String diaSemana,
                                    @RequestParam("hora") String horaCadena,
                                    @RequestParam("lugar") String lugar,
                                    @RequestParam("duracion") String duracionCadena,
                                    @RequestParam("cantAsistentes") Integer cantAsistentes) {
        // Crea un objeto Capacitacion con los datos recibidos
        Time hora = convertirHoraServicio.convertirCadenaAHora(horaCadena);
        Time duracion = convertirHoraServicio.convertirCadenaAHora(duracionCadena);

        try {
            LOG_MONITOREO.log(Level.INFO, "CapacitacionControlador : crear capacitacion POST");
            Capacitacion capacitacion = new Capacitacion(0, nombre, detalle, rutCliente, diaSemana, hora, lugar, duracion, cantAsistentes);
            CapacitacionDao capacitacionDao = new CapacitacionDao();
            boolean creado = capacitacionDao.crearCapacitacion(capacitacion);

            // Lógica para guardar la capacitación en el listado o en una base de datos
            LOG_MONITOREO.log(Level.INFO, "CapacitacionControlador : Se guardó la capacitación");
            return "redirect:/capacitacion"; // Redirige a la página de listado de capacitaciones
        }catch( Exception e){
            LOG_MONITOREO.log(Level.WARNING, "CapacitacionControladorError :" +  e.getMessage());
            return "redirect:/capacitacion";
        }


    }

    @GetMapping("/capacitacion")
    public String listarCapacitacion( Model m){
        LOG_MONITOREO.log(Level.INFO, "CacitacionControlador : LISTAR CAPACITACIONES");

        try {
            CapacitacionDao capacitacionDao = new CapacitacionDao();
            List<Capacitacion> lista = capacitacionDao.obtenerCapacitaciones();
            m.addAttribute("lista", lista);

            return "listar_capacitacionVista";
        }catch( Exception e){
            LOG_MONITOREO.log(Level.WARNING, "CapacitacionControlador Listar Error :" +  e.getMessage());
            return "listar_capacitacionVista";
        }
    }
    @PostMapping("/capacitacion")
    public String grabarCapacitacion (@RequestParam ("nombre") String nombre,
                                      @RequestParam ("detalle") String detalle,
                                      @RequestParam ("rutCliente") String rut,
                                      @RequestParam ("diaSemana") String dia,
                                      @RequestParam ("hora") String horaCadenaa,
                                      @RequestParam ("lugar") String lugar,
                                      @RequestParam ("duracion") String duracionCadena,
                                      @RequestParam ("cantAsistentes") Integer asistentes,
                                      Model m) {
        Time hora = convertirHoraServicio.convertirCadenaAHora(horaCadenaa);
        Time duracion = convertirHoraServicio.convertirCadenaAHora(duracionCadena);

        try {
            LOG_MONITOREO.log(Level.INFO, "CapacitacionControlador : crear capacitacion POST");
            Capacitacion capacitacion = new Capacitacion(0, nombre, detalle, rut, dia, hora, lugar, duracion, asistentes);
            CapacitacionDao capacitacionDao = new CapacitacionDao();
            boolean creado = capacitacionDao.crearCapacitacion(capacitacion);

            List<Capacitacion> lista = capacitacionDao.obtenerCapacitaciones();
            m.addAttribute("lista", lista);

            System.out.println(capacitacion.toString());

            LOG_MONITOREO.log(Level.INFO, "CapacitacionControlador : Se ha guardado la capacitación");
            return "listar_capacitacionVista";

        }catch( Exception e){

            LOG_MONITOREO.log(Level.WARNING, "CapacitacionControlador Error :" +  e.getMessage());
            return "redirect:/capacitacion";

        }
    }
}