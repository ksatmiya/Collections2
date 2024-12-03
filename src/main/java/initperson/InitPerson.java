package initperson;

import entity.Division;
import entity.Person;
import reader.CsvReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InitPerson {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     * Метод инициализицирует и заносит в список людей, читай csv файл
     * @return список людей
     */
    public static List<Person> getListPerson() {

        List<Person> people = new ArrayList<>();

        List<String[]> date = CsvReader.readCsvFile("src/main/resources/foreign_names.csv");

        for (String[] row : date) {
            people.add(
                    new Person(
                            Integer.parseInt(row[0]),
                            row[1],
                            row[2],
                            LocalDate.parse(row[3], FORMATTER),
                            new Division(
                                    row[4]
                            ),
                            Double.parseDouble(row[5])
                    )
            );
        }

        return people;
    }
}
