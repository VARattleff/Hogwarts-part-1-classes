package src.edu.hogwarts.application;

import src.edu.generic.Person;
import src.edu.hogwarts.controller.StudentController;
import src.edu.hogwarts.controller.TeacherController;

import src.edu.hogwarts.data.HogwartsTeacher;
import src.edu.hogwarts.data.House;
import src.edu.hogwarts.data.HogwartsStudent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import src.edu.hogwarts.data.HouseOrigin;
import java.time.format.DateTimeParseException;

public class UserInterface {

    private final StudentController studentController;
    private final TeacherController teacherController;

    public UserInterface(StudentController studentController, TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    public void createStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter house (GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN): ");
        String houseString = scanner.nextLine().toUpperCase();
        HouseOrigin houseOrigin = HouseOrigin.valueOf(houseString);

        House house ;
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
                System.out.println("Enter Teacher birthdate (yyyy-mm-dd): ");
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter house (GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN): ");
        String houseString = scanner.nextLine().toUpperCase();
        HouseOrigin houseOrigin = HouseOrigin.valueOf(houseString);

        House house ;
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
                createTeacher();
                return;
        }

        System.out.println("Enter if teacher is a head (true/false): ");
        boolean isHead = scanner.nextBoolean();

        System.out.println("Enter start date (yyyy-mm-dd): ");
        LocalDate startDate = LocalDate.parse(scanner.next());

        System.out.println("Enter end date (yyyy-mm-dd): ");
        LocalDate endDate = LocalDate.parse(scanner.next());

        System.out.println("Enter teacher name: ");
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
        HogwartsTeacher teacher = new HogwartsTeacher(house, isHead, startDate, endDate, fullName, birthdate);
        System.out.println("Teacher created: " + teacher);
    }


    public void viewStudent() {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("│ Full Name                      │ Employment │ Enrollment   │ Graduation   │ Graduated │ House     ");
        System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────");
        for (HogwartsStudent student : allStudents) {
            System.out.printf("│ %-30s │ %-10s │ %-12d │ %-12d │ %-9b │ %-9s  \n",
                    student.getFullName(), student.getEmployment(), student.getEnrollmentYear(),
                    student.getGraduationYear(), student.isGraduated(), student.getHouse().getName());
        }
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    public void viewTeacher() {
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();

        System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────── ");
        System.out.println("│ Full Name                      │ Employment │ Employment Start│ Employment End  │ House      │ Head of House ");
        System.out.println("├────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        for (HogwartsTeacher teacher : allTeachers) {
            System.out.printf("│ %-30s │ %-10s │ %-15s │ %-15s │ %-9s │ %-12b \n",
                    teacher.getFullName(), teacher.getEmployment(), teacher.getEmploymentStart(),
                    teacher.getEmploymentEnd(), teacher.getHouse().getName(), teacher.isHeadOfHouse());
        }
        System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    public void viewAll() {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();

        System.out.println("┌───────────────────────────────────────────────────────────────────");
        System.out.println("│ Full Name                      │ Age  │ House     │ Employment ");
        System.out.println("├───────────────────────────────────────────────────────────────────");
        for (HogwartsStudent student : allStudents) {
            System.out.printf("│ %-30s │ %-4d │ %-6s │ %-10s \n",
                    student.getFullName(), student.getAge(), student.getHouse().getName(), student.getEmployment());
        }
        for (HogwartsTeacher teacher : allTeachers) {
            System.out.printf("│ %-30s │ %-4d │ %-6s │ %-10s \n",
                    teacher.getFullName(), teacher.getAge(), teacher.getHouse().getName(), teacher.getEmployment());

        }
        System.out.println("└───────────────────────────────────────────────────────────────────");
    }
}
