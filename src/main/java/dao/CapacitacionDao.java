package dao;
import modelos.Capacitacion;

import java.util.ArrayList;
import java.util.List;

class CapacitacionDao implements ICapacitacionDao {

    // Lista para almacenar las capacitaciones (simulación de una base de datos)
    private List<Capacitacion> capacitaciones = new ArrayList<>();

    @Override
    public List<Capacitacion> obtenerCapacitaciones() {
        // Simulamos la obtención de capacitaciones de una base de datos o algún otro sistema de almacenamiento
        return capacitaciones;
    }

    @Override
    public boolean crearCapacitacion(Capacitacion capacitacion) {
        if (capacitaciones.contains(capacitacion)) return false;
        else{ return capacitaciones.add(capacitacion); }
    }}

