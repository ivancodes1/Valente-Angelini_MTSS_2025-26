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

/* */
@RunWith(Parameterized.class)
public class RomanPrinterTest {
    private int input;
    private String expected;
    public RomanPrinterTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    // tabella dei dati per la parametrizzazione
    @Parameters(name = "Test: convert({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 1,
            "  _______ \n" + //
            " |__   __|\n" + //
            "    | |   \n" + //
            "    | |   \n" + //
            "  __| |__ \n" + //
            " |_______|\n"
            },
            { 5,
            " __      __\n" + //
            " \\ \\    / /\n" + //
            "  \\ \\  / / \n" + //
            "   \\ \\/ /  \n" + //
            "    \\  /   \n" + //
            "     \\/    \n" 
            },
            { 10,
            " __   __\n" + //
            " \\ \\ / /\n" + //
            "  \\ V / \n" + //
            "   > <  \n" + //
            "  / . \\ \n" + //
            " /_/ \\_\\\n"
            },
            { 50,
            "  _      \n" + //
            " | |     \n" + //
            " | |     \n" + //
            " | |     \n" + //
            " | |____ \n" + //
            " |______|\n"
            },
            { 100,
            "   _____ \n" + //
            "  / ____|\n" + //
            " | |     \n" + //
            " | |     \n" + //
            " | |____ \n" + //
            "  \\_____|\n"
            },
            { 500,
            "  _____  \n" + //
            " |  __ \\ \n" + //
            " | |  | |\n" + //
            " | |  | |\n" + //
            " | |__| |\n" + //
            " |_____/ \n"
            },
            { 1000,
            "  __  __ \n" + //
            " |  \\/  |\n" + //
            " | \\  / |\n" + //
            " |  \\/  |\n" + //
            " | |  | |\n"  + //
            " |_|  |_|\n" 
            }
        });
    }

    @Test
    public void testNumbers() {
        // Arrange: implicito, i dati sono già preparati dal costruttore parametrizzato.
        String actual = RomanPrinter.AsciiArt(input);
        assertEquals(expected, actual);
    }

	@Test(expected = IllegalArgumentException.class)
    public void testOutOfBoundInteger() {
        int outOfBoundsInput = 0;
        RomanPrinter.AsciiArt(outOfBoundsInput);
        // Assert: gestito implicitamente da "(expected = ...)"
    }

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidString() {
		String invalidString = "AIC";
        RomanPrinter.AsciiArt(invalidString);
        // Assert: gestito implicitamente da "(expected = ...)"
	}
}
