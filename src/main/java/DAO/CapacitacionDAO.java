package DAO;
import java.util.ArrayList;
import java.util.List;

public class CapacitacionDao implements ICapacitacionDao {

    // Lista para almacenar las capacitaciones (simulación de una base de datos)
    private List<Capacitacion> capacitaciones = new ArrayList<>();

    @Override
    public List<Capacitacion> obtenerCapacitaciones() {
        // Simulamos la obtención de capacitaciones de una base de datos o algún otro sistema de almacenamiento
        return capacitaciones;
    }

    @Override
    public boolean crearCapacitacion(Capacitacion capacitacion) {
        // Simulamos la creación de una capacitación en una base de datos o algún otro sistema de almacenamiento
        // Agregamos la capacitación a la lista (simulación)
        return capacitaciones.add(capacitacion);
    }
}
