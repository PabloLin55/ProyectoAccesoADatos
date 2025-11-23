package Model;

public class Prestamo {
    private int idPrestamo;
    private String fechaInicio;
    private String fechaFin;
    int idUsuario;
    int idLibro;

    public Prestamo() {}
    public Prestamo(int idPrestamo, String fechaInicio, String fechaFin, int idUsuario, int idLibro) {
        this.idPrestamo = idPrestamo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idUsuario = idUsuario;
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
    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}
    public int getIdLibro() {
        return idLibro;
    }
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    @Override
    public String toString() {
        return "Libro-Autor[ " + " idPrestamo= " + idPrestamo + ", fecha de Inicio= " + fechaInicio + ", fecha de Fin= " + fechaFin + ", idUsuario= " + idUsuario + ", idLibro= " + idLibro + " ]";
    }
}
