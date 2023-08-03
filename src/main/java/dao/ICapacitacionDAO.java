package dao;

import modelos.Capacitacion;

import java.util.List;

interface ICapacitacionDao {
    List<Capacitacion> obtenerCapacitaciones();
    boolean crearCapacitacion(Capacitacion capacitacion);
}
