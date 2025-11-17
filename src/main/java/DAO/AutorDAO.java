package DAO;

import Model.Autor;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AutorDAO {
    void addAutor(Autor autor) throws SQLException;
    ArrayList<Autor> getAllAutores() throws SQLException;
    Autor getAutorById(int id) throws SQLException;
    void updateAutor(Autor autor) throws SQLException;
    void deleteAutor(int id) throws SQLException;

}
