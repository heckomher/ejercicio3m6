package com.example.ejercicio3m6.repositorios;

import com.example.ejercicio3m6.modelos.Capacitacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class CapacitacionRepositorioImpl implements ICapacitacionRepositorio{
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void crearCapacitacion(Capacitacion capacitacion) {
        em.persist(capacitacion);
    }
    @Override
    @Transactional
    public void borrarCapacitacion(Capacitacion capacitacion) {
        em.remove(capacitacion);
    }
    @Override
    @Transactional
    public void actualizarCapacitacion(Capacitacion capacitacion) {
        em.merge(capacitacion);
    }
    @Override
    @Transactional
    public Capacitacion buscarCapacitacion(int id) {
        return em.find(Capacitacion.class, id);
    }
    @Override
    @Transactional
    public List<Capacitacion> listaCapacitaciones() {
        return em.createQuery("FROM Capacitacion", Capacitacion.class).getResultList();
    }
}
