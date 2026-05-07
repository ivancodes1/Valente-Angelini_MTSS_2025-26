////////////////////////////////////////////////////////////////////
// IVAN VALENTE 2147985
// MATTEO ANGELINI 2101737
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class IntegerToRoman {
    
    public static String convert(int number) throws IllegalArgumentException {
        String errorString = " is not valid. Must be > 0 and <= 6";
        if (number < 1 || number > 6) throw new IllegalArgumentException(number + errorString);
        String result = "";
        if (number == 4) return "IV";
        if (number >= 5) {
            number -= 5;
            result += "V";
        }
        for (int i = 0; i < number; ++i) result += "I";
        return result;
    }

}