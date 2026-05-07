////////////////////////////////////////////////////////////////////
// IVAN VALENTE 2147985
// MATTEO ANGELINI 2101737
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class IntegerToRoman {
    
    public static String convert(int number) throws IllegalArgumentException {
        String errorString = " is not valid. Must be > 0 and <= 10";
        if (number < 1 || number > 10) throw new IllegalArgumentException(number + errorString);
        if (number == 10) return "X";
        String result = "";
        if (number % 5 == 4) {
            result += "I" + ((number > 5)? "X": "V");
        } else {
            if (number >= 5) {
                result += "V";
                number -= 5;
            }
            for (int i = 0; i < number; ++i) result += "I";
        }
        return result;
    }
}