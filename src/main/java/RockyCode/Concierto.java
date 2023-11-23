package RockyCode;

import java.time.LocalDate;
import java.util.List;

public class Concierto {

    private String Nombre;
    private String Lugar;
    private LocalDate Fecha;
    private LocalDate Hora;
    private int Capacidad;
    private int Boletos;
    private List<Cancion> Canciones;

    public Concierto(String nombre, String lugar, LocalDate fecha, LocalDate hora, int capacidad, int boletos, List<Cancion> canciones) {
        Nombre = nombre;
        Lugar = lugar;
        Fecha = fecha;
        Hora = hora;
        Capacidad = capacidad;
        Boletos = boletos;
        Canciones = canciones;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public LocalDate getHora() {
        return Hora;
    }

    public void setHora(LocalDate hora) {
        Hora = hora;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int capacidad) {
        Capacidad = capacidad;
    }

    public int getBoletos() {
        return Boletos;
    }

    public void setBoletos(int boletos) {
        Boletos = boletos;
    }

    public List<Cancion> getCanciones() {
        return Canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        Canciones = canciones;
    }

    @Override
    public String toString() {
        return "Concierto{" +
                "Nombre='" + Nombre + '\'' +
                ", Lugar='" + Lugar + '\'' +
                ", Fecha=" + Fecha +
                ", Hora=" + Hora +
                ", Capacidad=" + Capacidad +
                ", Boletos=" + Boletos +
                '}';
    }
}
