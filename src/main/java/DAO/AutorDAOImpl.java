package DAO;

import Model.Autor;

import java.sql.*;
import java.util.ArrayList;

public class AutorDAOImpl implements AutorDAO {
    @Override
    public void addAutor(Autor autor) throws SQLException {
        String sql = "INSERT INTO AUTOR (nombre) VALUES (?)";
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, autor.getNombre());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    autor.setId(rs.getInt("id"));
                }
            }
            System.out.println("DAO: Autor insertado -> " + autor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Autor> getAllAutores() throws SQLException {
        String sql = "SELECT * FROM AUTOR";
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Autor> autores = new ArrayList<>();
            while (rs.next()) {
                Autor autor = new Autor(rs.getInt("id"), rs.getString("nombre"));
                autores.add(autor);
            }
            return autores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Autor getAutorById(int id) throws SQLException {
        String sql = "SELECT * FROM AUTOR WHERE id = ?";
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Autor autor = new Autor(rs.getInt("id"), rs.getString("nombre"));
                    return autor;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void updateAutor(Autor autor) throws SQLException {
        String sql = "UPDATE autor SET nombre = ? WHERE id = ?";
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, autor.getNombre());
            ps.setInt(2, autor.getId());
            ps.executeUpdate();
            System.out.println("DAO: Autor actualizado -> " + autor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAutor(int id) throws SQLException {
        String sql = "DELETE autor WHERE id = ?";
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("DAO: Autor eliminado (id=" + id + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
