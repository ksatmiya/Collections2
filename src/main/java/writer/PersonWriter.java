package writer;

import entity.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PersonWriter {

    /**
     * Сохраняет список людей в txt файл
     * @param people список Person
     * @param filePath путь к файлу
     */
    public static void writeToFile(List<Person> people, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Person person : people) {
                writer.write(String.valueOf(person));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
