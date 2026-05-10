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

@RunWith(Parameterized.class)
public class RomanPrinterTest {
    private int input;
    private String expected;
    public RomanPrinterTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    // tabella dei dati per la parametrizzazione
    @Parameters(name = "Test: convert({0})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 1,
            "  _______ \n" + 
            " |__   __|\n" + 
            "    | |   \n" + 
            "    | |   \n" + 
            "  __| |__ \n" + 
            " |_______|\n"
            },
            { 2,
            "  _______   _______ \n" + 
            " |__   __| |__   __|\n" + 
            "    | |       | |   \n" + 
            "    | |       | |   \n" + 
            "  __| |__   __| |__ \n" + 
            " |_______| |_______|\n"
            },
            { 5,
            " __      __\n" + 
            " \\ \\    / /\n" + 
            "  \\ \\  / / \n" + 
            "   \\ \\/ /  \n" + 
            "    \\  /   \n" + 
            "     \\/    \n" 
            },
            { 10,
            " __   __\n" + 
            " \\ \\ / /\n" + 
            "  \\ V / \n" + 
            "   > <  \n" + 
            "  / . \\ \n" + 
            " /_/ \\_\\\n"
            },
            { 50,
            "  _      \n" + 
            " | |     \n" + 
            " | |     \n" + 
            " | |     \n" + 
            " | |____ \n" + 
            " |______|\n"
            },
            { 100,
            "   _____ \n" + 
            "  / ____|\n" + 
            " | |     \n" + 
            " | |     \n" + 
            " | |____ \n" + 
            "  \\_____|\n"
            },
            { 500,
            "  _____  \n" + 
            " |  __ \\ \n" + 
            " | |  | |\n" + 
            " | |  | |\n" + 
            " | |__| |\n" + 
            " |_____/ \n"
            },
            { 1000,
            "  __  __ \n" + 
            " |  \\/  |\n" + 
            " | \\  / |\n" + 
            " |  \\/  |\n" + 
            " | |  | |\n"  + 
            " |_|  |_|\n" 
            }
        });
    }

    @Test
    public void testNumbers() {
        // Arrange: implicito, i dati sono già preparati dal costruttore parametrizzato.
        String actual = RomanPrinter.print(input);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutOfBoundInteger() {
        int outOfBoundsInput = 0;
        RomanPrinter.print(outOfBoundsInput);
        // Assert: gestito implicitamente da "(expected = ...)"
    }

    @Test
    public void testUtilityClassConstructor() {
        // Arrange & Act
        RomanPrinter printer = new RomanPrinter();
        // Assert: verifichiamo semplicemente che l'oggetto sia stato creato
        org.junit.Assert.assertNotNull(printer);
    }
}