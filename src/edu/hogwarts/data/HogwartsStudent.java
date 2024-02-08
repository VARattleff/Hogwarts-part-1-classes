package src.edu.hogwarts.data;

import src.edu.generic.Student;

import java.time.LocalDate;

public class HogwartsStudent extends Student implements HogwartsPerson  {

    private House house;
    private boolean prefect;
    private String[] teams;

    public HogwartsStudent(House house, boolean prefect, String[] teams, int enrollmentYear, int graduationYear, boolean graduated, String fullName, LocalDate birthday){
        super(enrollmentYear, graduationYear, graduated, fullName, birthday);
        this.house = house;
        this.prefect = prefect;
        this.teams = teams;
    }

    public HogwartsStudent(){
        super();
        this.teams = new String[0];
        this.house = new House();
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public boolean isPrefect() {
        return prefect;
    }

    public void setPrefect(boolean prefect) {
        this.prefect = prefect;
    }

    public String[] getTeams() {
        return teams;
    }

    public void setTeams(String[] teams) {
        this.teams = teams;
    }

    public String toString() {
        StringBuilder teamString = new StringBuilder();
        if (teams.length > 0) {
            for (String team : teams) {
                teamString.append(team).append(", ");
            }
            teamString.replace(teamString.lastIndexOf(", "), teamString.length() - 1, ".");
        }
        return "src.edu.hogwarts.data.HogwartsStudent{\n" +
                " fullName: " + getFullName() + "\n" +
                " employment: " + getEmployment() + "\n" +
                " enrollmentYear: " + getEnrollmentYear() + "\n" +
                " graduationYear: " + getGraduationYear() + "\n" +
                " graduated: " + isGraduated() + "\n" +
                " house: " + house.toString() + "\n" +
                " prefect: " + prefect + "\n" +
                " teams: " + teamString + "\n" +
                "}";
    }

}
