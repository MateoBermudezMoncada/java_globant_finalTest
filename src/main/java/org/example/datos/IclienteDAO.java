package org.example.datos;

import org.example.dominio.Cliente;
import java.util.List;

public interface IclienteDAO {
    List<Cliente> listarClientes();
    boolean buscarClientePorId(Cliente cliente);
    boolean agregarCliente(Cliente cliente);
    boolean modificarCliente(Cliente cliente);
    boolean eliminarCliente(Cliente cliente);
}
