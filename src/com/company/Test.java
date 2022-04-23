package com.company;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        String[] numbers;
        String inputString = sc.nextLine();
        numbers = inputString.split(" ");
        if (numbers.length == 3) {
            if (Character.isDigit(numbers[0].charAt(0)) && Character.isDigit(numbers[2].charAt(0))) {
                int first = Integer.parseInt(numbers[0]);
                int second = Integer.parseInt(numbers[2]);
                if((first > 10 || first < 0)|| (second > 10 || second < 0)){
                    throw new Exception("одно из чисел больше 10 или меньше 0");
                }
                System.out.println(result(numbers[1], first, second));
            } else if (isRoman(numbers)) {
                int result = result(numbers[1], (convertRomanToNum(numbers[0])), convertRomanToNum(numbers[2]));
                if (result <= 0) {
                    throw new Exception("В римской системе нет отрицательных чисел");
                } else {
                    System.out.println(convertNumToRoman(result));
                }
            } else {
                throw new Exception("используются одновременно разные системы счисления");
            }
        } else if (numbers.length > 3 ){
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else  {
            throw new Exception("строка не является математической операцией");
        }

    }

    public static boolean isRoman(String[] numbers) {
        if ((numbers[0].charAt(0) == 'I' || numbers[0].charAt(0) == 'V' || numbers[0].charAt(0) == 'X' || numbers[0].charAt(0) == 'L' || numbers[0].charAt(0) == 'C') &&
                (numbers[2].charAt(0) == 'I' || numbers[2].charAt(0) == 'V' || numbers[2].charAt(0) == 'X' || numbers[2].charAt(0) == 'L' || numbers[2].charAt(0) == 'C')) {
            return true;
        } else {
            return false;
        }
    }

    public static String convertNumToRoman(int num){
        String[] roman = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return roman[num];
    }

    public static int convertRomanToNum(String str) throws Exception {
        String[] roman = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < roman.length; i++) {
            if (roman[i].equals(str)) {
                return i;
            }
        }
        throw new Exception ("одно из чисел больше 10 или меньше 1");
    }

    public static int result(String str, int first, int second) {
        char sign = str.charAt(0);
        switch (sign) {
            case '+': {
                return first + second;
            }
            case '-': {
                return first - second;
            }
            case '*': {
                return first * second;
            }
            case '/': {
                try {
                    return (first / second);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            default:
                System.out.println("4e no 3HaKy?");
        }
        return -1;
    }

}
