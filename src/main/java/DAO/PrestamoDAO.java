package DAO;

import Model.Prestamo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PrestamoDAO {
    void addPrestamo(Prestamo prestamo) throws SQLException;
    ArrayList<Prestamo> getAllPrestamos() throws SQLException;
    Prestamo getPrestamoById(int id) throws SQLException;
    void updatePrestamo(Prestamo prestamo) throws SQLException;
    void deletePrestamo(int id) throws SQLException;
}
