package RockyCode;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //---------------------------------------------prueba rapida----------------------------------------------------
        /*
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
        */
        //----------------------------------funcionamiento por consola-------------------------------------------------
        int selector;
        ControlBanda bandaTerminal = null;
        boolean bandaExist = false;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bienvenido a RockyCode");
            System.out.println("Ingresa el numero correspondiente a la opcion que quieres seleccionar");
            System.out.println("0.Salir");
            System.out.println("1.Crear Banda");
            System.out.println("2.Agregar un nuevo Miembro");
            System.out.println("3.Agregar un nuevo Album");
            System.out.println("4.Agregar una nueva cancion a un Album");
            System.out.println("5.Informacion del Album");
            System.out.println("6.Informacion de la Banda");
            System.out.println("7.Eliminar miembro de la Banda");
            System.out.println("8.Actualizar informacion de la Banda");
            System.out.println("9.Programar nuevo concierto");
            System.out.println("10.Agregar cancion al concierto");
            System.out.println("11.Consultar conciertos");
            System.out.println("12.Agregar instrumentos a los miembros");
            System.out.println();
            selector = scanner.nextInt();
            System.out.print("el numero que seleccionaste es: ");
            System.out.println(selector);

            switch (selector){
                case 0:
                    System.out.println("Hasta la proxima ;3");
                    break;

                case 1:
                    System.out.println("Crear Banda seleccionada...");
                    System.out.println("Cual es el genero de la banda");

                    // Consumir el carácter de nueva línea después de nextInt()
                    scanner.nextLine();

                    String genero = scanner.nextLine();

                    System.out.println("Cual es el nombre de la banda");
                    String nombre = scanner.nextLine();

                    System.out.println("Cual es el año de creación de la banda");
                    int year = scanner.nextInt();
                    //scanner.nextLine(); // Consumir el carácter de nueva línea

                    System.out.println("Cual mes se creo de la banda");
                    int month = scanner.nextInt();
                    //scanner.nextLine(); // Consumir el carácter de nueva línea

                    System.out.println("Cual dia se creo de la banda");
                    int day = scanner.nextInt();
                    //scanner.nextLine(); // Consumir el carácter de nueva línea

                    bandaTerminal = new ControlBanda(genero, nombre, LocalDate.of(year, month, day));
                    bandaExist = true;
                    break;
                case 2:
                    System.out.println("Agregar un nuevo Miembro seleccionado...");
                    System.out.println("Nombre del nuevo miembro:");
                    String nuevoMiembroNombre = scanner.nextLine();

                    System.out.println("Instrumento del nuevo miembro:");
                    String nuevoMiembroInstrumento = scanner.nextLine();

                    // Llama al método para agregar un nuevo miembro
                    bandaTerminal.NuevoMiembro(nuevoMiembroNombre, nuevoMiembroInstrumento);
                    break;

                case 3:
                    System.out.println("Agregar un nuevo Álbum seleccionado...");
                    System.out.println("Nombre del nuevo álbum:");
                    String nuevoAlbumNombre = scanner.nextLine();

                    System.out.println("Fecha de lanzamiento del nuevo álbum (Año Mes Día):");
                    int nuevoAlbumYear = scanner.nextInt();
                    int nuevoAlbumMonth = scanner.nextInt();
                    int nuevoAlbumDay = scanner.nextInt();

                    // Llama al método para agregar un nuevo álbum
                    bandaTerminal.NuevoAlbum(nuevoAlbumNombre, LocalDate.of(nuevoAlbumYear, nuevoAlbumMonth, nuevoAlbumDay));
                    break;

                case 4:
                    System.out.println("Agregar una nueva Canción a un Álbum seleccionado...");
                    System.out.println("Nombre del álbum:");
                    String albumNombre = scanner.nextLine();

                    System.out.println("Nombre de la nueva canción:");
                    String nuevaCancionNombre = scanner.nextLine();

                    System.out.println("Duración de la nueva canción:");
                    float nuevaCancionDuracion = scanner.nextFloat();

                    // Llama al método para agregar una nueva canción a un álbum
                    bandaTerminal.agregarCancionesAlbum(albumNombre, nuevaCancionNombre, nuevaCancionDuracion);
                    break;

                case 5:
                    if(bandaExist){
                        System.out.println("Información de un Álbum seleccionado...");
                        System.out.println("Nombre del álbum:");
                        String infoAlbumNombre = scanner.nextLine();

                        // Llama al método para obtener la información de un álbum
                        bandaTerminal.InfoAlbum(infoAlbumNombre);
                        break;
                    }
                    else{
                        System.out.println("No has creado todavia la banda");
                        break;
                    }
                case 6:
                    System.out.println("Información de la Banda seleccionada...");

                    // Llama al método para obtener la información de la banda
                    bandaTerminal.InfoBanda();
                    break;

                case 7:
                    System.out.println("Eliminar miembro de la Banda seleccionado...");
                    System.out.println("Nombre del miembro a eliminar:");
                    String miembroAEliminar = scanner.nextLine();

                    // Llama al método para eliminar un miembro de la banda
                    bandaTerminal.EliminarMiembro(miembroAEliminar);
                    break;

                case 8:
                    System.out.println("Actualizar información de la Banda seleccionado...");
                    System.out.println("Nuevo género de la banda:");
                    String nuevoGenero = scanner.nextLine();

                    System.out.println("Nueva foto de la banda:");
                    String nuevaFoto = scanner.nextLine();

                    System.out.println("Nuevo nombre de la banda:");
                    String nuevoNombreBanda = scanner.nextLine();

                    // Llama a los métodos correspondientes para actualizar la información de la banda
                    bandaTerminal.actualizarGeneroBanda(nuevoGenero);
                    bandaTerminal.actualizarFoto(nuevaFoto);
                    bandaTerminal.actualizarNombre(nuevoNombreBanda);
                    break;

                case 9:
                    System.out.println("Programar nuevo concierto seleccionado...");
                    System.out.println("Nombre del concierto:");
                    String nombreConcierto = scanner.nextLine();

                    System.out.println("Ubicación del concierto:");
                    String ubicacionConcierto = scanner.nextLine();

                    System.out.println("Fecha del concierto (Año Mes Día):");
                    int yearConcierto = scanner.nextInt();
                    int monthConcierto = scanner.nextInt();
                    int dayConcierto = scanner.nextInt();

                    System.out.println("Hora de inicio del concierto (en formato militar):");
                    int horaInicio = scanner.nextInt();

                    System.out.println("Hora de finalización del concierto (en formato militar):");
                    int horaFin = scanner.nextInt();

                    // Llama al método para programar un nuevo concierto
                    bandaTerminal.programarNuevoConcierto(nombreConcierto, ubicacionConcierto, LocalDate.of(yearConcierto, monthConcierto, dayConcierto), LocalDate.now(), horaInicio, horaFin);
                    break;

                case 10:
                    System.out.println("Agregar canción al concierto seleccionado...");
                    System.out.println("Nombre del álbum:");
                    String albumConcierto = scanner.nextLine();

                    System.out.println("Nombre de la canción a agregar al concierto:");
                    String cancionConcierto = scanner.nextLine();

                    System.out.println("Nombre del concierto:");
                    String nombreConciertoAgregar = scanner.nextLine();

                    // Llama al método para agregar una canción a un concierto
                    bandaTerminal.asignarListaCancionesConcierto(albumConcierto, cancionConcierto, nombreConciertoAgregar);
                    break;

                case 11:
                    System.out.println("Consultar conciertos seleccionado...");

                    // Llama al método para obtener información sobre los conciertos
                    bandaTerminal.InfoConciertos();
                    break;

                case 12:
                    System.out.println("Agregar instrumentos a los miembros seleccionado...");
                    System.out.println("Nombre del miembro:");
                    String miembroInstrumento = scanner.nextLine();

                    System.out.println("Instrumento a agregar:");
                    String instrumentoAgregar = scanner.nextLine();

                    // Llama al método para agregar instrumentos a los miembros
                    bandaTerminal.agregarInstrumentoMiembro(miembroInstrumento, instrumentoAgregar);
                    break;

                default:
                    System.out.println("Elige un numero valido del menu de opciones");
            }
        }while (selector != 0);
    }

}
