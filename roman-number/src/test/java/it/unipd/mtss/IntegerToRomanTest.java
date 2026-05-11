////////////////////////////////////////////////////////////////////
// IVAN VALENTE 2147985
// MATTEO ANGELINI 2101737
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/* Poiché ci sono tanti numeri da convertire, facciamo affidamento sulla parametrizzazione 
per coprire le sezioni "Right" e "Boundaries" del pattern "Right BICEP" in modo efficiente */
@RunWith(Parameterized.class)
public class IntegerToRomanTest {
    private int input;
    private String expected;
    public IntegerToRomanTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    // Tabella dei dati: copre classi di equivalenza ("Right") e casi limite ("Boundaries")
    @Parameters(name = "Test: convert({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 1, "I" }, { 3, "III" }, // unità base
            { 4, "IV" }, { 5, "V" }, // sottrazione e limite 5
            { 8, "VIII" }, { 9, "IX" }, // unità alte e sottrazione 9
            { 10, "X" }, // decina esatta
            { 14, "XIV" }, { 15, "XV" }, // decina + sottrazione/limite
            { 19, "XIX" }, { 20, "XX" }, // limiti decine vecchie
            { 39, "XXXIX" }, // limite massimo prima del cambio lettera
            { 40, "XL" }, // eccezione sottrazione decine
            { 44, "XLIV" }, { 49, "XLIX" }, // combinazioni complesse
            { 50, "L" }, // limite 50
            { 51, "LI" }, { 89, "LXXXIX" }, // numeri post-50 e limite pre-90
            { 90, "XC" }, // eccezione sottrazione 90
            { 94, "XCIV" }, { 99, "XCIX" }, // combinazioni complesse post-90
            { 100, "C" }, // centinaia esatta
            { 140, "CXL" }, { 149, "CXLIX" }, { 150, "CL" }, // centinaia + sottrazione/limite
            { 190, "CXC" }, { 199, "CXCIX" }, { 200, "CC" }, // limiti centinaia vecchie
            { 399, "CCCXCIX" }, // limite massimo prima del cambio lettera
            { 400, "CD" }, // eccezione sottrazione centinaia
            { 444, "CDXLIV"}, { 488, "CDLXXXVIII" }, { 499, "CDXCIX"}, // combinazioni complesse post-400
            { 500, "D"}, // limite 500
            { 501, "DI"}, { 888, "DCCCLXXXVIII"}, { 899, "DCCCXCIX"}, // numeri post-500 e limite pre-900
            { 900, "CM" }, // eccezione sottrazione 900
            { 949, "CMXLIX" }, { 999, "CMXCIX" }, // combinazioni complesse post-900
            { 1000, "M" } // limite superiore assoluto
        });
    }

    // Test per soddisfare le sezioni "Right" e "Boundaries"
    @Test
    public void testNumbersOneToOneThousand() {
        // Arrange: implicito, i dati sono già preparati dal costruttore parametrizzato.

        String actual = IntegerToRoman.convert(input); // Act

        assertEquals(expected, actual); // Assert
    }

    // Test per soddisfare la sezione "Error Conditions"
    @Test(expected = IllegalArgumentException.class)
    public void testZeroThrowsException() {
        int outOfBoundsInput = 0; // Arrange

        IntegerToRoman.convert(outOfBoundsInput); // Act

        // Assert: implicito, gestito da (expected = ...)
    }

    // Test per soddisfare la sezione "Error Conditions"
    @Test(expected = IllegalArgumentException.class)
    public void testOneThousandOneThrowsException() {
        int outOfBoundsInput = 1001; // Arrange

        IntegerToRoman.convert(outOfBoundsInput); // Act

        // Assert: implicito, gestito da (expected = ...)
    }

    /* Sezione "Inverse Relationship":
    Non testato: fuori dominio. Le specifiche non richiedono l'implementazione del decodificatore inverso (da Romano ad Arabo).
    Non scriviamo nemmeno la firma del metodo, così da non abbassare la code coverage.*/

    // Test per soddisfare la sezione "Cross-Check"
    @Test
    public void testCrossCheckWithAlternativeLogic() {
        // Arrange: creiamo il numero 3 con una logica alternativa (concatenazione iterativa)
        int numberToTest = 3;
        String expectedCrossCheck = "";
        for (int i = 0; i < numberToTest; i++) {
            expectedCrossCheck += "I";
        }
        
        String actual = IntegerToRoman.convert(numberToTest); // Act
        
        assertEquals(expectedCrossCheck, actual); // Assert
    }

    // Test per soddisfare la sezione "Performance Evaluation"
    @Test(timeout = 500) // JUnit 4 usa 'timeout' per fallire se il metodo impiega più dei millisecondi indicati
    public void testPerformanceOverEntireDomain() {
        // Arrange e Act
        for (int i = 1; i <= 1000; i++) {
            IntegerToRoman.convert(i);
        }

        // Assert: implicito, il test passa se termina prima dello scadere del timeout (500ms)
    }

    @Test
    public void testUtilityClassConstructor() {
        IntegerToRoman converter = new IntegerToRoman(); // Arrange e Act

        // Assert: verifichiamo semplicemente che l'oggetto sia stato creato, per avere così 100% di code coverage
        org.junit.Assert.assertNotNull(converter);
    }
}