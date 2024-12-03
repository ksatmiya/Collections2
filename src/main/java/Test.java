import entity.Person;
import initperson.InitPerson;
import writer.PersonWriter;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        testGetPerson();

    }

    private static void testGetPerson() {
        List<Person> people = InitPerson.getListPerson();

        for (Person person : people) {
            System.out.println(person);
        }
    }

    private static void testWriter() {
        List<Person> people = InitPerson.getListPerson();
        String filePath = "src/main/resources/people_output.txt";

        PersonWriter.writeToFile(people, filePath);
    }
}
