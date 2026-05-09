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

/* essendo che stiamo aumentando i numeri da convertire (e quindi da controllare)
meglio parametrizzare come visto a lezione per non fare troppi test singoli*/
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
            { 50, "L" } // limite superiore attuale
        });
    }

    @Test
    public void testNumbersOneToFifty() {
        // qui l'arrange è "implicito": i dati sono già preparati dal costruttore parametrizzato.
        String actual = IntegerToRoman.convert(input);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroThrowsException() {
        int outOfBoundsInput = 0;
        IntegerToRoman.convert(outOfBoundsInput);
        // qui l'assert è gestito implicitamente da "(expected = ...)"
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFiftyOneThrowsException() {
        int outOfBoundsInput = 51;
        IntegerToRoman.convert(outOfBoundsInput);
        // qui l'assert è gestito implicitamente da "(expected = ...)"
    }
}