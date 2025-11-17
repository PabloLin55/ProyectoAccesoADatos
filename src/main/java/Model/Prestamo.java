package Model;

public class Prestamo {
    private int idPrestamo;
    private String fechaInicio;
    private String fechaFin;
    int idLibro;
    public Prestamo() {}
    public Prestamo(int idPrestamo, String fechaInicio, String fechaFin, int idLibro) {
        this.idPrestamo = idPrestamo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idLibro = idLibro;
    }
    public int getIdPrestamo() {
        return idPrestamo;
    }
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
    public String getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public int getIdLibro() {
        return idLibro;
    }
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    public String toString() {
        return "Prestamo: " + idPrestamo + " " + fechaInicio +  " " + fechaFin  + " " + idLibro;
    }
}
