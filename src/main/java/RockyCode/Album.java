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

    public Cancion  buscarCancion(String nombre){
        for(Cancion cancion: this.canciones){
            if(cancion.getNombre().equalsIgnoreCase(nombre)){
                return cancion;
            }
        }
        return null;
    }

    public boolean cancionExiste(String nombre){
        for(Cancion cancion: this.canciones){
            if(cancion.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }

    public boolean agregarCancion(String nombre,float duracion){
        if(this.buscarCancion(nombre)==null){
            Cancion nuevaCancion = new Cancion(nombre,duracion);
            this.canciones.add(nuevaCancion);
            return true;
        }
        return false;
    }

}
