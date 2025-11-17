package Model;

public class Usuario {
    private int id;
    private String nombre;
    private int idPrestamo;
    public Usuario() {}

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.idPrestamo = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getIdPrestamo() {
        return idPrestamo;
    }
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String toString() {
        return "Usuario: " + id + ", Título='" + nombre + '\'' + ", Prestamo=" + idPrestamo + '}';
    }
}
