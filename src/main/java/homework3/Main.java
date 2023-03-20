package homework3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;




public class Main {
    public static void main(String[] args) {
        //deleteEvenElementsFromArray();
        //MaxAndMinAverageFinding();
        integersRemovingFromArrayList();

    }

    //1. Пусть дан произвольный список целых чисел, удалить из него четные числа
    // (в языке уже есть что-то готовое для этого)
    private static void deleteEvenElementsFromArray() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int num = in.nextInt();
        Random rand = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            int value = rand.nextInt(1, 100);
            arrayList.add(value);
        }
        System.out.println(arrayList);
        int i = 0;
        while (i < arrayList.size()) {
            if (arrayList.get(i) % 2 == 0) {
                arrayList.remove(i);
            } else {
                i++;
            }
        }
        System.out.println(arrayList);
    }


//2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.

    private static void MaxAndMinAverageFinding() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int num = in.nextInt();
        Random rand = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            int value = rand.nextInt(1, 100);
            arrayList.add(value);
        }
        System.out.println(arrayList);
        int max = Collections.max(arrayList);
        int min = Collections.min(arrayList);
        double sum = 0;
        for (int nums : arrayList) {
            sum += nums;
        }
        double average = sum / arrayList.size();
        System.out.println("Максимальное значение:" + max);
        System.out.println("Минимальное значение:" + min);
        System.out.println("Среднее арифметическое:" + average);
    }
    //3. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа.
// Пройти по списку, найти и удалить целые числа.

    private static void integersRemovingFromArrayList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1.2");
        arrayList.add("9");
        arrayList.add("100");
        arrayList.add("LaLaLand");
        arrayList.add("100");
        arrayList.add("100");
        arrayList.add("LaLaLand");
        arrayList.add("LaLaLand");
        arrayList.add("-6");
        arrayList.add("-6");
        System.out.println(arrayList);
        for (int i = ( arrayList.size() - 1); i > -1 ; i--) {
            try{
                Integer.parseInt(arrayList.get(i));
                arrayList.remove(i);
            }catch (Exception e){
                //
            }
        }
        System.out.println(arrayList);


    }

}









