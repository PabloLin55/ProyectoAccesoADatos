package org.example;

import DAO.LibroDAO;
import DAO.LibroDAOImpl;
import Service.LibrosService;

public class Main {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();

        LibrosService servicioLibros = new LibrosService(libroDAO);
        AutorService servicioAutores = new AutorService(autorDAO);
        PrestamoService servicioPrestamos = new PrestamoService(prestamoDAO);
        UsuarioService servicioAutores = new UsuarioService(UsuarioDAO);

    }
}