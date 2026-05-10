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

/* poiché ci sono tanti numeri da convertire (e quindi da controllare), fare
tanti test singoli è inefficiente e inadeguato. Meglio quindi parametrizzare
come visto a lezione*/
@RunWith(Parameterized.class)
public class IntegerToRomanTest {
    private int input;
    private String expected;
    public IntegerToRomanTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    // tabella dei dati per la parametrizzazione
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

    @Test
    public void testNumbersOneToOneThousand() {
        // Arrange: implicito, i dati sono già preparati dal costruttore parametrizzato.
        String actual = IntegerToRoman.convert(input);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroThrowsException() {
        int outOfBoundsInput = 0;
        IntegerToRoman.convert(outOfBoundsInput);
        // Assert: gestito implicitamente da "(expected = ...)"
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOneThousandOneThrowsException() {
        int outOfBoundsInput = 1001;
        IntegerToRoman.convert(outOfBoundsInput);
        // Assert: gestito implicitamente da "(expected = ...)"
    }
}