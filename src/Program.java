import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        /**
         * Простая (2 балла)
         *
         * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
         * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
         * Определите время поезда в пути в минутах (в данном случае 216).
         */

        //trainTask();

        /**
         * Простая (2 балла)
         *
         * Пользователь задает целое трехзначное число (например, 478).
         * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
         */

        threeDigitNumberRevert();

    }

    private static void threeDigitNumberRevert() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите трехзначначное число");
        int n = in.nextInt();

        int first = n % 10;
        int second = (n / 10) % 10;
        int third = (n / 100) % 10;

        System.out.println(first + "" + second + "" + third);

    }

    private static void trainTask() {
        int h1;
        int m1;
        int h2;
        int m2;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите час отправления");
        h1 = in.nextInt();
        System.out.println("Введите минуты отправления");
        m1 = in.nextInt();
        System.out.println("Введите час прибытия");
        h2 = in.nextInt();
        System.out.println("Введите минуты прибытия");
        m2 = in.nextInt();
        double result;
        double result1;
        result = ((h2 * 60 + m2) - (h1 * 60 + m1));
        result1 = (((h2 + 24) * 60 + m2) - (h1 * 60 + m1));
        if (h2 > h1) {
            System.out.println("Время в пути составит = " + result);
        } else {
            System.out.println("Время в пути со сменой даты составит = " + result1);
        }
    }
}
