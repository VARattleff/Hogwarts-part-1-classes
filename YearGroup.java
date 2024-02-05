import java.time.LocalDate;
import java.util.Arrays;

public class YearGroup extends HogwartsStudent{

    private int schoolYear;
    private LocalDate beginningOfSchoolYear;

    private Student[] students;

    public YearGroup(){}
    public YearGroup(House house, boolean prefect, String[] teams, int enrollmentYear, int graduationYear, boolean graduated, String fullName, int schoolYear, LocalDate beginningOfSchoolYear, Student[] students) {
        super(house, prefect, teams, enrollmentYear, graduationYear, graduated, fullName);
        this.schoolYear = schoolYear;
        this.beginningOfSchoolYear = beginningOfSchoolYear;
        this.students = students;
    }

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
        return "YearGroup{" +
                "schoolYear=" + schoolYear +
                ", beginningOfSchoolYear=" + beginningOfSchoolYear +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
