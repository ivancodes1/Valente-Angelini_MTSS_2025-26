////////////////////////////////////////////////////////////////////
// IVAN VALENTE 2147985
// MATTEO ANGELINI 2101737
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class IntegerToRoman {
    
    public static String convert(int number) throws IllegalArgumentException {
        if (number < 1 || number > 20) {
            throw new IllegalArgumentException(number + " is not valid. Must be > 0 and <= 20");
        }
        String result = "";
        while (number >= 10) {
            result += "X";
            number -= 10;
        }
        if (number > 0) {
            if (number % 5 == 4) {
                result += "I" + ((number == 9) ? "X" : "V");
            } else {
                if (number >= 5) {
                    result += "V";
                    number -= 5;
                }
                for (int i = 0; i < number; ++i) {
                    result += "I";
                }
            }
        }
        return result;
    }
}