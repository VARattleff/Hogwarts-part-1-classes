package src.edu.generic;

import src.edu.hogwarts.data.empType;
import java.time.LocalDate;
public class Student extends Person {

    private final empType employment = empType.STUDENT;
    private int enrollmentYear;
    private int graduationYear;
    private  boolean graduated;

    public empType getEmployment() {
        return employment;
    }

    public Student(){
        super();
    }
    public Student(int enrollmentYear, int graduationYear, boolean graduated, String fullName, LocalDate birthday) {
        super(fullName, birthday);
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
        this.graduated = graduated;
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

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s",
                getFullName(),
                getEmployment(),
                getEnrollmentYear(),
                getGraduationYear(),
                isGraduated());
    }
}
