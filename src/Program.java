import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        // working with array sort
        int[] myArray = {3, 124, 46, 2135, 57, 197, 46, 0, 0, -63, 69};
        int[] sortedArray = selectionSort(myArray);

        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }

        System.out.println("__________________________");
        int indx = binarySearch(sortedArray, 46);
        int[] resultIndices = getAllIndices(sortedArray, indx);

        for (int i = 0; i < resultIndices.length; i++) {
            if(resultIndices[i] != -1) {
                System.out.println(resultIndices[i]);
            }
        }

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

        //threeDigitNumberRevert();


        /**
         * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
         * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
         * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
         */

        //difficultPercent();


    }

    public static int[] getAllIndices(int[] array, int position) {
        int[] res = new int[array.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        int cn = 0;

        for (int i = position; i < array.length; i++) {
            if (array[position] == array[i]) {
                res[cn] = i;
                cn++;
            } else {
                break;
            }
        }

        if(position != 0) {
            for (int i = position-1; i >= 0; i--) {
                if (array[position] == array[i]) {
                    res[cn] = i;
                    cn++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static int[] bubbleSort(int[] sortArr) {
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < sortArr.length - 1; i++) {
                if (sortArr[i] > sortArr[i + 1]) {
                    temp = sortArr[i];
                    sortArr[i] = sortArr[i + 1];
                    sortArr[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        return sortArr;
    }

    public static int[] bubbleSort2(int[] sortArr) {
        for (int i = 0; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - i - 1; j++) {
                if (sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
        return sortArr;
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }

        return arr;
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            // замена
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
        return array;
    }

    public static int binarySearch(int arr[], int elementToSearch) {

        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        // условие прекращения (элемент не представлен)
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            }

            // если средний элемент меньше
            // направляем наш индекс в middle+1, убирая первую часть из рассмотрения
            else if (arr[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;

                // если средний элемент больше
                // направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
            else if (arr[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;

        }
        return -1;
    }


    private static void difficultPercent() {
        System.out.print("\nTask 3\nInput sum of money : ");
        Scanner in = new Scanner(System.in);

        System.out.println("enter basic vklad");
        int money = in.nextInt();
        System.out.println("enter stavka");
        double stavka = in.nextDouble();
        System.out.println("enter years");
        int years = in.nextInt();

        System.out.println(money * Math.pow((1 + stavka), years));
    }


    private static void threeDigitNumberRevert() {
        int num = 1234567, reversed = 0;

        while (num != 0) {

            int digit = num % 10;
            reversed = reversed * 10 + digit;

            num /= 10;
            num = num / 10;
        }

        System.out.println("Reversed Number: " + reversed);

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
