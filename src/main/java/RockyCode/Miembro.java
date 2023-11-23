package RockyCode;

import java.util.List;

public class Miembro {
    private String nombre;
    private String rolBanda;
    private List<String> instrumentos;
    private List<Miembro> miembros;

    public Miembro() {


    }

    public Miembro(String nombre, String rolBanda, List<String> instrumentos) {
        this.nombre = nombre;
        this.rolBanda = rolBanda;
        this.instrumentos = instrumentos;
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

    public boolean MiembroExiste(String nombre) {
        for (Miembro m : miembros) {
            if (m.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public Miembro buscarMiembro(String nombre) {
        for (Miembro m : miembros) {
            if (m.getNombre().equals(nombre)) {
                return m;
            }
        }
        return null;
    }
}
