package org.example.datos;

import org.example.conexion.Conexion;
import org.example.dominio.Alquiler;
import org.example.dominio.Cliente;
import org.example.dominio.Maquina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlquilerDAO implements IalquilerDAO {
    private static final Connection connection = Conexion.getConexion();

    @Override
    public boolean agregarAlquiler(Alquiler alquiler) {
        String query = "INSERT INTO Alquileres (cliente_id, maquina_id, fecha_inicio, fecha_fin, estado) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, alquiler.getCliente().getId());
            stmt.setInt(2, alquiler.getMaquina().getId());
            stmt.setDate(3, new java.sql.Date(alquiler.getFechaInicio().getTime()));
            stmt.setDate(4, new java.sql.Date(alquiler.getFechaFin().getTime()));
            stmt.setString(5, alquiler.getEstado());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar alquiler: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Alquiler> listarAlquileres() {
        List<Alquiler> alquileres = new ArrayList<>();
        String query = "SELECT a.alquiler_id, a.fecha_inicio, a.fecha_fin, a.estado, c.nombre_completo, m.modelo " +
                "FROM Alquileres a " +
                "JOIN Cliente c ON a.cliente_id = c.cliente_id " + // Aquí cambiamos de Clientes a Cliente
                "JOIN Maquinas m ON a.maquina_id = m.maquina_id";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Alquiler alquiler = new Alquiler();
                alquiler.setId(rs.getInt("alquiler_id"));
                alquiler.setFechaInicio(rs.getDate("fecha_inicio"));
                alquiler.setFechaFin(rs.getDate("fecha_fin"));
                alquiler.setEstado(rs.getString("estado"));

                Cliente cliente = new Cliente();
                cliente.setNombre(rs.getString("nombre_completo"));
                alquiler.setCliente(cliente);

                Maquina maquina = new Maquina();
                maquina.setModelo(rs.getString("modelo"));
                alquiler.setMaquina(maquina);

                alquileres.add(alquiler);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar alquileres: " + e.getMessage());
        }
        return alquileres;
    }

    @Override
    public Alquiler buscarAlquilerPorId(Alquiler alquiler) {
        String query = "SELECT * FROM Alquileres WHERE alquiler_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, alquiler.getId());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    alquiler.setFechaInicio(rs.getDate("fecha_inicio"));
                    alquiler.setFechaFin(rs.getDate("fecha_fin"));
                    alquiler.setEstado(rs.getString("estado"));
                    return alquiler;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar alquiler: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean modificarAlquiler(Alquiler alquiler) {
        String query = "UPDATE Alquileres SET fecha_inicio = ?, fecha_fin = ?, estado = ? WHERE alquiler_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(alquiler.getFechaInicio().getTime()));
            stmt.setDate(2, new java.sql.Date(alquiler.getFechaFin().getTime()));
            stmt.setString(3, alquiler.getEstado());
            stmt.setInt(4, alquiler.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar alquiler: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarAlquiler(Alquiler alquiler) {
        String query = "DELETE FROM Alquileres WHERE alquiler_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, alquiler.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar alquiler: " + e.getMessage());
            return false;
        }
    }
}
