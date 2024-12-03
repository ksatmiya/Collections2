package initperson;

import entity.Division;
import entity.Person;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InitPersonTest {


    //Будем тестировать первочого человека из csv файла
    @Test
    @DisplayName("Test get list Person")
    public void testGetNameListPerson() {

        Division testDivision1 = new Division(1, "I");

        Person testPerson = new Person(
                28281, "Aahan", "Male", LocalDate.of(1970, 5, 15), testDivision1, 4800.0
        );

        List<Person> people = InitPerson.getListPerson();

        assertEquals(testPerson.getId(), people.get(0).getId());
        assertEquals(testPerson.getName(), people.get(0).getName());
        assertEquals(testPerson.getGender(), people.get(0).getGender());
        assertEquals(testPerson.getDate(), people.get(0).getDate());
        assertEquals(testPerson.getDivision().getNameDivision(), people.get(0).getDivision().getNameDivision());
        assertEquals(testPerson.getSalary(), people.get(0).getSalary());

    }

}
