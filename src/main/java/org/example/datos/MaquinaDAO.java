package org.example.datos;

import org.example.dominio.Maquina;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaquinaDAO implements ImaquinaDAO {
    private Connection connection;
    private Maquina maquina;

    public MaquinaDAO() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AlquilerMaquinas", "root", "Rlwl2023.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean agregarMaquina(Maquina maquina) {
        try {
            String sql = "INSERT INTO Maquinas (modelo, numero_serie, estado) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, maquina.getModelo());
            stmt.setString(2, maquina.getNumeroSerie());
            stmt.setString(3, maquina.getEstado());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Maquina> listarMaquinas() {
        List<Maquina> maquinas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Maquinas";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Maquina maquina = new Maquina();
                maquina.setId(rs.getInt("maquina_id"));
                maquina.setModelo(rs.getString("modelo"));
                maquina.setNumeroSerie(rs.getString("numero_serie"));
                maquina.setEstado(rs.getString("estado"));
                maquinas.add(maquina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maquinas;
    }

    @Override
    public Maquina buscarMaquinaPorId(int id) {
        try {
            String sql = "SELECT * FROM Maquinas WHERE maquina_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maquina.getId());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                maquina.setModelo(rs.getString("modelo"));
                maquina.setNumeroSerie(rs.getString("numero_serie"));
                maquina.setEstado(rs.getString("estado"));
                return maquina;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean modificarMaquina(Maquina maquina) {
        try {
            String sql = "UPDATE Maquinas SET modelo = ?, numero_serie = ?, estado = ? WHERE maquina_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, maquina.getModelo());
            stmt.setString(2, maquina.getNumeroSerie());
            stmt.setString(3, maquina.getEstado());
            stmt.setInt(4, maquina.getId());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminarMaquina(int id) {
        try {
            String sql = "DELETE FROM Maquinas WHERE maquina_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maquina.getId());
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}