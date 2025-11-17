package DAO;

import Model.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UsuarioDAO {
    void addUsuario(Usuario usuario) throws SQLException;
    ArrayList<Usuario> getAllUsuarios() throws SQLException;
    Usuario getUsuarioById(int id) throws SQLException;
    void updateUsuario(Usuario usuario) throws SQLException;
    void deleteUsuario(int id) throws SQLException;

}
