package writer;

import entity.Division;
import entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class PersonWriterTest {

    @Test
    @DisplayName("Test successful writing to file")
    public void testWriteToFile_Success() throws IOException {
        String filePath = "src/test/resources/output.txt";

        List<Person> people = List.of(
                new Person(1, "John", "Male", LocalDate.of(1985, 1, 1), new Division(1, "Engineering"), 5000.0),
                new Person(2, "Jane", "Female", LocalDate.of(1990, 5, 15), new Division(2, "Marketing"), 4500.0)
        );

        PersonWriter.writeToFile(people, filePath);

        List<String> lines = Files.readAllLines(Path.of(filePath));
        Assertions.assertEquals(2, lines.size());
        Assertions.assertEquals("Person{id=1, name='John', gender='Male', date=1985-01-01, division=Division{id=1, nameDivision='Engineering'}, salary=5000.0}",
                lines.get(0));
        Assertions.assertEquals("Person{id=2, name='Jane', gender='Female', date=1990-05-15, division=Division{id=2, nameDivision='Marketing'}, salary=4500.0}",
                lines.get(1));
    }

    @Test
    @DisplayName("Test writing empty list to file")
    public void testWriteToFile_EmptyList() throws IOException {
        String filePath = "src/test/resources/empty_output.txt";

        List<Person> people = Collections.emptyList();

        PersonWriter.writeToFile(people, filePath);

        List<String> lines = Files.readAllLines(Path.of(filePath));
        Assertions.assertTrue(lines.isEmpty());
    }

    @Test
    @DisplayName("Test writing to inaccessible file")
    public void testWriteToFile_InaccessibleFile() {
        String filePath = "/invalid_path/output.txt";

        List<Person> people = List.of(
                new Person(1, "John", "Male", LocalDate.of(1985, 1, 1), new Division(1, "Engineering"), 5000.0)
        );

        assertThrows(RuntimeException.class, () -> PersonWriter.writeToFile(people, filePath));
    }


}
