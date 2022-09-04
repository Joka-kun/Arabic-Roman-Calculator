package Calculate;

class ArabicAndRomanException extends Exception {
    public ArabicAndRomanException() {
        super("Ошибка! Одновременно используются разные системы счисления!");
    }
}

class NegativeRomanNumberException extends Exception {
    public NegativeRomanNumberException() {
        super("Ошибка! В римской системе счисления нет нуля и отрицательных чисел!");
    }
}

class NoArabicOrRoman1Exception extends Exception {
    public NoArabicOrRoman1Exception() {
        super("Ошибка! Первое число не относится к арабской и римской системам счисления, либо не соблюдает интервал от 1 до 10!");
    }
}

class NoArabicOrRoman2Exception extends Exception {
    public NoArabicOrRoman2Exception() {
        super("Ошибка! Второе число не относится к арабской и римской системам счисления, либо не соблюдает интервал от 1 до 10!");
    }
}

class NoArabicOrRomanBothException extends Exception {
    public NoArabicOrRomanBothException() {
        super("Ошибка! Оба числа не относятся к арабской и римской системам счисления, либо не соблюдают интервал от 1 до 10!");
    }
}

class OperationsException extends Exception {
    public OperationsException() {
        super("Ошибка! Операция не соответствует (+, -, /, *)!");
    }
}

class IndexException extends Exception {
    public IndexException() {
        super("Ошибка! Не соблюден формат ввода: Число1 пробел Операция пробел Число2!");
    }
}
