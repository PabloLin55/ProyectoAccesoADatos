package DAO;

import Model.Prestamo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrestamoDAOImpl implements PrestamoDAO{
    @Override
    public void addPrestamo(Prestamo prestamo) throws SQLException {
        String sql = "INSERT INTO prestamo (fechaInicio, fechaFin, usuarioId, libroId) VALUES (?,?,?,?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){

            ps.setString(1, prestamo.getFechaInicio());
            ps.setString(2, prestamo.getFechaFin());
            ps.setInt(3, prestamo.getIdUsuario());
            ps.setInt(4, prestamo.getIdLibro());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    prestamo.setIdPrestamo(rs.getInt(1));
                }
            }
            System.out.println("DAO: Préstamo insertado -> " + prestamo);
        }
    }

    @Override
    public ArrayList<Prestamo> getAllPrestamos() throws SQLException {
        String sql = "SELECT * FROM prestamo";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            try(ResultSet rs = ps.executeQuery()) {

                ArrayList<Prestamo> prestamos = new ArrayList<>();
                while (rs.next()) {
                    Prestamo prestamo = new Prestamo(rs.getInt("id"), rs.getString("fechaInicio"), rs.getString("fechaFin"), rs.getInt("usuarioId"), rs.getInt("libroId"));
                    prestamos.add(prestamo);
                }
                return prestamos;
            }
        }
    }

    @Override
    public Prestamo getPrestamoById(int id) throws SQLException {
        String sql = "SELECT * FROM prestamo WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Prestamo prestamo = new Prestamo(rs.getInt("id"), rs.getString("fechaInicio"), rs.getString("fechaFin"), rs.getInt("usuarioId"), rs.getInt("libroId"));
                    return prestamo;
                }
            }
        }
        return null;
    }

    @Override
    public void updatePrestamo(Prestamo prestamo) throws SQLException {
        String sql = "UPDATE prestamo SET fechaInicio = ?, fechaFin = ?, usuarioId = ?, libroId = ? WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, prestamo.getFechaInicio());
            ps.setString(2, prestamo.getFechaFin());
            ps.setInt(3, prestamo.getIdUsuario());
            ps.setInt(4, prestamo.getIdLibro());
            ps.executeUpdate();
            System.out.println("DAO: Préstamo actualizado -> " + prestamo);
        }
    }

    @Override
    public void deletePrestamo(int id) throws SQLException {
        String sql = "DELETE FROM prestamo WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("DAO: Préstamo eliminado (id=" + id + ")");

        }
    }
}
