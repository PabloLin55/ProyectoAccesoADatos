package Model;


public class Libro {
    private int id;
    private String titulo;
    private int idAutor;

    public Libro() {}
    public Libro(int id, String titulo, int idAutor) {
        this.id = id;
        this.titulo = titulo;
        this.idAutor = idAutor;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public int getIdAutor() { return idAutor; }
    public void setIdAutor(int idAutor) { this.idAutor = idAutor; }

    @Override
    public String toString() {
        return ("Libro: " + id + " " + titulo + " " + idAutor);
    }
}
