package Calculate;

import java.util.Arrays;

import static Calculate.Converters.ArabicToRoman;
import static Calculate.Converters.RomanToArabic;

import static Calculate.Main.Roman;

class Operations {

    public static String Plus(String number1, String number2) {
        if (Arrays.asList(Roman).indexOf(number1) != -1 && Arrays.asList(Roman).indexOf(number2) != -1)
            return ArabicToRoman(RomanToArabic(number1) + RomanToArabic(number2));
        else return ((Integer.parseInt(number1) + Integer.parseInt(number2)) + "");
    }

    public static String Minus(String number1, String number2) throws NegativeRomanNumberException {
        if (Arrays.asList(Roman).indexOf(number1) != -1 && Arrays.asList(Roman).indexOf(number2) != -1) {
            if ((RomanToArabic(number1) - RomanToArabic(number2)) < 1) throw new NegativeRomanNumberException();
            else return ArabicToRoman(RomanToArabic(number1) - RomanToArabic(number2));
        } else return ((Integer.parseInt(number1) - Integer.parseInt(number2)) + "");
    }

    public static String Multiply(String number1, String number2) {
        if (Arrays.asList(Roman).indexOf(number1) != -1 && Arrays.asList(Roman).indexOf(number2) != -1)
            return ArabicToRoman(RomanToArabic(number1) * RomanToArabic(number2));
        else return ((Integer.parseInt(number1) * Integer.parseInt(number2)) + "");
    }

    public static String Division(String number1, String number2) {
        if (Arrays.asList(Roman).indexOf(number1) != -1 && Arrays.asList(Roman).indexOf(number2) != -1)
            return ArabicToRoman(RomanToArabic(number1) / RomanToArabic(number2));
        else return ((Integer.parseInt(number1) / Integer.parseInt(number2)) + "");
    }
}
