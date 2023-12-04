package RockyCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Album {
    private String nombre;
    private LocalDate fecha;
    private List<Cancion> canciones;

    /**
     * constructor para la creacion de objetos de tipo album
     * mediante su nombre y fecha
     *
     * @param nombre como se llama la cancion, tambien se usa para buscarla
     * @param fecha  de creacion del album
     */
    public Album(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.canciones = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    /**
     * permite buscar una cancion en la lista de canciones del album
     * si se encuentra devuelve el objeto cancion
     *
     * @param nombre palabra clave por el se va a buscar la cancion en la lista
     * @return en caso de encontrar la cancion devuelve un objeto de tipo cancion
     * en caso contrario un null
     */
    public Cancion buscarCancion(String nombre) {
        for (Cancion cancion : this.canciones) {
            if (cancion.getNombre().equalsIgnoreCase(nombre)) {
                return cancion;
            }
        }
        return null;
    }


    /**
     * permite saber si una cancion existe o no dentro de la lista de canciones del album
     * @param nombre palabra clave por el que se va a buscar la cancion en la lista
     * @return un true si se encuentra la cancion y un false en caso contrario
     */
    public boolean cancionExiste(String nombre) {
        for (Cancion cancion : this.canciones) {
            if (cancion.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    /**
     * verifica si la cancion no esta agregada a la lista de canciones
     * si no es el caso la agrega a la lista
     * @param nombre palabra clave con la que se reconoce la cancion y con la que
     *               se va a crear la cancion en caso de no existir
     * @param duracion tiempo que dura la cancion y dato que se va usar
     *                 para la creacion del objeto tipo cancion en caso de no existir
     * @return un true en caso de que se cree la cancion y se agrege
     *          o un false en caso de que no se pueda agregar la cancion a la lista
     */
    public boolean agregarCancion(String nombre, float duracion) {
        if (this.buscarCancion(nombre) == null) {
            Cancion nuevaCancion = new Cancion(nombre, duracion);
            this.canciones.add(nuevaCancion);
            return true;
        }
        return false;
    }

    /**
     * genera una cadena de texto con todas las propiedades de la clase
     * @return un mensaje con todas las propiedades de la clase
     */
    @Override
    public String toString() {
        String mensaje = "Album{" + "nombre='" + nombre + '\'' + ", fecha=" + fecha;
        for (Cancion cancion : this.canciones) {
            mensaje = mensaje + ' ' + cancion.toString();
        }
        return mensaje;

    }
}


