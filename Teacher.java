import java.time.LocalDate;

public class Teacher extends Person {

    private empType employment;
    private LocalDate employmentStart;
    private LocalDate employmentEnd;

    public Teacher(){}
    public Teacher(empType employment, LocalDate employmentStart, LocalDate employmentEnd, String fullName ){
        super(fullName);
        this.employment = employment;
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
        return "Teacher{\n" +
                "fullName: " + getFullName() + "\n" +
                "employment: " + employment + "\n" +
                "employmentStart: " + employmentStart + "\n" +
                "employmentEnd: " + employmentEnd + "\n" +
                "}";
    }
}
