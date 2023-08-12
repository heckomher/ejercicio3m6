package com.example.ejercicio3m6.repositorios;

import com.example.ejercicio3m6.modelos.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICapacitacionRepositorio extends JpaRepository<Capacitacion, Integer > {

    public void crearCapacitacion(Capacitacion capacitacion);
    public void actualizarCapacitacion(Capacitacion capacitacion);
    public void borrarCapacitacion(Capacitacion capacitacion);

    public Capacitacion buscarCapacitacion(int id);

    public List<Capacitacion> listaCapacitaciones();

}
