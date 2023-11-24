package RockyCode;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //control de banda
        ControlBanda banda = new ControlBanda("Salsa","tomate", LocalDate.of(2020,11,23));
        //nuevos miembros
        banda.NuevoMiembro("sapopeta","trompetista");
        banda.NuevoMiembro("elabuelo","baterista");
        banda.NuevoMiembro("matias","trompetista");
        //nuevo album
        banda.NuevoAlbum("lameSeta",LocalDate.of(2020,11,24));
        banda.NuevoAlbum("Mamasoyguapo",LocalDate.of(2020,12,24));
        //nuevas canciones
        banda.agregarCancionesAlbum("lameSeta","porque",3.25f);
        banda.agregarCancionesAlbum("lameSeta","te",3.45f);
        banda.agregarCancionesAlbum("lameSeta","tatuastis",3.05f);
        banda.agregarCancionesAlbum("Mamasoyguapo","dechiquito",2.05f);
        banda.agregarCancionesAlbum("Mamasoyguapo","degrande",3.55f);
        //informacion album
        banda.InfoAlbum("lameSeta");
        banda.InfoAlbum("Mamasoyguapo");
        //consultar info de banda
        banda.InfoBanda();
        //eliminar miembro de la banda
        banda.EliminarMiembro("matias");
        banda.InfoBanda();
        //actualizar informacion de la banda
        banda.actualizarGeneroBanda("Metal");
        banda.actualizarFoto("foto.jpg");
        banda.actualizarNombre("RockyCode");
        banda.InfoBanda();
        //programar Concierto
        banda.programarNuevoConcierto("los panchos", "por alli", LocalDate.of(2021, 10, 14), LocalDate.now(), 2000, 1900);
        banda.InfoBanda();
        //agregar canciones al concierto
        banda.asignarListaCancionesConcierto("lameSeta","tatuastis","los panchos");
        banda.asignarListaCancionesConcierto("Mamasoyguapo","dechiquito","los panchos");
        //consultar conciertos
        banda.InfoConciertos();
        //agregar instrumentos a los miembros
        banda.agregarInstrumentoMiembro("sapopeta","piano");
        banda.InfoBanda();
    }
}
