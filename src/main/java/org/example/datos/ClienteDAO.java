package org.example.datos;

import org.example.conexion.Conexion;
import org.example.dominio.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IclienteDAO {

    private Connection getConexion() {
        return Conexion.getConexion();
    }

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";  // Ajusta esto con el nombre de tu tabla en la base de datos
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("cliente_id"));
                cliente.setNombre(rs.getString("nombre_completo"));
                cliente.setCorreo(rs.getString("correo_electronico"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        String sql = "SELECT * FROM Cliente WHERE cliente_id = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cliente.getId());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setNombre(rs.getString("nombre_completo"));
                cliente.setCorreo(rs.getString("correo_electronico"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por ID: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nombre_completo, correo_electronico, telefono, direccion) VALUES (?, ?, ?, ?)";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Si se agregaron filas, el cliente se insertó correctamente.

        } catch (SQLException e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET nombre_completo = ?, correo_electronico = ?, telefono = ?, direccion = ? WHERE cliente_id = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Si se actualizó al menos una fila, se modificó el cliente.

        } catch (SQLException e) {
            System.out.println("Error al modificar cliente: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        String sql = "DELETE FROM Cliente WHERE cliente_id = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cliente.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Si se eliminó al menos una fila, el cliente fue eliminado.

        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
        return false;
    }
}
