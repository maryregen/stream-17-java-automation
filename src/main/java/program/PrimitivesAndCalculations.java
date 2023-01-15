package program;

public class PrimitivesAndCalculations {
    public static void main (String[] args) {
        byte varByte = 126; // диапазон -127 ... 128, default = 0
        short varShort = 32767; //диапазон  -32768 ...  32767 default = 0
        int varInt = 2147483647; // диапазон -2147483648 ... 2147483647 default = 0
        long varLong = 9223372036854775807L;//  диапазон -9223372036854775808 ... 9223372036854775807 default = 0L
        float varFloat = 36.6f; // -3.4E+38 ... 3.4E+38  default = 0.0f
        double varDouble = 36.6; // -1.7E+308...1.7E+308  default =0.0d
        boolean varBoolean = true; // true or false. default = false
        boolean varBoolean1 = false;
        char varChar = '\u0006'; // 16-разрядные символы Unicode

        // Математические операторы
        System.out.println("Результат сложения " + (varByte + 1));
        System.out.println("Результат вычитания " + (varByte - 1));
        System.out.println("Результат деления " + (varFloat / 3));
        System.out.println("Результат умножения " + (varFloat * 3));

        //Логические операторы
        System.out.println("Результат логического НЕ "+ (!varBoolean == false));
        System.out.println("Результат логического И " + (varBoolean && varBoolean1 == false));
        System.out.println("Результат логического ИЛИ " + (varBoolean || varBoolean1 == true));
        System.out.println("Результат логического исключающего ИЛИ "+ (varBoolean ^ varBoolean1 == true));

        //Добиться переполнения
        System.out.println(varByte + varInt);
        System.out.println(varShort + varInt);
        System.out.println(varInt + varLong);
        System.out.println(varLong + varLong);

        //Комбинации типов данных (int и double)
        System.out.println("Комбинации int и double " + (varInt + varDouble));
        System.out.println("Комбинации char и double " + (varChar + varDouble));

    }
}
