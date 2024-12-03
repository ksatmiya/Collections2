package entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
@RequiredArgsConstructor
public class Person {

    private final Integer id;
    private final String name;
    private final String gender;
    private final LocalDate date;
    private final Division division;
    private final Double salary;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", date=" + date +
                ", division=" + division +
                ", salary=" + salary +
                '}';
    }

}
