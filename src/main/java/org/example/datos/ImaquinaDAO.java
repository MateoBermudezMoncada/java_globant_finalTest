package org.example.datos;

import org.example.dominio.Maquina;
import java.util.List;

public interface ImaquinaDAO {

    boolean agregarMaquina(Maquina maquina);
    List<Maquina> listarMaquinas();
    Maquina buscarMaquinaPorId(int id);
    boolean modificarMaquina(Maquina maquina);
    boolean eliminarMaquina(int id);
}
