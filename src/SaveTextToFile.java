import java.io.*;
import java.util.Scanner;

public class SaveTextToFile {

    public static void main(String[] args) {
        // Создание объекта Scanner для считывания ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Запрос на ввод текста
        System.out.println("Введите текст, который вы хотите сохранить (для завершения ввода введите 'exit'):");

        // Открытие потока для записи в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            // Бесконечный цикл для ввода текста
            String line;
            while (true) {
                line = scanner.nextLine(); // Чтение строки текста

                // Проверка, не завершил ли пользователь ввод
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                // Записываем введенную строку в файл
                writer.write(line);
                writer.newLine();  // Переход на новую строку
            }

            System.out.println("Текст успешно сохранён в файл 'output.txt'.");

        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
