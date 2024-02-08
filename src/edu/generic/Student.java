package src.edu.generic;

import java.time.LocalDate;

public class Student extends Person {
    private int enrollmentYear;
    private int graduationYear;
    private  boolean graduated;

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

    public String toString() {
        return "src.edu.generic.Student{\n" +
                "fullName" + getFullName() + "\n" +
                "enrollmentYear: " + enrollmentYear + "\n" +
                "graduationYear: " + graduationYear + "\n" +
                "graduated: " + graduated + "\n" +
                "}";
    }
}
