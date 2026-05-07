////////////////////////////////////////////////////////////////////
// IVAN VALENTE 2147985
// MATTEO ANGELINI 2101737
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntegerToRomanTest {
    @Test
    public void testNumbersOneToThree() {
        String expected = "";
        for (int num = 1; num <= 3; ++num) {
            expected += "I";
            String actual = IntegerToRoman.convert(num);
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testNumberFour() {
        int input = 4;
        String expected = "IV";
        String actual = IntegerToRoman.convert(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testNumberFive() {
        int input = 5;
        String expected = "V";
        String actual = IntegerToRoman.convert(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testNumbersSixToEight() {
        String expected = "V";
        for (int num = 6; num <= 8; ++num) {
            expected += "I";
            String actual = IntegerToRoman.convert(num);
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testNumberNine() {
        int input = 9;
        String expected = "IX";
        String actual = IntegerToRoman.convert(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testNumberTen() {
        int input = 10;
        String expected = "X";
        String actual = IntegerToRoman.convert(input);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroThrowsException() {
        int input = 0;
        IntegerToRoman.convert(input);
		//qui l'assert è gestito implicitamente da "(expected = ...)"
    }

    @Test(expected = IllegalArgumentException.class)
    public void testElevenThrowsException() {
        int input = 11;
        IntegerToRoman.convert(input);
		//qui l'assert è gestito implicitamente da "(expected = ...)"
    }
}