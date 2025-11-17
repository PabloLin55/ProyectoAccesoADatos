package DAO;

import Model.Libro;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LibroDAO {
    void addLibros(Libro libro) throws SQLException;
    ArrayList<Libro> getAllLibros() throws SQLException;
    Libro getLibrosById(int id) throws SQLException;
    void updateLibro(Libro libro) throws SQLException;
    void deleteLibro(int id) throws SQLException;
}
