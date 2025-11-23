package Service;

import DAO.AutorDAO;
import DAO.AutorDAOImpl;
import DAO.LibroDAO;
import DAO.LibroDAOImpl;
import Model.Autor;
import Model.Libro;

import java.util.List;

public class LibrosService {
    private LibroDAO libroDAO;
    private AutorDAO autorDAO;

    public LibrosService(LibroDAO libroDAO, AutorDAO autorDAO) {

        this.libroDAO = libroDAO;
        this.autorDAO = autorDAO;
        }

        public void registrarLibro(String titulo, String isbn, int idAutor) {
            try {
                Autor autor = autorDAO.getAutorById(idAutor);
                if (autor != null) {
                    Libro libro = new Libro(0, titulo, isbn);
                    libroDAO.addLibros(libro);
                    libroDAO.addLibroAutorRelacion(libro, autor);
                } else {
                    System.out.println("Service: No se encontró el autor con id=" + idAutor);

                }
            } catch (Exception e) {
                System.err.println("Error al registrar libro: " + e.getMessage());
            }
        }

        public List<Libro> listarLibros() {
            try {
                return libroDAO.getAllLibros();
            } catch (Exception e) {
                System.err.println("Error al listar libros: " + e.getMessage());
                return List.of();
            }
        }

        public void cambiarTitulo(int id, String nuevoTitulo, String nuevoISBN) {
            try {
                Libro libro = libroDAO.getLibrosById(id);
                if (!nuevoTitulo.equals("")) {
                    libro.setTitulo(nuevoTitulo);
                }
                if (!nuevoISBN.equals("")) {
                    libro.setIsbn(nuevoISBN);
                }
                if (libro != null) {
                    libroDAO.updateLibro(libro);
                } else {
                    System.out.println("Service: No se encontró el libro con id=" + id);
                }
            } catch (Exception e) {
                System.err.println("Error al actualizar libro: " + e.getMessage());
            }
        }

        public void eliminarLibro(int id) {
            try {
                libroDAO.deleteLibro(id);
            } catch (Exception e) {
                System.err.println("Error al eliminar libro: " + e.getMessage());
            }
        }
    }

