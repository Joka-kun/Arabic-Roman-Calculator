package Calculate;

import java.util.Arrays;

import static Calculate.Main.Arabic;
import static Calculate.Main.Roman;

class Converters {

    public static String ArabicToRoman(int ArabicNumber) {
        String value = "";
        while (ArabicNumber != 0) {
            if (ArabicNumber >= 100) {
                ArabicNumber = ArabicNumber - 100;
                value = value + Roman[11];
            } else if (ArabicNumber >= 50) {
                ArabicNumber = ArabicNumber - 50;
                value = value + Roman[10];
            } else if (ArabicNumber >= 10) {
                ArabicNumber = ArabicNumber - 10;
                value = value + Roman[9];
            } else if (ArabicNumber >= 5) {
                ArabicNumber = ArabicNumber - 5;
                value = value + Roman[4];
            } else if (ArabicNumber >= 1) {
                ArabicNumber = ArabicNumber - 1;
                value = value + Roman[0];
            }
        }
        String value1 = new String(value.replaceAll("LXXXX", "XC"));
        String value2 = new String(value1.replaceAll("XXXX", "XL"));
        String value3 = new String(value2.replaceAll("VIIII", "IX"));
        String value4 = new String(value3.replaceAll("IIII", "IV"));
        return value4;
    }

    public static Integer RomanToArabic(String RomanNumber) {
        String[] RomanNumberArray = RomanNumber.split("");
        int value = Integer.parseInt(Arabic[Arrays.asList(Roman).indexOf(RomanNumberArray[RomanNumberArray.length - 1])]);
        if (Arrays.asList(Roman).indexOf(RomanNumber) != -1)
            value = Integer.parseInt(Arabic[Arrays.asList(Roman).indexOf(RomanNumber)]);
        else {
            for (int i = RomanNumberArray.length - 2; i >= 0; i--) {
                if (Arrays.asList(Roman).indexOf(RomanNumberArray[i]) >= Arrays.asList(Roman).indexOf(RomanNumberArray[i + 1])) {
                } else {
                    value = value - Integer.parseInt(Arabic[Arrays.asList(Roman).indexOf(RomanNumberArray[i])]);
                }
            }
        }
        return value;
    }
}
