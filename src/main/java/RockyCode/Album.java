package RockyCode;

import java.time.LocalDate;
import java.util.List;

public class Album {
    private String nombre;
    private LocalDate fecha;
    private List<Cancion> canciones;

    public Album(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }



}
