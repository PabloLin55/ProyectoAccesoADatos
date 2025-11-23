package org.example;

import DAO.*;
import Model.Autor;
import Model.Libro;
import Model.Prestamo;
import Model.Usuario;
import Service.AutoresService;
import Service.LibrosService;
import Service.PrestamosService;
import Service.UsuariosService;

import java.util.InputMismatchException;
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
            try {
                System.out.println("Introduce una opción válida: ");
                opcion = sc.nextInt();
                switch(opcion) {
                    case 1 -> {menuLibros(servicioLibros);}
                    case 2 -> {menuAutores(servicioAutores);}
                    case 3 -> {menuPrestamos(servicioPrestamos);}
                    case 4 -> {menuUsuarios(servicioUsuario);}
                    case 5 -> {
                        System.out.println("Me despido de usted inmediatamente.");
                    }
                    default -> System.out.println("Opcion no valida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Formato Incorrecto...");
                sc.nextLine();
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
            try {
                System.out.println("Introduce una opción válida: ");
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
                    default -> System.out.println("Opcion no valida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Formato Incorrecto...");
                sc.nextLine();
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
            try {
                System.out.println("Introduce una opción válida: ");

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
                    default -> System.out.println("Opcion no valida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Formato Incorrecto...");
                sc.nextLine();
            }

        }
    }
    public static void menuUsuarios(UsuariosService servicioUsuarios) {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("""
                    Menú Usuarios:
                    1.Registrar Usuario.
                    2.Mostrar Usuarios.
                    3.Actualizar Usuario.
                    4.Eliminar Usuario.
                    5.Volver""");
            try {
                System.out.println("Introduce una opción válida: ");

                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Introduce el nombre del usuario: ");
                        sc.nextLine();
                        String nombre = sc.nextLine();
                        servicioUsuarios.registrarUsuario(nombre);
                    }
                    case 2 -> {
                        List<Usuario> usuarios = servicioUsuarios.listarUsuarios();
                        for (Usuario usuario : usuarios) {
                            System.out.println(usuario);
                        }
                    }
                    case 3 -> {
                        System.out.println("Introduce el id del usuario a actualizar: ");
                        int id = sc.nextInt();
                        System.out.println("Introduce el nuevo nombre del usuario: ");
                        sc.nextLine();
                        String nombre = sc.nextLine();
                        servicioUsuarios.cambiarNombre(id, nombre);
                    }
                    case 4 -> {
                        System.out.println("Introduce el id del usuario a eliminar: ");
                        int id = sc.nextInt();
                        servicioUsuarios.eliminarUsuario(id);
                    }
                    case 5 -> {
                        System.out.println("Volviendo...");
                    }
                    default -> System.out.println("Opcion no valida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Formato Incorrecto...");
                sc.nextLine();
            }

        }
    }

    public static void menuPrestamos(PrestamosService servicioPrestamos) {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("""
                    Menú Prestamos:
                    1.Registrar Prestamo.
                    2.Mostrar Prestamos.
                    3.Actualizar Prestamo.
                    4.Eliminar Prestamo.
                    5.Volver""");
            try {
                System.out.println("Introduce una opción válida: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Introduce la fecha en la que se empezo el prestamo (formato yyyy-MM-dd): ");
                        sc.nextLine();
                        String fechaInicio = sc.nextLine();
                        System.out.println("Introduce la fecha en la que acabo el prestamo (formato yyyy-MM-dd): ");
                        String fechaFin = sc.nextLine();
                        System.out.println("Introduce el id del usuario que hizo el prestamo: ");
                        int idUsuario = sc.nextInt();
                        System.out.println("Introduce el id del libro prestado: ");
                        int idLibro = sc.nextInt();
                        servicioPrestamos.registrarPrestamo(fechaInicio, fechaFin, idUsuario, idLibro);
                    }
                    case 2 -> {
                        List<Prestamo> prestamos = servicioPrestamos.listarPrestamos();
                        for (Prestamo prestamo : prestamos) {
                            System.out.println(prestamo);
                        }
                    }
                    case 3 -> {
                        System.out.println("Introduce el id del prestamo a actualizar: ");
                        int id = sc.nextInt();
                        System.out.println("Introduce la fecha en la que hizo el prestamo(O pulsa Enter si no quieres actualizarlo): ");
                        sc.nextLine();
                        String fechaInicio = sc.nextLine();
                        System.out.println("Introduce la fecha en la que avabo el prestamo(O pulsa Enter si no quieres actualizarlo): ");
                        String fechaFin = sc.nextLine();
                        System.out.println("Introduce el id del usuario que hizo el prestamo(O escribe 0 si no quieres actualizarlo): ");
                        int idUsuario = sc.nextInt();
                        System.out.println("Introduce el id del libro prestado: ");
                        int idLibro = sc.nextInt();
                        servicioPrestamos.cambiarPrestamo(id, fechaInicio, fechaFin, idUsuario, idLibro);
                    }
                    case 4 -> {
                        System.out.println("Introduce el id del prestamo a eliminar: ");
                        int id = sc.nextInt();
                        servicioPrestamos.eliminarPrestamo(id);
                    }
                    case 5 -> {
                        System.out.println("Volviendo...");
                    }
                    default -> System.out.println("Opcion no valida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Formato Incorrecto...");
                sc.nextLine();
            }


        }
    }
}