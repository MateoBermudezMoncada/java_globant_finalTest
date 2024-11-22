package org.example.datos;

import org.example.dominio.Alquiler;
import java.util.List;

public interface IalquilerDAO {
    boolean agregarAlquiler(Alquiler alquiler);
    List<Alquiler> listarAlquileres();
    Alquiler buscarAlquilerPorId(Alquiler alquiler);
    boolean modificarAlquiler(Alquiler alquiler);
    boolean eliminarAlquiler(Alquiler alquiler);
}
