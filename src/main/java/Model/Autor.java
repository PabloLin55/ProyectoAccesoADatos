package Model;

public class Autor {
    private int id;
    private String titulo;
    private String isbn;

    public Autor() {}
    public Autor(int id, String titulo, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String toString() {
        return "Autor{" + "id=" + id + ", titulo=" + titulo + '}';
    }
}

