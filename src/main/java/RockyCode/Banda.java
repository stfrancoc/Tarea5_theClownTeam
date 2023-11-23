package RockyCode;

import java.time.LocalDate;
import java.util.List;

public class Banda {
    private String genero;
    private String nombre;
    private LocalDate fechaCreacion;
    private List<String> fotos;

    private List<Album> albumes;

    private List<Miembro> miembros;

    public Banda(String genero, String nombre, LocalDate fechaCreacion) {
        this.genero = genero;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }

    public void AgregarMiembro(String nombre, String rolBanda, List<String> instrumentos) {
        if (!MiembroExiste(nombre)) {
            Miembro nuevoMiembro = new Miembro(nombre, rolBanda, instrumentos);
            miembros.add(nuevoMiembro);
        } else {
            throw new RuntimeException("El Miembro ya existe");
        }
    }

    public void EliminarMiembro(String nombre) {
        Miembro miembroEliminar = buscarMiembro(nombre);
        if (miembroEliminar == null) {
            throw new RuntimeException("El Miembro NO existe");
        } else {
            miembros.remove(miembroEliminar);
        }

    }

    public boolean MiembroExiste(String nombre) {
        for (Miembro m : miembros) {
            if (m.getNombre() == nombre) {
                return true;
            }
        }
        return false;
    }

    public Miembro BuscarMiembro(String nombre) {
        for (Miembro m : miembros) {
            if (m.getNombre() == nombre) {
                return m;
            }
        }
        return null;
    }

    public Boolean AgregarCancion(Album album, String nombre, float duracion) {
        if (album.CancionExiste(nombre)) {
            return true;
        } else {
            album.agregarCancion(String nombre, float duracion);
        }

    }

}
