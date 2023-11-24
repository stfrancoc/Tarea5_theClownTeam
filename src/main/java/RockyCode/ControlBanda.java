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

    public void NuevoMiembro(String nombre, String rolBanda) {
        try {
            banda.AgregarMiembro(nombre, rolBanda);
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

    public void agregarCancionesAlbum(String nombreAlbum, String nombre, float duracion){
        System.out.println(banda.agregarCancionAlbum(nombreAlbum,nombre,duracion));
    }

    public void consultarAlbum(String nombre){
        System.out.println(banda.ConsultarAlbum(nombre));
    }

    public void programarNuevoConcierto(String nombre, String lugar, LocalDate fecha, LocalDate hora, int capacidad, int boletos){
        banda.programarConcierto(nombre,lugar,fecha,hora,capacidad,boletos);
    }

    public void asignarListaCancionesConcierto(String nombreAlbum,String nombre,String nombreConcierto){
        System.out.println(banda.agregarCancionConcierto(nombreAlbum,nombre,nombreConcierto));
    }

    public void registrarTotalDeVoletosVendidos(String nombre){
        System.out.println(banda.registroDeBoletos(nombre));
    }

    public void consultarConciertosYBoletas(){
        System.out.println(banda.InfoConciertos());
    }
}
