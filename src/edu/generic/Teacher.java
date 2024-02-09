package src.edu.generic;

import src.edu.hogwarts.data.empType;
import java.time.LocalDate;
public class Teacher extends Person {

    private final empType employment = empType.TEACHER;
    private final LocalDate employmentStart;
    private final LocalDate employmentEnd;

    public Teacher(LocalDate employmentStart, LocalDate employmentEnd, String fullName, LocalDate birthday ){
        super(fullName, birthday);
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }

    public String getEmployment() {
        return employment.toString();
    }

    public LocalDate getEmploymentStart() {
        return employmentStart;
    }

    public LocalDate getEmploymentEnd() {
        return employmentEnd;
    }

    public String toString() {
        return String.format("%s\t%s\t%s\t%s",
                getFullName(),
                getEmployment(),
                getEmploymentStart(),
                getEmploymentEnd());
    }
}
