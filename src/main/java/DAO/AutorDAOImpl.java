package DAO;

import Model.Autor;

import java.sql.*;
import java.util.ArrayList;

public class AutorDAOImpl implements AutorDAO {
    @Override
    public void addAutor(Autor autor) throws SQLException {
        String sql = "INSERT INTO autor (nombre) VALUES (?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, autor.getNombre());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    autor.setId(rs.getInt(1));
                }
            }
            System.out.println("DAO: Autor insertado -> " + autor);
        }
    }

    @Override
    public ArrayList<Autor> getAllAutores() throws SQLException {
        String sql = "SELECT * FROM autor";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            try (ResultSet rs = ps.executeQuery()){

                ArrayList<Autor> autores = new ArrayList<>();
                while (rs.next()) {
                    Autor autor = new Autor(rs.getInt("id"), rs.getString("nombre"));
                    autores.add(autor);
                }
                return autores;
            }
        }
    }

    @Override
    public Autor getAutorById(int id) throws SQLException {
        String sql = "SELECT * FROM autor WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Autor autor = new Autor(rs.getInt("id"), rs.getString("nombre"));
                    return autor;
                }
            }
        }
        return null;
    }

    @Override
    public void updateAutor(Autor autor) throws SQLException {
        String sql = "UPDATE autor SET nombre = ? WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, autor.getNombre());
            ps.setInt(2, autor.getId());
            ps.executeUpdate();
            System.out.println("DAO: Autor actualizado -> " + autor);
        }
    }

    @Override
    public void deleteAutor(int id) throws SQLException {
        String sqlEliminarPrestamos = "DELETE p FROM prestamo p INNER JOIN libro_autor ON p.libroId = libro_autor.idLibro WHERE idAutor = ?";
        String sqlEliminarLibrosAutor = "DELETE l FROM libro l INNER JOIN libro_autor ON l.id = libro_autor.idLibro WHERE libro_autor.idAutor = ?";
        String sqlEliminarRelacionesLibroAutor = "DELETE FROM libro_autor WHERE idAutor = ?";
        String sqlEliminarAutor = "DELETE FROM autor WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
            PreparedStatement psEliminarPrestamos = conn.prepareStatement(sqlEliminarPrestamos);
            PreparedStatement psEliminarLibrosAutor = conn.prepareStatement(sqlEliminarLibrosAutor);
            PreparedStatement psEliminarRelacionesLibroAutor = conn.prepareStatement(sqlEliminarRelacionesLibroAutor);
            PreparedStatement psEliminarAutor = conn.prepareStatement(sqlEliminarAutor)) {

            psEliminarPrestamos.setInt(1, id);
            psEliminarPrestamos.executeUpdate();

            psEliminarLibrosAutor.setInt(1, id);
            psEliminarLibrosAutor.executeUpdate();

            psEliminarRelacionesLibroAutor.setInt(1, id);
            psEliminarRelacionesLibroAutor.executeUpdate();

            psEliminarAutor.setInt(1, id);
            psEliminarAutor.executeUpdate();
            System.out.println("DAO: Autor eliminado (id=" + id + ")");
        }
    }
}
