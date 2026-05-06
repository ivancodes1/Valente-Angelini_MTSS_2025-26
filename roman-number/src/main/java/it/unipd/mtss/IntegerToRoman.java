////////////////////////////////////////////////////////////////////
// IVAN VALENTE 2147985
// MATTEO ANGELINI 2101737
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class IntegerToRoman {
    
    public static String convert(int number) throws IllegalArgumentException {
        String errorString = " is not valid. Must be > 0 and <= 3";
        if (number < 1 || number > 3) throw new IllegalArgumentException(number + errorString);
        String result = "";
        for (int i = 0; i < number; ++i) result += "I";
        return result;
    }

}
//