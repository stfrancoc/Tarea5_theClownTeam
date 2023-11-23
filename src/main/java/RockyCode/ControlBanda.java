package RockyCode;

import java.time.LocalDate;
import java.util.List;

public class ControlBanda {

    private Banda banda;

    public ControlBanda(String genero, String nombre, LocalDate fechaCreacion) {
        banda = new Banda(genero, nombre, fechaCreacion);
    }

    public void actualizarGeneroBanda(String genero) {
        banda.setGenero(genero);
    }

    public void actualizarFechaCreacionBanda(LocalDate fechaCreacion) {
        banda.setFechaCreacion(fechaCreacion);
    }

    public void NuevoMiembro(String nombre, String rolBanda, List<String> instrumentos) {
        try {
            banda.AgregarMiembro(nombre, rolBanda, instrumentos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void EliminarMiembro(String nombre) {
        try {
            banda.EliminarMiembro(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void InfoBanda() {
        System.out.println(banda);
    }

    public void NuevoAlbum(String nombre, LocalDate fecha) {
        banda.NuevoAlbum(nombre, fecha);

    }

    public void InfoAlbum(String nombre) {
        System.out.println(banda.ConsultarAlbum(nombre));
    }

    public void InfoConciertos() {
        System.out.println(banda.InfoConciertos());
    }
}
