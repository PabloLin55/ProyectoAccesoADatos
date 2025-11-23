package Model;

public class Autor {
    private int id;
    private String nombre;

    public Autor() {}
    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return String.format("| %-11s | %-10d | %-20s  |",
                "Autor", id, nombre);
    }
}

