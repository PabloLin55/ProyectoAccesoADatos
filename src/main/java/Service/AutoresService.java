package Service;

import DAO.AutorDAO;
import Model.Autor;

import java.util.List;

public class AutoresService {
    private AutorDAO autorDAO;
    public AutoresService(AutorDAO autorDAO) {
        this.autorDAO = autorDAO;
    }

    public void registrarAutor(String nombre) {
        try {
            Autor autor = new Autor(0, nombre);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Autor> listarAutores() {
        try {
            return autorDAO.getAllAutores();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public void cambiarAutor(int id, String nombre) {
        try {
            Autor autor = autorDAO.getAutorById(id);
            if (autor != null) {
                autor.setNombre(nombre);
                autorDAO.updateAutor(autor);
            } else {
                System.out.println("Autor no encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarAutor(int id) {
        try {
            autorDAO.deleteAutor(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
