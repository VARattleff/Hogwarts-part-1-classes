package src.edu.hogwarts.application;

import src.edu.hogwarts.controller.StudentController;
import src.edu.hogwarts.controller.TeacherController;

import java.util.Scanner;

public class MenuHandler {

    private Scanner scanner;
    private UserInterface userInterface;

    public MenuHandler(UserInterface userInterface) {
        this.userInterface = userInterface;
        this.scanner = new Scanner(System.in);
    }

    public void introMenu() {
        System.out.println("""
                Welcome to the administrative system.
                We are pleased to welcome you and look forward to collaborating with you.
                ______________________________________________________
                
                1. Create
                2. View Student or Teachers
                3. View All
                """);

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                createMenu();
                break;
            case 2:
                viewMenu();
                break;
            case 3:
                viewAll();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                introMenu();
                break;
        }
    }

    private void createMenu() {
        System.out.println("""
                ______________________________________________________
                Choose what you want to create:
                1. Student
                2. Teacher
                """);

        int createChoice = scanner.nextInt();
        switch (createChoice) {
            case 1:
                userInterface.createStudent();
                break;
            case 2:
                userInterface.createTeacher();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                createMenu();
                break;
        }
    }

    private void viewMenu() {
        System.out.println("""
                ______________________________________________________
                Choose what you want to view:
                1. View Student
                2. View Teacher
                3. View All
                """);

        int viewChoice = scanner.nextInt();
        switch (viewChoice) {
            case 1:
                userInterface.viewStudent();
                break;
            case 2:
                userInterface.viewTeacher();
                break;
            case 3:
                userInterface.viewAll();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                viewMenu();
                break;
        }
    }

    private void viewAll() {
        System.out.println("Viewing all...");
        userInterface.viewAll();
    }
}
