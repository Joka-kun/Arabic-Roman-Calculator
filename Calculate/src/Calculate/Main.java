package Calculate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static Calculate.Operations.Division;
import static Calculate.Operations.Minus;
import static Calculate.Operations.Multiply;
import static Calculate.Operations.Plus;

public class Main {

    public static void main(String[] args) throws IOException, NoArabicOrRoman2Exception, NoArabicOrRomanBothException, ArabicAndRomanException, NoArabicOrRoman1Exception, OperationsException, IndexException, NegativeRomanNumberException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Арабско-римский калькулятор");
        System.out.println("Соблюдайте формат ввода: Число1 пробел Операция пробел Число2");
        System.out.println("Числа должны быть одной системы счисления, принимаются числа только от 1 до 10");
        System.out.println("Допустимые операции (+, -, /, *)");
        String input = reader.readLine();
        System.out.println(calc(input));
    }

    public static String[] Roman = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "L", "C"};
    public static String[] RomanInput = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public static String[] Arabic = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "50", "100"};
    public static String[] ArabicInput = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private static String output;

    public static String calc(String input) throws NoArabicOrRoman1Exception, NoArabicOrRomanBothException, NoArabicOrRoman2Exception, ArabicAndRomanException, OperationsException, IndexException, NegativeRomanNumberException {
        String[] arrayString = input.split(" ");
        if (arrayString.length != 3)
            throw new IndexException();//не тот формат
        if (
                Arrays.asList(RomanInput).indexOf(arrayString[0]) == -1 &&
                Arrays.asList(ArabicInput).indexOf(arrayString[0]) == -1 &&
                Arrays.asList(RomanInput).indexOf(arrayString[2]) == -1 &&
                Arrays.asList(ArabicInput).indexOf(arrayString[2]) == -1)
            throw new NoArabicOrRomanBothException();//оба не относятся к системам
        else if (
                Arrays.asList(RomanInput).indexOf(arrayString[0]) == -1 &&
                Arrays.asList(ArabicInput).indexOf(arrayString[0]) == -1)
            throw new NoArabicOrRoman1Exception();//первое не относится
        else if (
                Arrays.asList(RomanInput).indexOf(arrayString[2]) == -1 &&
                Arrays.asList(ArabicInput).indexOf(arrayString[2]) == -1)
            throw new NoArabicOrRoman2Exception();//второе не относится
        else if (
                 Arrays.asList(RomanInput).indexOf(arrayString[0]) != -1 &&
                 Arrays.asList(ArabicInput).indexOf(arrayString[0]) == -1 &&
                 Arrays.asList(RomanInput).indexOf(arrayString[2]) == -1 &&
                 Arrays.asList(ArabicInput).indexOf(arrayString[2]) != -1 ||
                 Arrays.asList(RomanInput).indexOf(arrayString[0]) == -1 &&
                 Arrays.asList(ArabicInput).indexOf(arrayString[0]) != -1 &&
                 Arrays.asList(RomanInput).indexOf(arrayString[2]) != -1 &&
                 Arrays.asList(ArabicInput).indexOf(arrayString[2]) == -1)
            throw new ArabicAndRomanException();//не совпадают системы

        if (
                (Arrays.asList(RomanInput).indexOf(arrayString[0]) != -1 && Arrays.asList(RomanInput).indexOf(arrayString[2]) != -1) ||
                (Arrays.asList(ArabicInput).indexOf(arrayString[0]) != -1 && Arrays.asList(ArabicInput).indexOf(arrayString[2]) != -1)) {
            if (arrayString[1].equals("+")) output = Plus(arrayString[0], arrayString[2]);
            else if (arrayString[1].equals("-")) output = Minus(arrayString[0], arrayString[2]);
            else if (arrayString[1].equals("*")) output = Multiply(arrayString[0], arrayString[2]);
            else if (arrayString[1].equals("/")) output = Division(arrayString[0], arrayString[2]);
            else throw new OperationsException();//не совпадают операции
        }
        return output;
    }
}