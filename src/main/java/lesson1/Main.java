package lesson1;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Arrays;
import java.time.LocalTime;


public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello, world!");
//        arrMax();
//        maxAndMin();
//        moveElementToEnd();
        inputNameAndPrintHi();



    }

    //1. Задать одномерный массив и найти в нем минимальный и максимальный элементы
    private static void maxAndMin() {
        int[] arr = {8, 9, -5, 4, 7, 9};
        int min = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }

        }
        System.out.println(max);
        System.out.println(min);


    }

    // 2. Дан массив nums = [3,2,2,3] и число val = 3.
// Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
// Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
    private static void moveElementToEnd() {
        int[] array = {3, 2, 2, 3};
        int val = 3;
        int i = 0;
        int j = array.length -1;
        while (i < j){
            while (i < j && array[j] == val){
                j--;
            }
            if (array[i] == val){
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
            i++;
        }
        System.out.println(Arrays.toString(array));
    }

    //3. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
//"Доброе утро, <Имя>!", если время от 05:00 до 11:59
// "Добрый день, <Имя>!", если время от 12:00 до 17:59;
// "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
// "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
    private static void inputNameAndPrintHi() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя пользователя: ");
        String name = in.nextLine();
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        if (hour == 23 ^ hour < 5) {
            System.out.printf("Доброй ночи, %s!", name);
        } else if (hour >= 18) {
            System.out.printf("Добрый вечер, %s!", name);
        } else if (hour < 12) {
            System.out.printf("Доброе утро, %s!", name);
        } else {
            PrintStream printf = System.out.printf("Добрый день, %s!", name);
        }
    }

    private static void arrMax() {
        int[] arr = {1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1};
        int count = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                temp++;
            }
            if (arr[i] == 0 && count < temp) {
                count = temp;
                temp = 0;
            }
            if (count > temp && arr[i] == 0) temp = 0;
        }
        System.out.println(count);
    }
}











