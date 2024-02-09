package src.edu.generic;

import src.edu.hogwarts.data.HogwartsPerson;
import src.edu.hogwarts.data.House;
import src.edu.hogwarts.data.empType;

import java.time.LocalDate;

public class Student extends Person implements HogwartsPerson {

    private final empType employment = empType.STUDENT;
    private int enrollmentYear;
    private int graduationYear;
    private boolean graduated;
    private House house;

    public Student(int enrollmentYear, int graduationYear, boolean graduated, String fullName, LocalDate birthday) {
    }

    public String getEmployment() {
        return employment.toString();
    }

    public Student() {
        super();
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

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
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
