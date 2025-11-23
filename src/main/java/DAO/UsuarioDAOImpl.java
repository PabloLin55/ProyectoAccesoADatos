package DAO;

import Model.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void addUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nombre) VALUES (?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, usuario.getNombre());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    usuario.setId(rs.getInt(1));
                }
                System.out.println("DAO: Usuario insertado -> " + usuario);
            }
        }
    }

    @Override
    public ArrayList<Usuario> getAllUsuarios() throws SQLException {
        String sql = "SELECT * FROM usuario";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            try(ResultSet rs = ps.executeQuery()) {
                ArrayList<Usuario> usuarios = new ArrayList<>();
                while (rs.next()) {
                    Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"));
                    usuarios.add(usuario);
                }
                return usuarios;
            }
        }
    }

    @Override
    public Usuario getUsuarioById(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);){

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"));
                return usuario;
            }
        }
    }

    @Override
    public void updateUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET nombre = ? WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getId());
            ps.executeUpdate();
            System.out.println("DAO: Usuario actualizado -> " + usuario);
        }
    }

    @Override
    public void deleteUsuario(int id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);){

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("DAO: Usuario eliminado (id=" + id + ")");
        }
    }
}
