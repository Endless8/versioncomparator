package versioncomparator.unit;

import org.junit.jupiter.api.Test;
import versioncomparator.App;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    /**
     * Questo test verifica che la prima versione inserita sia precedente
     * rispetto alla seconda versione inserita.
     */
    @Test
    void previousVersion() {
        String input = "1.0.0\n1.0.1\n\n";
        ByteArrayInputStream byteArray = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArray);
        int result = App.mainTest();
        assertEquals(1, result);
    }

    /**
     * Questo test verifica che la prima versione inserita sia successiva
     * rispetto alla seconda versione inserita.
     */
    @Test
    void nextVersion() {
        String input = "1.1.0\n1.0.1\n\n";
        ByteArrayInputStream byteArray = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArray);
        int result = App.mainTest();
        assertEquals(-1, result);
    }

    /**
     * Questo test verifica che la prima versione inserita sia la stessa
     * rispetto alla seconda versione inserita.
     */
    @Test
    void sameVersion() {
        String input = "1.0.0\n1.0.0\n\n";
        ByteArrayInputStream byteArray = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArray);
        int result = App.mainTest();
        assertEquals(0, result);
    }

    /**
     * Questo test verifica che la prima versione inserita sia un input vuoto,
     * alla ricezione del messaggio d'errore inserisce due versioni uguali.
     */
    @Test
    void firstVersionBlankInput() {
        String input = "\n1.0.0\n1.0.0\n\n";
        ByteArrayInputStream byteArray = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArray);
        int result = App.mainTest();
        assertEquals(0, result);
    }

    /**
     * Questo test verifica che la prima versione inserita sia un input dal
     * formato non valido, alla ricezione del messaggio d'errore inserisce
     * due versioni uguali.
     */
    @Test
    void firstVersionWrongFormatInput() {
        String input = "abc\n1.0.0\n1.0.0\n\n";
        ByteArrayInputStream byteArray = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArray);
        int result = App.mainTest();
        assertEquals(0, result);
    }

    /**
     * Questo test verifica che la seconda versione inserita sia un input vuoto,
     * alla ricezione del messaggio d'errore inserisce una versione uguale alla
     * prima inserita.
     */
    @Test
    void secondVersionBlankInput() {
        String input = "1.0.0\n\n1.0.0\n\n";
        ByteArrayInputStream byteArray = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArray);
        int result = App.mainTest();
        assertEquals(0, result);
    }

    /**
     * Questo test verifica che la seconda versione inserita sia un input dal
     * formato non valido, alla ricezione del messaggio d'errore inserisce
     * una versione uguale alla prima inserita.
     */
    @Test
    void secondVersionWrongFormatInput() {
        String input = "1.0.0\nabc\n1.0.0\n\n";
        ByteArrayInputStream byteArray = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArray);
        int result = App.mainTest();
        assertEquals(0, result);
    }

    /**
     * Questo test verifica che entrambi gli input siano vuoti, subito dopo
     * aver inserito l'input vuoto e aver ricevuto il messaggio d'errore inserisce
     * un input corretto uguale per entrambe le versioni.
     */
    @Test
    void allVersionsBlankInput() {
        String input = "\n1.0.0\n\n1.0.0\n\n";
        ByteArrayInputStream byteArray = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArray);
        int result = App.mainTest();
        assertEquals(0, result);
    }

    /**
     * Questo test verifica che entrambi gli input abbiano un formato non valido,
     * subito dopo aver inserito l'input vuoto e aver ricevuto il messaggio d'errore
     * inserisce un input corretto uguale per entrambe le versioni.
     */
    @Test
    void allVersionsWrongFormatInput() {
        String input = "abc\n1.0.0\nabc\n1.0.0\n\n";
        ByteArrayInputStream byteArray = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArray);
        int result = App.mainTest();
        assertEquals(0, result);
    }
}
