package Service;

import DAO.PrestamoDAO;
import Model.Prestamo;

import java.util.List;

public class PrestamosService {
    private PrestamoDAO prestamoDAO;
    public PrestamosService(PrestamoDAO prestamoDAO) {
        this.prestamoDAO = prestamoDAO;
    }
    public void registrarPrestamo(String fechaInicio, String fechaFin, int idUsuario, int idLibro) {
        try {
            Prestamo prestamo = new Prestamo(0, fechaInicio, fechaFin, idUsuario, idLibro);
            prestamoDAO.addPrestamo(prestamo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List <Prestamo> listarPrestamos() {
        try {
            return prestamoDAO.getAllPrestamos();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public void cambiarPrestamo(int id, String fechaInicio, String fechaFin, int idLibro, int idUsuario) {
        try {
            Prestamo prestamo = prestamoDAO.getPrestamoById(id);
            if (!fechaInicio.equals("") && !fechaFin.equals("")) {
                prestamo.setFechaInicio(fechaInicio);
                prestamo.setFechaFin(fechaFin);
            }

            if (idLibro != 0) {
                prestamo.setIdLibro(idLibro);
            }

            if (idUsuario != 0) {
                prestamo.setIdPrestamo(idUsuario);
            }

            if (prestamo != null) {
                prestamoDAO.updatePrestamo(prestamo);
            } else {
                System.out.println("Prestamo no encontrado");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarPrestamo(int id) {
        try {
            prestamoDAO.deletePrestamo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
