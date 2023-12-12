package RockyCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class AlbumTest {
    private Album album;
    @BeforeEach
    public void albumes(){
        album = new Album("puespues", LocalDate.of(2020,11,23));
        album.agregarCancion("bartolo",5.50f);
    }

    @Test
    public void testBuscarIncorrectaCancion(){
        assertEquals(null,album.buscarCancion("asarar"));
    }

    @Test
    public void testBuscarCorrectaCancion(){
        Cancion cancion = new Cancion("bartolo",5.5f);
        assertEquals(cancion,album.buscarCancion("bartolo"));
    }




}