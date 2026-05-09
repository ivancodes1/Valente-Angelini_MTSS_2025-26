////////////////////////////////////////////////////////////////////
// IVAN VALENTE 2147985
// MATTEO ANGELINI 2101737
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class IntegerToRoman {
    
    public static String convert(int number) throws IllegalArgumentException {
        if (number < 1 || number > 1000) {
            throw new IllegalArgumentException(number + " is not valid. Must be > 0 and <= 1000");
        }
        return convertHundreds(number) + convertTens(number % 100) + convertUnits(number % 10);
    }

    // Metodo helper privato: si occupa SOLO delle centinaia (fino a 1000)
    private static String convertHundreds(int number) {
        String result = "";
        if (number == 1000) {
            result += "M";
            number -= 1000;
        } else if (number >= 900) {
            result += "CM";
            number -= 900;
        } else if (number >= 500) {
            result += "D";
            number -= 500;
        } else if (number >= 400) {
            result += "CD";
            number -= 400;
        }
        while (number >= 100) {
            result += "C";
            number -= 100;
        }
        return result;
    }

    // Metodo helper privato: si occupa SOLO delle decine
    private static String convertTens(int number) {
        String result = "";
        if (number >= 90) {
            result += "XC";
            number -= 90;
        } else if (number >= 50) {
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
        return result;
    }

    // Metodo helper privato: si occupa SOLO delle unità
    private static String convertUnits(int number) {
        String result = "";
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