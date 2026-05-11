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
public class RomanPrinterTest {
    private int input;
    private String expected;

    public RomanPrinterTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    // Tabella dei dati: copre classi di equivalenza ("Right") e casi limite ("Boundaries")
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

    // Test per soddisfare le sezioni "Right" e "Boundaries"
    @Test
    public void testNumbers() {
        // Arrange: implicito, i dati sono già preparati dal costruttore parametrizzato.
        
        String actual = RomanPrinter.print(input); // Act
        
        assertEquals(expected, actual); // Assert
    }

    // Test per soddisfare la sezione "Error Conditions"
    @Test(expected = IllegalArgumentException.class)
    public void testOutOfBoundInteger() {
        
        int outOfBoundsInput = 0; // Arrange
        
        RomanPrinter.print(outOfBoundsInput); // Act

        // Assert: implicito, gestito da (expected = ...)
    }

    /* Sezioni "Inverse Relationship" e "Cross-Check":
    Non testati in RomanPrinter: la composizione ASCII matriciale riga-per-riga
    non si presta a controlli incrociati semplici, ed effettuare il parsing inverso 
    da testo ASCII a int è ampiamente fuori dal dominio delle specifiche fornite.
    Non scriviamo nemmeno la firma del metodo, così da non abbassare la code coverage.*/

    // Test per soddisfare la sezione "Performance Evaluation"
    @Test(timeout = 2000)
    public void testPerformanceOverEntireDomain() {
        // Arrange e Act
        for (int i = 1; i <= 1000; i++) {
            RomanPrinter.print(i);
        }

        // Assert: implicito, superato se stampa 1000 art in meno di 2 secondi
    }

    @Test
    public void testUtilityClassConstructor() {
        RomanPrinter printer = new RomanPrinter(); // Arrange e Act
        
        org.junit.Assert.assertNotNull(printer); // Assert
    }
}