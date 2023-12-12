package RockyCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BandaTest {
    private Banda banda;

    @BeforeEach
    public void Bandas(){
        banda = new Banda("Salsa","tomate", LocalDate.of(2020,11,23));
    }
    @Test
    public void testAgregarMiembroCorrecto() {
        // Verificar que el método no lance una excepción inesperada
        assertDoesNotThrow(() -> {
            banda.AgregarMiembro("Axel", "Lider");
        });
    }

    @Test
    public void testAgregarMiembroRepetido() {
        // Agregar un miembro inicialmente
        assertDoesNotThrow(() -> {
            banda.AgregarMiembro("Axel", "Lider");
        });
        // Verificar que agregar el mismo miembro lanza la excepción esperada
        assertThrows(Exception.class, () -> {
            banda.AgregarMiembro("Axel", "Lider");
        });
    }

    @Test
    public void testEliminarMiembroExistente() {
        // Agregar un miembro para luego intentar eliminarlo
        assertDoesNotThrow(() -> {
            banda.AgregarMiembro("Axel", "Lider");
        });

        // Verificar que eliminar un miembro existente no lance ninguna excepción
        assertDoesNotThrow(() -> {
            banda.EliminarMiembro("Axel");
        });

        assertTrue(banda.getMiembros().isEmpty());
    }

    @Test
    public void testEliminarMiembroNoExistente() {
        // Verificar que intentar eliminar un miembro que no existe lance la excepción esperada
        assertThrows(Exception.class, () -> {
            banda.EliminarMiembro("MiembroInexistente");
        });
    }

    @Test
    public void testAgregarInstrumentoMiembroExitoso() {
        // Agregar un miembro a la banda
        assertDoesNotThrow(() -> {
            banda.AgregarMiembro("Axel", "Lider");
        });

        // Verificar que se pueda agregar un instrumento al miembro existente
        assertDoesNotThrow(() -> {
            banda.agregarInstrumentoMiembro("Axel", "Guitarra");
        });

        // Verificar que el instrumento se haya agregado correctamente al miembro
        Miembro axel = banda.BuscarMiembro("Axel");
        assertNotNull(axel);
        assertTrue(axel.getInstrumentos().contains("Guitarra"));
    }

    @Test
    public void testAgregarInstrumentoMiembroNoExistente() {
        // Verificar que no se pueda agregar un instrumento a un miembro inexistente
        assertDoesNotThrow(() -> {
            banda.agregarInstrumentoMiembro("MiembroInexistente", "Batería");
        });

        // Verificar que el miembro sigue sin existir y no se ha creado
        assertNull(banda.BuscarMiembro("MiembroInexistente"));
    }

    @Test
    public void testAgregarInstrumentoRepetido() {
        // Agregar un miembro a la banda
        assertDoesNotThrow(() -> {
            banda.AgregarMiembro("Juan", "Bajista");
        });

        // Verificar que se pueda agregar un instrumento al miembro existente
        assertDoesNotThrow(() -> {
            banda.agregarInstrumentoMiembro("Juan", "Bajo");
        });

        // Verificar que no se pueda agregar el mismo instrumento al miembro
        assertDoesNotThrow(() -> {
            banda.agregarInstrumentoMiembro("Juan", "Bajo");
        });

        // Verificar que el miembro tiene solo un instrumento
        Miembro juan = banda.BuscarMiembro("Juan");
        assertNotNull(juan);
        assertEquals(1, juan.getInstrumentos().size());
    }

    @Test
    public void testAgregarCancionAlbumExitoso() {
        // Crear un álbum
        assertDoesNotThrow(() -> {
            banda.NuevoAlbum("MiAlbum", LocalDate.now());
        });

        // Verificar que se pueda agregar una nueva canción al álbum
        assertTrue(banda.agregarCancionAlbum("MiAlbum", "MiCancion", 3.5f));

        // Verificar que la canción se haya agregado correctamente al álbum
        Album miAlbum = banda.BuscarAlbum("MiAlbum");
        assertNotNull(miAlbum);
        assertTrue(miAlbum.cancionExiste("MiCancion"));
    }

    @Test
    public void testAgregarCancionAlbumExistente() {
        // Crear un álbum y agregar una canción
        assertDoesNotThrow(() -> {
            banda.NuevoAlbum("MiAlbum", LocalDate.now());
            banda.agregarCancionAlbum("MiAlbum", "MiCancion", 3.5f);
        });

        // Verificar que no se pueda agregar la misma canción al álbum
        assertFalse(banda.agregarCancionAlbum("MiAlbum", "MiCancion", 3.5f));

        // Verificar que el álbum tiene solo una canción
        Album miAlbum = banda.BuscarAlbum("MiAlbum");
        assertNotNull(miAlbum);
        assertEquals(1, miAlbum.getCanciones().size());
    }

    @Test
    public void testAgregarCancionAlbumInexistente() {
        // Verificar que no se pueda agregar una canción a un álbum inexistente
        assertFalse(banda.agregarCancionAlbum("AlbumInexistente", "CancionNueva", 4.2f));

        // Verificar que el álbum sigue sin existir y no se ha creado
        assertNull(banda.BuscarAlbum("AlbumInexistente"));
    }

    @Test
    public void testAgregarCancionConciertoExitoso() {
        // Crear un álbum y agregar una canción
        assertDoesNotThrow(() -> {
            banda.NuevoAlbum("MiAlbum", LocalDate.now());
            banda.agregarCancionAlbum("MiAlbum", "MiCancion", 3.5f);
        });

        // Crear un concierto
        assertDoesNotThrow(() -> {
            banda.programarConcierto("MiConcierto", "Lugar", LocalDate.now(), LocalDate.now(), 100, 0);
        });

        // Verificar que se pueda agregar la canción al concierto
        assertTrue(banda.agregarCancionConcierto("MiAlbum", "MiCancion", "MiConcierto"));

        // Verificar que la canción se haya agregado correctamente al concierto
        Concierto miConcierto = banda.buscarConcierto("MiConcierto");
        assertNotNull(miConcierto);
        assertTrue(miConcierto.getCanciones().contains(banda.BuscarAlbum("MiAlbum").buscarCancion("MiCancion")));
    }

    @Test
    public void testAgregarCancionConciertoExistente() {
        // Crear un álbum y agregar una canción
        assertDoesNotThrow(() -> {
            banda.NuevoAlbum("MiAlbum", LocalDate.now());
            banda.agregarCancionAlbum("MiAlbum", "MiCancion", 3.5f);
        });

        // Crear un concierto y agregar la misma canción al concierto
        assertDoesNotThrow(() -> {
            banda.programarConcierto("MiConcierto", "Lugar", LocalDate.now(), LocalDate.now(), 100, 0);
            banda.agregarCancionConcierto("MiAlbum", "MiCancion", "MiConcierto");
        });

        // Verificar que no se pueda agregar la misma canción al concierto otra vez
        assertFalse(banda.agregarCancionConcierto("MiAlbum", "MiCancion", "MiConcierto"));

        // Verificar que el concierto tiene solo una canción
        Concierto miConcierto = banda.buscarConcierto("MiConcierto");
        assertNotNull(miConcierto);
        assertEquals(1, miConcierto.getCanciones().size());
    }

    @Test
    public void testAgregarCancionConciertoInexistente() {
        // Verificar que no se pueda agregar una canción a un concierto inexistente
        assertFalse(banda.agregarCancionConcierto("MiAlbum", "MiCancion", "ConciertoInexistente"));

        // Verificar que el concierto sigue sin existir y no se ha creado
        assertNull(banda.buscarConcierto("ConciertoInexistente"));
    }

    @Test
    public void testAgregarCancionConciertoCancionInexistente() {
        // Crear un álbum sin agregar canciones
        assertDoesNotThrow(() -> {
            banda.NuevoAlbum("MiAlbum", LocalDate.now());
        });

        // Crear un concierto
        assertDoesNotThrow(() -> {
            banda.programarConcierto("MiConcierto", "Lugar", LocalDate.now(), LocalDate.now(), 100, 0);
        });

        // Verificar que no se pueda agregar una canción inexistente al concierto
        assertFalse(banda.agregarCancionConcierto("MiAlbum", "CancionInexistente", "MiConcierto"));

        // Verificar que el concierto sigue sin tener canciones
        Concierto miConcierto = banda.buscarConcierto("MiConcierto");
        assertNotNull(miConcierto);
        assertTrue(miConcierto.getCanciones().isEmpty());
    }

    @Test
    public void testProgramarConciertoExitoso() {
        // Programar un concierto
        Concierto concierto = banda.programarConcierto("MiConcierto", "Lugar", LocalDate.now(), LocalDate.now(), 100, 0);

        // Verificar que el concierto se haya programado correctamente
        assertNotNull(concierto);
        assertEquals("MiConcierto", concierto.getNombre());
        assertEquals("Lugar", concierto.getLugar());
        assertEquals(LocalDate.now(), concierto.getFecha());
        assertEquals(LocalDate.now(), concierto.getHora());
        assertEquals(100, concierto.getCapacidad());
        assertEquals(0, concierto.getBoletos());
    }

    @Test
    public void testProgramarConciertoExistente() {
        // Programar un concierto
        Concierto conciertoOriginal = banda.programarConcierto("MiConcierto", "Lugar", LocalDate.now(), LocalDate.now(), 100, 0);

        // Verificar que el concierto ya existía y no se haya creado uno nuevo
        assertNull(banda.programarConcierto("MiConcierto", "NuevoLugar", LocalDate.now(), LocalDate.now(), 200, 50));

        // Verificar que el concierto conserva sus propiedades originales
        assertNotNull(conciertoOriginal);
        assertEquals("MiConcierto", conciertoOriginal.getNombre());
        assertEquals("Lugar", conciertoOriginal.getLugar());
        assertEquals(LocalDate.now(), conciertoOriginal.getFecha());
        assertEquals(LocalDate.now(), conciertoOriginal.getHora());
        assertEquals(100, conciertoOriginal.getCapacidad());
        assertEquals(0, conciertoOriginal.getBoletos());
    }

    @Test
    public void testNuevoAlbumExitoso() {
        // Agregar un álbum nuevo
        assertDoesNotThrow(() -> {
            banda.NuevoAlbum("MiAlbum", LocalDate.now());
        });

        // Verificar que el álbum se haya creado correctamente
        Album miAlbum = banda.BuscarAlbum("MiAlbum");
        assertNotNull(miAlbum);
        assertEquals("MiAlbum", miAlbum.getNombre());
        assertEquals(LocalDate.now(), miAlbum.getFecha());
    }

    @Test
    public void testNuevoAlbumExistente() {
        // Agregar un álbum inicialmente
        assertDoesNotThrow(() -> {
            banda.NuevoAlbum("MiAlbum", LocalDate.now());
        });

        // Verificar que no se pueda agregar el mismo álbum otra vez
        assertDoesNotThrow(() -> {
            banda.NuevoAlbum("MiAlbum", LocalDate.now());
        });

        // Verificar que sigue existiendo solo un álbum con el nombre original
        Album miAlbum = banda.BuscarAlbum("MiAlbum");
        assertNotNull(miAlbum);
        assertEquals(1, banda.getAlbumes().size());
    }

    @Test
    public void testConsultarAlbumExitoso() {
        // Agregar un álbum
        assertDoesNotThrow(() -> {
            banda.NuevoAlbum("MiAlbum", LocalDate.now());
        });

        // Consultar el álbum y verificar que se devuelvan sus propiedades
        String resultado = banda.ConsultarAlbum("MiAlbum");
        assertNotNull(resultado);
        assertTrue(resultado.contains("MiAlbum"));
        assertTrue(resultado.contains(LocalDate.now().toString()));
    }

    @Test
    public void testConsultarAlbumInexistente() {
        // Consultar un álbum inexistente y verificar que el resultado sea una cadena vacía
        String resultado = banda.ConsultarAlbum("AlbumInexistente");
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }
}