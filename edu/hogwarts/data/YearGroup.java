package edu.hogwarts.data;

import edu.generic.Student;

import java.time.LocalDate;
import java.util.Arrays;

public class YearGroup {

    private int schoolYear;

    private LocalDate beginningOfSchoolYear;

    private Student[] students;

    public YearGroup(){}

    public YearGroup(int schoolYear, LocalDate beginningOfSchoolYear, Student[] students) {
        this.schoolYear = schoolYear;
        this.beginningOfSchoolYear = beginningOfSchoolYear;
        this.students = students;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public LocalDate getBeginningOfSchoolYear() {
        return beginningOfSchoolYear;
    }

    public void setBeginningOfSchoolYear(LocalDate beginningOfSchoolYear) {
        this.beginningOfSchoolYear = beginningOfSchoolYear;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String toString() {
        return "edu.hogwarts.data.YearGroup{" +
                "schoolYear=" + schoolYear +
                ", beginningOfSchoolYear=" + beginningOfSchoolYear +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
