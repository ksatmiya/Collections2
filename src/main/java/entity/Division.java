package entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Division {

    private final Integer id;
    private final String nameDivision;

    private static int idCounter = 1;

    public Division(String nameDivision) {
        this.id = idCounter++;
        this.nameDivision = nameDivision;
    }

    public Division(int id, String name) {
        this.id = id;
        this.nameDivision = name;
    }

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", nameDivision='" + nameDivision + '\'' +
                '}';
    }

}
