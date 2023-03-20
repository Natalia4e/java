package classwork3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
    public static void main(String[] args) {
        randNumbers();
    }

    // Заполнить список названиями планет солнечной системы в произвольном порядке с повторениями
    // Вывести названия каждой планеты и кол-во его повторений в списке
    // Пройти по списку и удалить повторения
    private static void randNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            int n = (int) ((Math.random() * (60 - 0)) + 0);
            numbers.add(n);
        }
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}


