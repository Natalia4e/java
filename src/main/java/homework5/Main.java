package homework5;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        //homeworkTaskOne();
        homeworkTaskTwo();

    }

    //1. Реализуйте структуру телефонной книги с помощью HashMap,учитывая, что 1 человек может иметь несколько телефонов.
    private static void homeworkTaskOne() {
        Scanner in = new Scanner(System.in);
        Map<String, ArrayList<String>> phoneBook = new HashMap<>();
        boolean actionInPhoneBook = true;
        while (actionInPhoneBook) {
            System.out.println("""
                    Что вы хотите сделать ?
                    add - Добавить новый контакт
                    print - Показать все контакты
                    end - Выход""");
            String choice = in.nextLine();
            switch (choice) {
                case "add" -> addContactToPhoneBook(phoneBook, in);
                case "print" -> printPhoneBook(phoneBook);
                case "end" -> {
                    actionInPhoneBook = false;
                    System.out.println("Работа завершена!!!!");
                }
                default -> System.out.println("Вы ввели несуществующую команду");
            }
        }
    }

    private static void addContactToPhoneBook(Map<String, ArrayList<String>> pB, Scanner sc) {
        ArrayList<String> phoneNumber = new ArrayList<>();
        System.out.println("Введите имя и фамилию контакта: ");
        String nameContact = sc.nextLine().toUpperCase();
        System.out.println("Введите номер телефона: ");
        String phone = sc.nextLine();
        if (!pB.containsKey(nameContact)) {
            pB.put(nameContact, phoneNumber);
        }
        pB.get(nameContact).add(phone);
    }

    private static void printPhoneBook(Map<String, ArrayList<String>> bookBase) {
        for (String name : bookBase.keySet()) {
            System.out.printf("Имя, фамилия контакта -  %s\n", name);
            ArrayList<String> phones = bookBase.get(name);
            for (String phone : phones) {
                System.out.printf("Номер телефона -  %s\n", phone);
            }
            System.out.println();
        }
    }

    // 2. Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.
    private static void homeworkTaskTwo() {
        Map<String, Integer> employeeName = new HashMap<>();
        String[] employee = {
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        };
        countName(employee, employeeName);
        sortedCountNameEmployee(employeeName);
    }
    private static void countName(String[] employeeList, Map<String, Integer> employeeName) {
        for (String name : employeeList) {
            String nameSplit = name.split(" ")[0];
            if (employeeName.containsKey(nameSplit)) {
                employeeName.put(nameSplit, employeeName.get(nameSplit) + 1);
            } else {
                employeeName.put(nameSplit, 1);
            }
        }
    }

    private static void sortedCountNameEmployee(Map<String, Integer> employeeName) {
        Map<String, Integer> sortedNameToCount = employeeName.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));
        sortedNameToCount.entrySet().forEach(System.out::println);
    }



}















