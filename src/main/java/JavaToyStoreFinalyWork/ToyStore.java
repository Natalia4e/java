package JavaToyStoreFinalyWork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import static JavaToyStoreFinalyWork.ForID.createId;

public class ToyStore {
    public static void main(String[] args) {
        menuToyStore();
    }
    public static void menuToyStore() {
        Scanner in = new Scanner(System.in);
        List<Toy> toyList = new ArrayList<>();
        Boolean flag = true;
        while (flag) {
            System.out.println("""
                    Выберите действие:
                    1 - Добавить игрушку в базу
                    2 - Показать все игрушки
                    3 - Изменить вес игрушки для розыгрыша
                    4 - Розыгрыш игрушки
                    0 - Выход""");
            String choice = in.nextLine();
            switch (choice) {
                case "1" -> {
                    UUID id = createId();
                    System.out.println("Введите название игрушки: ");
                    Scanner sc = new Scanner(System.in);
                    String nameToy = sc.nextLine().toUpperCase();
                    System.out.println("Введите вес игрушки для розыгрыша: ");
                    int weightToy = sc.nextInt();
                    Toy newToy = new Toy(id, nameToy, weightToy);
                    toyList.add(newToy);
                }
                case "2" -> {
                    for (Toy toy : toyList) {
                        toy.printInfo();

                    }
                }
                case "3" -> {
                    System.out.println("Введите id игрушки у которой надо изменить вес:");
                    Scanner sc = new Scanner(System.in);
                    String inputId = sc.nextLine().toUpperCase();
                    for (Toy toy: toyList) {
                        String strId = toy.getId().toString();
                        if (strId.equalsIgnoreCase(inputId)){
                            System.out.println("Введите новый вес: ");
                            int newWeight = sc.nextInt();
                            toy.setWeightToy(newWeight);
                        }
                    }
                }
                case "4" -> {
                    makeLottery(toyList);
                    // This should never happen, but just in case
                }
                case "0" -> {
                    flag = false;
                    System.out.println("Работа завершена");
                }
                default -> System.out.println("Неверный выбор!! Повторите выбор!!");
            }
        }
    }

    public static void writeToFile(List<Toy> toyList){
        String fileName = "toys.txt";
        String content = "";
        for (Toy toy : toyList) {
            content = content.concat(toy.name + "\n")  ;
        }

        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
            System.out.println("File saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file: " + e.getMessage());
        }

    }

    public static void  makeLottery(List<Toy> toyList){
        List<Toy> prizeToys = new ArrayList<>();
        double totalWeight = 0;
        for (Toy toy : toyList) {
            totalWeight += toy.weight;
        }

        for (Integer i = 0;i < 10;i++){
            double randomNumber = Math.random() * totalWeight;

            double weightSoFar = 0;
            for (Toy toy : toyList) {
                weightSoFar += toy.weight;
                if (randomNumber < weightSoFar) {
                    prizeToys.add(toy);
                    System.out.println("Chosen prize toy: " + toy.name);
                    break;
                }
            }
        }

        writeToFile(prizeToys);
    }
}

