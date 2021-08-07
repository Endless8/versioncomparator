package versioncomparator.unit;

import org.junit.jupiter.api.Test;
import versioncomparator.App;
import versioncomparator.VersionComparator;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    /**
     * Questo test verifica che la prima versione inserita sia precedente
     * rispetto alla seconda versione inserita.
     */
    @Test
    void previousVersion() {
        List<String> userInputs = Arrays.asList(
                "1.0.0",
                "1.0.1",
                "END_TEST"
        );

        ByteArrayInputStream byteArray = getUserInputByteArray(userInputs);
        System.setIn(byteArray);
        VersionComparator versionComparatorTest = new VersionComparator();
        versionComparatorTest.start();
        assertEquals(1, versionComparatorTest.getResult());
    }

    /**
     * Questo test verifica che la prima versione inserita sia successiva
     * rispetto alla seconda versione inserita.
     */
    @Test
    void nextVersion() {
        List<String> userInputs = Arrays.asList(
                "1.1.0",
                "1.0.1",
                "END_TEST"
        );

        ByteArrayInputStream byteArray = getUserInputByteArray(userInputs);
        System.setIn(byteArray);
        VersionComparator versionComparatorTest = new VersionComparator();
        versionComparatorTest.start();
        assertEquals(-1, versionComparatorTest.getResult());
    }

    /**
     * Questo test verifica che la prima versione inserita sia la stessa
     * rispetto alla seconda versione inserita.
     */
    @Test
    void sameVersion() {
        List<String> userInputs = Arrays.asList(
                "1.0.0",
                "1.0.0",
                "END_TEST"
        );

        ByteArrayInputStream byteArray = getUserInputByteArray(userInputs);
        System.setIn(byteArray);
        VersionComparator versionComparatorTest = new VersionComparator();
        versionComparatorTest.start();
        assertEquals(0, versionComparatorTest.getResult());
    }

    /**
     * Questo test verifica che la prima versione inserita sia un input vuoto,
     * alla ricezione del messaggio d'errore inserisce due versioni uguali.
     */
    @Test
    void firstVersionBlankInput() {
        List<String> userInputs = Arrays.asList(
                "EMPTY_INPUT",
                "1.0.0",
                "1.0.0",
                "END_TEST"
        );

        ByteArrayInputStream byteArray = getUserInputByteArray(userInputs);
        System.setIn(byteArray);
        VersionComparator versionComparatorTest = new VersionComparator();
        versionComparatorTest.start();
        assertEquals(0, versionComparatorTest.getResult());
    }

    /**
     * Questo test verifica che la prima versione inserita sia un input dal
     * formato non valido, alla ricezione del messaggio d'errore inserisce
     * due versioni uguali.
     */
    @Test
    void firstVersionWrongFormatInput() {
        List<String> userInputs = Arrays.asList(
                "3,14abc",
                "1.0.0",
                "1.0.0",
                "END_TEST"
        );

        ByteArrayInputStream byteArray = getUserInputByteArray(userInputs);
        System.setIn(byteArray);
        VersionComparator versionComparatorTest = new VersionComparator();
        versionComparatorTest.start();
        assertEquals(0, versionComparatorTest.getResult());
    }

    /**
     * Questo test verifica che la seconda versione inserita sia un input vuoto,
     * alla ricezione del messaggio d'errore inserisce una versione uguale alla
     * prima inserita.
     */
    @Test
    void secondVersionBlankInput() {
        String input = "1.0.0\n\n1.0.0\n\n";
        List<String> userInputs = Arrays.asList(
                "1.0.0",
                "EMPTY_INPUT",
                "1.0.0",
                "END_TEST"
        );

        ByteArrayInputStream byteArray = getUserInputByteArray(userInputs);
        System.setIn(byteArray);
        VersionComparator versionComparatorTest = new VersionComparator();
        versionComparatorTest.start();
        assertEquals(0, versionComparatorTest.getResult());
    }

    /**
     * Questo test verifica che la seconda versione inserita sia un input dal
     * formato non valido, alla ricezione del messaggio d'errore inserisce
     * una versione uguale alla prima inserita.
     */
    @Test
    void secondVersionWrongFormatInput() {
        String input = "1.0.0\nabc\n1.0.0\n\n";
        List<String> userInputs = Arrays.asList(
                "1.0.0",
                "3.14abc",
                "1.0.0",
                "END_TEST"
        );

        ByteArrayInputStream byteArray = getUserInputByteArray(userInputs);
        System.setIn(byteArray);
        VersionComparator versionComparatorTest = new VersionComparator();
        versionComparatorTest.start();
        assertEquals(0, versionComparatorTest.getResult());
    }

    /**
     * Questo test verifica che entrambi gli input siano vuoti, subito dopo
     * aver inserito l'input vuoto e aver ricevuto il messaggio d'errore inserisce
     * un input corretto uguale per entrambe le versioni.
     */
    @Test
    void allVersionsBlankInput() {
        String input = "\n1.0.0\n\n1.0.0\n\n";
        List<String> userInputs = Arrays.asList(
                "EMPTY_INPUT",
                "1.0.0",
                "EMPTY_INPUT",
                "1.0.0",
                "END_TEST"
        );

        ByteArrayInputStream byteArray = getUserInputByteArray(userInputs);
        System.setIn(byteArray);
        VersionComparator versionComparatorTest = new VersionComparator();
        versionComparatorTest.start();
        assertEquals(0, versionComparatorTest.getResult());
    }

    /**
     * Questo test verifica che entrambi gli input abbiano un formato non valido,
     * subito dopo aver inserito l'input vuoto e aver ricevuto il messaggio d'errore
     * inserisce un input corretto uguale per entrambe le versioni.
     */
    @Test
    void allVersionsWrongFormatInput() {
        String input = "abc\n1.0.0\nabc\n1.0.0\n\n";
        List<String> userInputs = Arrays.asList(
                "3,14abc",
                "1.0.0",
                "qwe1.2",
                "1.0.0",
                "END_TEST"
        );

        ByteArrayInputStream byteArray = getUserInputByteArray(userInputs);
        System.setIn(byteArray);
        VersionComparator versionComparatorTest = new VersionComparator();
        versionComparatorTest.start();
        assertEquals(0, versionComparatorTest.getResult());
    }

    ByteArrayInputStream getUserInputByteArray(List<String> userInputs) {
        String input = "";

        for (String userInput : userInputs) {
            switch (userInput) {
                case "EMPTY_INPUT":
                case "END_TEST":
                    input = input.concat("\n");
                    break;

                default:
                    input = input.concat(userInput + "\n");
                    break;
            }
        }

        ByteArrayInputStream byteArray = new ByteArrayInputStream(input.getBytes());
        return byteArray;
    }
}
