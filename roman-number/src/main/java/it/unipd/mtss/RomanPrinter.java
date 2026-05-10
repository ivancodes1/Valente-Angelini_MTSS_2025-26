////////////////////////////////////////////////////////////////////
// IVAN VALENTE 2147985
// MATTEO ANGELINI 2101737
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class RomanPrinter {
    private final static String[][] art = {
        //I             V                X             L            C             D             M
        //0             1                2             3            4             5             6
        {"  _______ ", " __      __",   " __   __",   "  _      ", "   _____ ",  "  _____  ",  "  __  __ " },
        {" |__   __|", " \\ \\    / /", " \\ \\ / /", " | |     ", "  / ____|",  " |  __ \\ ", " |  \\/  |"},
        {"    | |   ", "  \\ \\  / / ", "  \\ V / ",  " | |     ", " | |     ",  " | |  | |",  " | \\  / |"},
        {"    | |   ", "   \\ \\/ /  ", "   > <  ",   " | |     ", " | |     ",  " | |  | |",  " |  \\/  |"},
        {"  __| |__ ", "    \\  /   ",  "  / . \\ ",  " | |____ ", " | |____ ",  " | |__| |",  " | |  | |" },
        {" |_______|", "     \\/    ",  " /_/ \\_\\", " |______|", "  \\_____|", " |_____/ ",  " |_|  |_|" }
    };

    public static String print(int num) throws IllegalArgumentException {
        return printAsciiArt(IntegerToRoman.convert(num));
    }

    private static String printAsciiArt(String romanNumber) throws IllegalArgumentException {
        if (!validate(romanNumber)) {
            throw new IllegalArgumentException(romanNumber + " is not a valid Roman Numeral");
        }
        String[] lines = {"", "", "", "", "", ""};
        for (char c : romanNumber.toCharArray()) {
            switch (c) {
                case 'I':
                    lines[0] += art[0][0];
                    lines[1] += art[1][0];
                    lines[2] += art[2][0];
                    lines[3] += art[3][0];
                    lines[4] += art[4][0];
                    lines[5] += art[5][0];
                    break;
                case 'V':
                    lines[0] += art[0][1];
                    lines[1] += art[1][1];
                    lines[2] += art[2][1];
                    lines[3] += art[3][1];
                    lines[4] += art[4][1];
                    lines[5] += art[5][1];
                    break;
                case 'X':
                    lines[0] += art[0][2];
                    lines[1] += art[1][2];
                    lines[2] += art[2][2];
                    lines[3] += art[3][2];
                    lines[4] += art[4][2];
                    lines[5] += art[5][2];
                    break;
                case 'L':
                    lines[0] += art[0][3];
                    lines[1] += art[1][3];
                    lines[2] += art[2][3];
                    lines[3] += art[3][3];
                    lines[4] += art[4][3];
                    lines[5] += art[5][3];
                    break;
                case 'C':
                    lines[0] += art[0][4];
                    lines[1] += art[1][4];
                    lines[2] += art[2][4];
                    lines[3] += art[3][4];
                    lines[4] += art[4][4];
                    lines[5] += art[5][4];
                    break;
                case 'D':
                    lines[0] += art[0][5];
                    lines[1] += art[1][5];
                    lines[2] += art[2][5];
                    lines[3] += art[3][5];
                    lines[4] += art[4][5];
                    lines[5] += art[5][5];
                    break;
                case 'M':
                    lines[0] += art[0][6];
                    lines[1] += art[1][6];
                    lines[2] += art[2][6];
                    lines[3] += art[3][6];
                    lines[4] += art[4][6];
                    lines[5] += art[5][6];
                    break;
            }
        }
        String result = "";
        for (String line : lines) result += line + "\n";
        return result;
    }

    private static boolean validate(String romanNumber) {
        String romanRegex = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        return romanNumber.matches(romanRegex);
    }
}