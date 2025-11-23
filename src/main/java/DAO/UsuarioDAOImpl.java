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
                if (rs.next()) {
                    Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"));
                    return usuario;
                }
            }
        }
        return null;
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
        String sqlEliminarUsuario = "DELETE FROM usuario WHERE id = ?";
        String sqlEliminarPrestamos = "DELETE p FROM prestamo p INNER JOIN usuario u ON p.id = u.id WHERE u.id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement psEliminarUsuarios = conn.prepareStatement(sqlEliminarUsuario);
             PreparedStatement pssEliminarPrestamos = conn.prepareStatement(sqlEliminarPrestamos);)
        {

            pssEliminarPrestamos.setInt(1, id);
            pssEliminarPrestamos.executeUpdate();
            psEliminarUsuarios.setInt(1, id);
            psEliminarUsuarios.executeUpdate();


            System.out.println("DAO: Usuario eliminado (id=" + id + ")");
        }
    }
}
