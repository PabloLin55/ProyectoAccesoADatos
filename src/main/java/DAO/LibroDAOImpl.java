package DAO;

import Model.Libro;

import java.sql.*;
import java.util.ArrayList;

public class LibroDAOImpl implements LibroDAO {

    @Override
    public void addLibros(Libro libro) throws SQLException {
        String sql = "INSERT INTO libros (titulo, isbn) VALUES (?, ?)";
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getIsbn());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    libro.setId(rs.getInt(1));
                }
            }
            System.out.println("DAO: Libro Insertado -> " + libro);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Libro> getAllLibros() throws SQLException {
        String sql = "SELECT * FROM libro";
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            ArrayList<Libro> libros = new ArrayList<>();
            while (rs.next()) {
                Libro libro = new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("isbn"));
                libros.add(libro);
            }
            return libros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Libro getLibrosById(int id) throws SQLException {
        String sql = "SELECT * FROM libro WHERE id = ?";
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Libro libro = new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("isbn"));
                    return libro;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void updateLibro(Libro libro) throws SQLException {
        String sql = "UPDATE libro SET titulo = ?, isbn = ? WHERE id = ?";
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getIsbn());
            ps.setInt(3, libro.getId());
            ps.executeUpdate();
            System.out.println("DAO: Libro actualizado -> " + libro);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteLibro(int id) throws SQLException {
        String sql = "DELETE FROM libro WHERE id = ?";
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("DAO: Libro eliminado (id=" + id + ")");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
