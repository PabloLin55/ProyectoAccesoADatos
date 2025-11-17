package Model;

public class Prestamo {
    private int idPrestamo;
    private String fechaInicio;
    private String fechaFin;
    public Prestamo() {}
    public Prestamo(int idPrestamo, String fechaInicio, String fechaFin) {
        this.idPrestamo = idPrestamo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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
        return "Prestamo: " + idPrestamo + " " + fechaInicio +  " " + fechaFin;
    }
}
