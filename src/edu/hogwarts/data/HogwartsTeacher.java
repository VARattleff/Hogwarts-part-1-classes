package src.edu.hogwarts.data;

import src.edu.generic.Teacher;
import java.time.LocalDate;

public class HogwartsTeacher extends Teacher implements HogwartsPerson {

    private final House house;
    private final boolean headOfHouse;

    public HogwartsTeacher(House house, boolean headOfHouse, LocalDate employmentStart, LocalDate employmentEnd, String fullName, LocalDate birthDate) {
        super(employmentStart, employmentEnd, fullName, birthDate);
        this.house = house;
        this.headOfHouse = headOfHouse;
    }

    @Override
    public String getEmployment() {
        return "TEACHER";
    }

    @Override
    public House getHouse() {
        return house;
    }

    public boolean isHeadOfHouse() {
        return headOfHouse;
    }

    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s",
                getFullName(),
                getEmployment(),
                getEmploymentStart(),
                getEmploymentEnd(),
                getHouse().getName(),
                isHeadOfHouse());
    }
}
