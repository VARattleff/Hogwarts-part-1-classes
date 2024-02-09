package src.edu.hogwarts.data;

import src.edu.generic.Student;
import java.time.LocalDate;

public class HogwartsStudent extends Student implements HogwartsPerson {

    private final House house;
    private final boolean prefect;
    private final String[] teams;

    public HogwartsStudent(House house, boolean prefect, String[] teams, int enrollmentYear, int graduationYear, boolean graduated, String fullName, LocalDate birthday){
        super(enrollmentYear, graduationYear, graduated, fullName, birthday, house);
        this.house = house;
        this.prefect = prefect;
        this.teams = teams;
    }

    public House getHouse() {
        return house;
    }

    public boolean isPrefect() {
        return prefect;
    }

    public String toString() {
        StringBuilder teamString = new StringBuilder();
        if (teams.length > 0) {
            for (String team : teams) {
                teamString.append(team).append(", ");
            }
            teamString.replace(teamString.lastIndexOf(", "), teamString.length(), ".");
        }
        return String.format("%s\tStudent\t-\t-\t%s\t%s\t%s",
                getFullName(),
                getHouse(),
                isPrefect(),
                teamString);
    }
}
