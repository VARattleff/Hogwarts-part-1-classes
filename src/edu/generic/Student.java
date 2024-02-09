package src.edu.generic;

import src.edu.hogwarts.data.HogwartsPerson;
import src.edu.hogwarts.data.House;
import src.edu.hogwarts.data.empType;

import java.time.LocalDate;

public class Student extends Person implements HogwartsPerson {

    private final empType employment = empType.STUDENT;
    private final int enrollmentYear;
    private final int graduationYear;
    private final boolean graduated;
    private final House house;

    public String getEmployment() {
        return employment.toString();
    }

    public Student(int enrollmentYear, int graduationYear, boolean graduated, String fullName, LocalDate birthday, House house) {
        super(fullName, birthday);
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
        this.graduated = graduated;
        this.house = house;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public House getHouse() {
        return house;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s",
                getFullName(),
                getEmployment(),
                getEnrollmentYear(),
                getGraduationYear(),
                isGraduated(),
                getHouse().getName());
    }
}
