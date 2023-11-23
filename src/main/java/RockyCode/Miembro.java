package RockyCode;

import java.util.List;

public class Miembro {
    private String nombre;
    private String rolBanda;
    private List<String> instrumentos;

    public Miembro(String nombre, String rolBanda, List<String> instrumentos) {
        this.nombre = nombre;
        this.rolBanda = rolBanda;
        this.instrumentos = instrumentos;
    }
}
