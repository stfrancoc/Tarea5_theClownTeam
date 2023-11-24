package RockyCode;

import java.util.ArrayList;
import java.util.List;

public class Miembro {
    private String nombre;
    private String rolBanda;
    private List<String> instrumentos;


    public Miembro(String nombre, String rolBanda) {
        this.nombre = nombre;
        this.rolBanda = rolBanda;
        this.instrumentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRolBanda() {
        return rolBanda;
    }

    public void setRolBanda(String rolBanda) {
        this.rolBanda = rolBanda;
    }

    public List<String> getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(List<String> instrumentos) {
        this.instrumentos = instrumentos;
    }

    public void agregarInstrumento(String nombre){
        this.instrumentos.add(nombre);
    }

}
