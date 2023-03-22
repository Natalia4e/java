package homework4;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        //homeworkTaskOne();
        homeworkTaskTwo();

    }

    // 1. Реализовать консольное приложение, которое: Принимает от пользователя и “запоминает” строки.
// Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
// Если введено revert, удаляет предыдущую введенную строку из памяти.
    private static void homeworkTaskOne() {
        LinkedList<String> ourLinkedList = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите строку: ");
            String inputString = in.nextLine();
            if (inputString.isBlank()) {
                System.out.println("Вы ничего не ввели. Введите строку");
                continue;
            }
            if (inputString.equalsIgnoreCase("stop")) {
                break;
            }
            if (inputString.equalsIgnoreCase("print")) {
                if (ourLinkedList.size() == 0) {
                    System.out.println("Ничего не введено. Нечего печатать");
                } else {
                    printWorldList(ourLinkedList);
                }
            }
            if (inputString.equalsIgnoreCase("revert")) {
                if (ourLinkedList.size() == 0 || ourLinkedList.size() == 1) {
                    System.out.println("Удалять пока нечего");
                } else {
                    String removeWord = ourLinkedList.remove(1);
                    System.out.printf("Удалена строка - %s\n", removeWord);
                }
            }
            ourLinkedList.addFirst(inputString);

        }
    }

    private static void printWorldList(LinkedList<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, wordList.get(i));
        }
    }


//2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

    private static void homeworkTaskTwo() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Hello");
        linkedList.add("Hi");
        linkedList.add("Privet");
        linkedList.add("Hola");
        linkedList.add("Bonjur");
        System.out.println(linkedList);
        ListIterator<String> listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}

