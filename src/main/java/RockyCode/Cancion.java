package RockyCode;

public class Cancion {
    private String nombre;
    private float duracion;

    public Cancion(String nombre, float duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }
}
