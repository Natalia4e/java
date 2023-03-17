package homework2;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
     hundredRepeatTestInTextFile();
//        first();

    }


//2. Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
// который запишет эту строку в простой текстовый файл, обработайте исключения.


    private static void hundredRepeatTestInTextFile() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("test");
        }
        System.out.println(sb);
        File f1 = new File("file.txt");
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("filename.txt"), StandardCharsets.UTF_8))) {
            writer.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 1. Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом
// (возвращает boolean значение).

    public static void first(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String word = in.nextLine();

        if(isPalindromeOrNot(word)){
            System.out.print("слово полиндром ");
        }else{
            System.out.print("слово не полиндром ");
        }
    }

    private static boolean  isPalindromeOrNot(String word) {
        System.out.println(word);
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        System.out.println(sb);
        int i = 0;
        int length = sb.length();
        while (i < (length - i)) {
            char first = sb.charAt(i);
            char last = sb.charAt(length - i - 1);
            i++;
            if ( first != last){
                return false;
            }
        }
        return true;
    }
}











