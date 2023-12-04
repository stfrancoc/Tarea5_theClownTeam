package RockyCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Banda {
    private String genero;
    private String nombre;
    private LocalDate fechaCreacion;
    private List<String> fotos;
    private List<Album> albumes;
    private List<Miembro> miembros;
    private List<Concierto> conciertos;

    /**
     * constructor convencional para la creacion del objeto que recibe propiedades basicas
     * @param genero tipo de musica con la que se identifican la mayoria de las canciones de la banda
     * @param nombre palabra clave con la que es reconocida la banda
     * @param fechaCreacion fecha en la que se crea o funda la banda
     */
    public Banda(String genero, String nombre, LocalDate fechaCreacion) {
        this.genero = genero;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.miembros = new ArrayList<>();
        this.fotos = new ArrayList<>();
        this.albumes = new ArrayList<>();
        this.conciertos = new ArrayList<>();
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

    public void agregarFoto(String foto){
        fotos.add(foto);
    }

    /**
     * verifica que un miembro no este en la lista de los miembros de la banda y
     * permite agregarlo si no es el caso
     * @param nombre palabra clave con la que se verifica si un miembro existe,
     *               ademas de ser el nombre de integrande o miembro de la banda
     * @param rolBanda trabajo o responsabilidad del miembro en la banda
     * @throws Exception en caso de que exista el miembro lanza una exception
     */
    public void AgregarMiembro(String nombre, String rolBanda) throws Exception {
        if(miembros == null){
            Miembro nuevoMiembro = new Miembro(nombre, rolBanda);
            miembros.add(nuevoMiembro);
        }
        else if (!MiembroExiste(nombre)) {
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

    /**
     * Verifica en la lista que posee la clase si el nombre ingresado existe en esta
     * @param nombre Nombre a buscar en la lista de Miembros
     * @return
     */
    public boolean MiembroExiste(String nombre) {
        if(!miembros.isEmpty()){
            for (Miembro m : miembros) {
                if (m.getNombre() == nombre) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * mediante cierta propiedad del miembro lo busca en la lista de miembros y lo devuelve para su manejo
     * en caso de no encontrarlo devolvera un null
     * @param nombre propiedad por la cual se busca dicho miembro
     * @return un objeto de tipo miembro en caso de encontrar el miembro en la lista de miembros en caso contrario
     *         retornara un null
     */
    public Miembro BuscarMiembro(String nombre) {
        for (Miembro m : miembros) {
            if (m.getNombre() == nombre) {
                return m;
            }
        }
        return null;
    }

    /**
     * Verifica que el miembro exista dentro de la lista de miembros para asignarle un instrumento
     * @param nombreMiembro se utiliza para buscar en la lista de miembros
     * @param instrumento se utiliza para añadir ese instrumento al miebro
     */
    public void agregarInstrumentoMiembro(String nombreMiembro,String instrumento){
        Miembro miembro = this.BuscarMiembro(nombreMiembro);
        if(miembro!=null){
            miembro.agregarInstrumento(instrumento);
        }
    }

    //cambiar lo del album que reciba solo el nombre--------------------------------------------------------
    public boolean agregarCancionAlbum(String nombreAlbum, String nombre, float duracion) {
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
             return true;
            }
        }
        return false;
    }

    public Concierto programarConcierto(String nombre, String lugar, LocalDate fecha, LocalDate hora, int capacidad, int boletos){
        if(this.buscarConcierto(nombre)!=null){
            return null;
        }
        Concierto concierto = new Concierto(nombre,lugar,fecha,hora,capacidad,boletos);
        conciertos.add(concierto);
        return concierto;
    }

    public void NuevoAlbum(String nombre, LocalDate fecha) {
        Album nvAlbum = new Album(nombre, fecha);
        albumes.add(nvAlbum);
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

    public int registroDeBoletos(String nombre){
        Concierto concierto = this.buscarConcierto(nombre);
        if(concierto!=null){
            return concierto.getBoletos();
        }
        return 0;
    }

    @Override
    public String toString() {
        String listaMiembros = "[ ";
        for(Miembro miembro:miembros){
            listaMiembros = listaMiembros + miembro.getNombre() + " ";
        }
        listaMiembros = listaMiembros + "]";
        return "Banda{" + "genero='" + genero + '\'' + ", nombre='" + nombre + '\''
                + ", fechaCreacion=" + fechaCreacion + ", fotos=" + fotos + ", albumes=" + albumes + ", miembros=" + listaMiembros +
                ", conciertos="+ conciertos + '}';
    }

}
