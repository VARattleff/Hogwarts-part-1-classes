package src.edu.generic;

import src.edu.hogwarts.data.empType;

import java.time.LocalDate;

public class Teacher extends Person {

    private empType employment = empType.TEACHER;
    private LocalDate employmentStart;
    private LocalDate employmentEnd;

    public Teacher(){
        super();
    }
    public Teacher(LocalDate employmentStart, LocalDate employmentEnd, String fullName, LocalDate birthday ){
        super(fullName, birthday);
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;

    }
    public empType getEmployment() {
        return employment;
    }

    public void setEmployment(empType employment) {
        this.employment = employment;
    }

    public LocalDate getEmploymentStart() {
        return employmentStart;
    }

    public void setEmploymentStart(LocalDate employmentStart) {
        this.employmentStart = employmentStart;
    }

    public LocalDate getEmploymentEnd() {
        return employmentEnd;
    }

    public void setEmploymentEnd(LocalDate employmentEnd) {
        this.employmentEnd = employmentEnd;
    }

    public String toString() {
        return "src.edu.generic.Teacher{\n" +
                "fullName: " + getFullName() + "\n" +
                "employment: " + employment + "\n" +
                "employmentStart: " + employmentStart + "\n" +
                "employmentEnd: " + employmentEnd + "\n" +
                "}";
    }
}
