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
    private List<Concierto> conciertos;


    public Banda(String genero, String nombre, LocalDate fechaCreacion) {
        this.genero = genero;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public List<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(List<Album> albumes) {
        this.albumes = albumes;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void AgregarMiembro(String nombre, String rolBanda) throws Exception {
        if (!MiembroExiste(nombre)) {
            Miembro nuevoMiembro = new Miembro(nombre, rolBanda);
            miembros.add(nuevoMiembro);
        } else {
            throw new Exception("El Miembro ya existe");
        }
    }

    public void EliminarMiembro(String nombre) throws Exception {
        Miembro miembroEliminar = BuscarMiembro(nombre);
        if (miembroEliminar == null) {
            throw new Exception("El Miembro NO existe");
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

    //cambiar lo del album que reciba solo el nombre--------------------------------------------------------
    public Boolean agregarCancionAlbum(String nombreAlbum, String nombre, float duracion) {
        Album album = this.BuscarAlbum(nombreAlbum);
        if(album!=null){
            if (album.cancionExiste(nombre)) {
                return false;
            } else {
                album.agregarCancion(nombre, duracion);
                return true;
            }
        }
        return false;
    }

    public boolean agregarCancionConcierto(String nombreAlbum,String nombre,String nombreConcierto){
        Album album = this.BuscarAlbum(nombreAlbum);
        Concierto concierto = this.buscarConcierto(nombreConcierto);
        if(album!=null && concierto!=null){
            Cancion cancioncita = album.buscarCancion(nombre);
            if(cancioncita!=null){
             concierto.adicionCancion(cancioncita);
            }
        }
        return false;
    }

    public Concierto programarConcierto(String nombre, String lugar, LocalDate fecha, LocalDate hora, int capacidad, int boletos){
        if(this.buscarConcierto(nombre)!=null){
            return null;
        }
        Concierto concierto = new Concierto(nombre,lugar,fecha,hora,capacidad,boletos);
        return concierto;
    }

    public void NuevoAlbum(String nombre, LocalDate fecha) {
        Album nvAlbum = new Album(nombre, fecha);
        this.albumes.add(nvAlbum);
    }

    public String ConsultarAlbum(String nombre) {
        Album album = BuscarAlbum(nombre);
        return album.toString();
    }

    public Album BuscarAlbum(String nombre) {
        for (Album a : albumes) {
            if (a.getNombre() == nombre) {
                return a;
            }
        }
        return null;
    }

    public String InfoConciertos() {
        String mensaje = "";
        for (Concierto c : conciertos) {
            mensaje = mensaje + conciertos.toString() + "\n";
        }
        return mensaje;
    }

    public Concierto buscarConcierto(String nombre){
        for(Concierto concierto:conciertos){
            if(concierto.getNombre().equalsIgnoreCase(nombre)){
                return concierto;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String nombresCanciones = "";
        return "Banda{" + "genero='" + genero + '\'' + ", nombre='" + nombre + '\''
                + ", fechaCreacion=" + fechaCreacion + ", fotos=" + fotos + ", albumes=" + albumes + ", miembros=" + miembros + '}';
    }

}

//falta consultar informaciond de la banda
//consultar canciones del album
//programar un nuevo concierto
//asignar lista de canciones al concierto
//registrar el todal de voletos vendidos en el concurso
//consultar todolso los conciertos realizados cada uno con sus boletas vendidas