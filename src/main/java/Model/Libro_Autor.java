package Model;

public class Libro_Autor {
    private int idLibro;
    private int idAutor;
    public Libro_Autor() {}
    public Libro_Autor(int idLibro, int idAutor) {
        this.idLibro = idLibro;
        this.idAutor = idAutor;
    }
    public int getIdLibro() {
        return idLibro;
    }
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    public int getIdAutor() {
        return idAutor;
    }
    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }
    @Override
    public String toString() {
        return String.format("| %-11s | %-10d | %-10d |",
                "Libro-Autor", idLibro, idAutor);
    }

}
