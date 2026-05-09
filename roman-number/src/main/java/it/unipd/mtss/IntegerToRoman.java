////////////////////////////////////////////////////////////////////
// IVAN VALENTE 2147985
// MATTEO ANGELINI 2101737
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class IntegerToRoman {
    
    public static String convert(int number) throws IllegalArgumentException {
        if (number < 1 || number > 50) {
            throw new IllegalArgumentException(number + " is not valid. Must be > 0 and <= 50");
        }
        String result = "";
        if (number == 50) {
            result += "L";
            number -= 50;
        } else if (number >= 40) {
            result += "XL";
            number -= 40;
        }
        while (number >= 10) {
            result += "X";
            number -= 10;
        }
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
        return result;
    }
}