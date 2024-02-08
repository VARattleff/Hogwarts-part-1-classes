// UserInterface.java
package src.edu.hogwarts.application;

import src.edu.generic.Person;
import src.edu.hogwarts.controller.StudentController;
import src.edu.hogwarts.controller.TeacherController;

import src.edu.hogwarts.data.House;
import src.edu.hogwarts.data.HogwartsStudent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import src.edu.hogwarts.data.HouseOrigin;
import java.time.format.DateTimeParseException;

public class UserInterface {

    private StudentController studentController;
    private TeacherController teacherController;
    private Scanner scanner;

    public UserInterface(StudentController studentController, TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
        this.scanner = new Scanner(System.in);
    }

    public void createStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter house (GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN): ");
        String houseString = scanner.nextLine().toUpperCase();
        HouseOrigin houseOrigin = HouseOrigin.valueOf(houseString);

        if (houseOrigin == null) {
            System.out.println("Invalid house. Please choose again.");
            createStudent();
            return;
        }

        House house = null;
        switch (houseOrigin) {
            case GRYFFINDOR:
                house = House.getGryffindor();
                break;
            case HUFFLEPUFF:
                house = House.getHufflepuff();
                break;
            case RAVENCLAW:
                house = House.getRavenclaw();
                break;
            case SLYTHERIN:
                house = House.getSlytherin();
                break;
            default:
                System.out.println("Invalid house. Please choose again.");
                createStudent();
                return;
        }

        System.out.println("Enter if student is a prefect (true/false): ");
        boolean isPrefect = scanner.nextBoolean();

        System.out.println("Enter sports (comma-separated): ");
        String[] sports = scanner.next().split(",");

        System.out.println("Enter start year: ");
        int startYear = scanner.nextInt();

        System.out.println("Enter end year: ");
        int endYear = scanner.nextInt();

        System.out.println("Enter if student is pure-blood (true/false): ");
        boolean isPureBlood = scanner.nextBoolean();

        System.out.println("Enter student name: ");
        String fullName = scanner.next();
        Person person = new Person();
        person.setFullName(fullName);

        LocalDate birthdate = null;
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.println("Enter student birthdate (yyyy-mm-dd): ");
                birthdate = LocalDate.parse(scanner.next());
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
            }
        }

        HogwartsStudent student = new HogwartsStudent(house, isPrefect, sports, startYear, endYear, isPureBlood, fullName, birthdate);
        System.out.println("Student created: " + student);
    }



    public void createTeacher() {
        // Implementer logik for oprettelse af en lærer
        System.out.println("Creating a teacher...");
    }

    public void viewStudent() {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        for (HogwartsStudent student : allStudents) {
            System.out.println(student);
        }
    }



    public void viewTeacher() {
        // Implementer logik for visning af en lærer
        System.out.println("Viewing teachers...");
    }

    public void viewAll() {
        // Implementer logik for visning af alle studerende og lærere
        System.out.println("Viewing all...");
    }
}
