package DAO;

import Model.Autor;
import Model.Libro;

import java.sql.*;
import java.util.ArrayList;

public class LibroDAOImpl implements LibroDAO {

    @Override
    public void addLibros(Libro libro) throws SQLException {
        String sql = "INSERT INTO libro (titulo, isbn) VALUES (?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getIsbn());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    libro.setId(rs.getInt(1));
                }
            }
            System.out.println("DAO: Libro Insertado -> " + libro);
        }
    }

    @Override
    public ArrayList<Libro> getAllLibros() throws SQLException {
        String sql = "SELECT * FROM libro";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            try(ResultSet rs = ps.executeQuery()) {
                ArrayList<Libro> libros = new ArrayList<>();
                while (rs.next()) {
                    Libro libro = new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("isbn"));
                    libros.add(libro);
                }
                return libros;
            }
        }
    }

    @Override
    public Libro getLibrosById(int id) throws SQLException {
        String sql = "SELECT * FROM libro WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Libro libro = new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("isbn"));
                    return libro;
                }
            }
        }
        return null;
    }

    @Override
    public void updateLibro(Libro libro) throws SQLException {
        String sql = "UPDATE libro SET titulo = ?, isbn = ? WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getIsbn());
            ps.setInt(3, libro.getId());
            ps.executeUpdate();
            System.out.println("DAO: Libro actualizado -> " + libro);
        }
    }

    @Override
    public void deleteLibro(int id) throws SQLException {
        String sql = "DELETE FROM libro WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("DAO: Libro eliminado (id=" + id + ")");

        }
    }

    @Override
    public void addLibroAutorRelacion(Libro libro, Autor autor) throws SQLException {
        String sql = "INSERT INTO libro_autor (idLibro, idAutor) VALUES (?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, libro.getId());
            ps.setInt(2, autor.getId());
            ps.executeUpdate();
        }
    }

}
