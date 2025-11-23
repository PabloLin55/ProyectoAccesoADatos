package org.example;

import DAO.*;
import Model.Autor;
import Model.Libro;
import Service.AutoresService;
import Service.LibrosService;
import Service.PrestamosService;
import Service.UsuariosService;

import java.util.List;
import java.util.Scanner;

public class Main {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();
        AutorDAO autorDAO = new AutorDAOImpl();
        PrestamoDAO prestamoDAO = new PrestamoDAOImpl();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

        LibrosService servicioLibros = new LibrosService(libroDAO, autorDAO);
        AutoresService servicioAutores = new AutoresService(autorDAO);
        PrestamosService servicioPrestamos = new PrestamosService(prestamoDAO);
        UsuariosService servicioUsuario = new UsuariosService(usuarioDAO);

        int opcion = 0;
        while(opcion != 5) {
            System.out.println("""
                    Menú de Menús:
                    1.Menú Libros.
                    2.Menú Autores.
                    3.Menú Prestamos.
                    4.Menú Usuarios.
                    5.Salir.""");
            opcion = sc.nextInt();
            switch(opcion) {
                case 1 -> {menuLibros(servicioLibros);}
                case 2 -> {menuAutores(servicioAutores);}
                case 3 -> {}
                case 4 -> {}
                case 5 -> {
                    System.out.println("Me despido de usted inmediatamente.");
                }
            }
        }

    }

    public static void menuLibros(LibrosService servicioLibros) {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("""
                    Menú Libros:
                    1.Registrar Libro.
                    2.Mostrar Libros.
                    3.Actualizar Libro.
                    4.Eliminar Libro.
                    5.Volver""");
         opcion = sc.nextInt();
         switch (opcion) {
             case 1 -> {
                 System.out.println("Introduce el título del libro: ");
                 sc.nextLine();
                 String titulo = sc.nextLine();
                 System.out.println("Introduce el isbn del libro: ");
                 String isbn = sc.nextLine();
                 System.out.println("Introduce el id del autor de este libro: ");
                 int idAutor = sc.nextInt();
                 servicioLibros.registrarLibro(titulo, isbn, idAutor);
             }
             case 2 -> {
                 List<Libro> libros = servicioLibros.listarLibros();
                 for (Libro libro : libros) {
                     System.out.println(libro);
                 }
             }
             case 3 -> {
                 System.out.println("Introduce el id del libro a actualizar: ");
                 int id = sc.nextInt();
                 System.out.println("Introduce el nuevo título del libro(Si no lo quiere cambiar, pulse Enter): ");
                 sc.nextLine();
                 String titulo = sc.nextLine();
                 System.out.println("Introduce el nuevo isbn del libro(Si no lo quiere cambiar, pulse Enter): ");
                 String isbn = sc.nextLine();
                 servicioLibros.cambiarTitulo(id, titulo, isbn);
             }
             case 4 -> {
                 System.out.println("Introduce el id del libro a eliminar: ");
                 int id = sc.nextInt();
                 servicioLibros.eliminarLibro(id);
             }
             case 5 -> {
                 System.out.println("Volviendo...");
             }
         }
        }
    }

    public static void menuAutores(AutoresService servicioAutores) {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("""
                    Menú Libros:
                    1.Registrar Autor.
                    2.Mostrar Autores.
                    3.Actualizar Autor.
                    4.Eliminar Autor.
                    5.Volver""");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce el nombre del autor: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();
                    servicioAutores.registrarAutor(nombre);
                }
                case 2 -> {
                    List<Autor> autores = servicioAutores.listarAutores();
                    for (Autor autor : autores) {
                        System.out.println(autor);
                    }
                }
                case 3 -> {
                    System.out.println("Introduce el id del autor a actualizar: ");
                    int id = sc.nextInt();
                    System.out.println("Introduce el nuevo nombre del autor: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();
                    servicioAutores.cambiarAutor(id, nombre);
                }
                case 4 -> {
                    System.out.println("Introduce el id del autor a eliminar: ");
                    int id = sc.nextInt();
                    servicioAutores.eliminarAutor(id);
                }
                case 5 -> {
                    System.out.println("Volviendo...");
                }
            }
        }
    }
}