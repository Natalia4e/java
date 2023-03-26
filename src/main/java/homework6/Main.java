package homework6;

import java.util.*;

//1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
// Реализовать в java.
//Создать множество ноутбуков (ArrayList).
//Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
// Например, спросить у пользователя минимальный размер оперативной памяти или конкретный цвет.
// Выводить только те ноутбуки, что соответствуют условию
public class Main {
    public static void main(String[] args) {

        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Apple MacBook Pro M2", 8,
                "MacOS", "серебристый"));
        laptops.add(new Laptop("Dell XPS 13", 8,
                "Windows", "черный"));
        laptops.add(new Laptop("Yoga 7i (14 Intel)", 16,
                "Windows", "серый"));
        laptops.add(new Laptop("HP Pavilion Aero", 16,
                "Windows", "белый"));
        laptops.add(new Laptop("Microsoft Surface Pro 8 i7", 32,
                "Windows", "платиновый"));
        // showAll(laptops);
        Laptop needLaptop = requestLaptop();
        System.out.println("========= Необходимый ноутбук ==========\n" + needLaptop);
        Set<Laptop> filteredLaptops = filteredLaptops(laptops, needLaptop);
        showAll(filteredLaptops);


    }

    static void showAll(Set<Laptop> laptops) {
        System.out.println("Все модели");
        for (Laptop elem : laptops) {
            System.out.println(elem);
        }
    }

    static Integer getIntegerValue(String offer, Scanner input) {
        while (true) {
            System.out.print(offer);
            String inputString = input.nextLine();
            if (inputString.equals("")) {
                return null;
            }
            int value = Integer.parseInt(inputString);
            if (value > 0) {
                return value;
            } else {
                System.out.println("Введите положительное число!");
            }
        }
    }

    static Laptop requestLaptop() {
        Scanner input = new Scanner(System.in);
        System.out.println("Давайте подберем Вам ноутбук.");
        System.out.print("Введите название модели или нажмите ввод: ");
        String name = input.nextLine();
        System.out.print("Введите желаемый цвет или нажмите ввод: ");
        String color = input.nextLine();
        System.out.print("Введите операционную систему или нажмите ввод: ");
        String operatingSystem = input.nextLine();
        Integer ram = getIntegerValue("Введите размер оперативной памяти RAM или нажмите ввод: ", input);
        input.close();
        return new Laptop(name, ram, operatingSystem, color);
    }

    static Set<Laptop> filteredLaptops(Set<Laptop> laptops, Laptop needLaptop) {
        Set<Laptop> filteredLaptops = new HashSet<>();
        for (Laptop elem: laptops ) {
            if (elem.compareTo(needLaptop)){
                filteredLaptops.add(elem);
            }
        }
        return filteredLaptops;
    }
}