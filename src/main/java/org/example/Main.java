package org.example;

import DAO.*;

public class Main {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();
        AutorDAO autorDAO = new AutorDAOImpl();
        PrestamoDAO prestamoDAO = new PrestamoDAOImpl();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();


        LibrosService servicioLibros = new LibrosService(libroDAO);
        AutorService servicioAutores = new AutorService(autorDAO);
        PrestamoService servicioPrestamos = new PrestamoService(prestamoDAO);
        UsuarioService servicioAutores = new UsuarioService(usuarioDAO);

    }
}