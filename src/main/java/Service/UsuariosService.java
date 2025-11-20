package Service;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImpl;
import Model.Usuario;

import java.util.List;

public class UsuariosService {
    private UsuarioDAO usuarioDAO;
    public UsuariosService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    public void registrarUsuario(String nombre) {
        try {
            Usuario usuario = new Usuario(0, nombre);
            usuarioDAO.addUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Usuario> listarUsuarios() {
        try {
            return usuarioDAO.getAllUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public void cambiarNombre(int id, String nombre) {
        try {
            Usuario usuario = usuarioDAO.getUsuarioById(id);
            if (usuario != null) {
                usuario.setNombre(nombre);
                usuarioDAO.updateUsuario(usuario);
            } else {
                System.out.println("Usuario no encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(int id) {
        try {
            usuarioDAO.deleteUsuario(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
