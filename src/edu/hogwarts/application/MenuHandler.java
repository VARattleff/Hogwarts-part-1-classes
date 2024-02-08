package src.edu.hogwarts.application;

import java.util.Scanner;

public class MenuHandler {

    private final Scanner scanner;
    private final UserInterface userInterface;

    public MenuHandler(UserInterface userInterface) {
        this.userInterface = userInterface;
        this.scanner = new Scanner(System.in);
    }

    public void introMenu() {
        System.out.println("""
                Welcome to the administrative system.
                We are pleased to welcome you and look forward to collaborating with you.
                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

                1. Create
                2. View Student or Teachers
                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                """);

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                createMenu();
                break;
            case 2:
                viewMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                introMenu();
                break;
        }
    }

    private void createMenu() {
        System.out.println("""
                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                Choose what you want to create:
                1. Student
                2. Teacher
                3. Back
                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                """);

        int createChoice = scanner.nextInt();
        switch (createChoice) {
            case 1:
                userInterface.createStudent();
                break;
            case 2:
                userInterface.createTeacher();
                break;
            case 3:
                introMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                createMenu();
                break;
        }
    }

    private void viewMenu() {
        System.out.println("""
                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                Choose what you want to view:
                1. View Student
                2. View Teacher
                3. View All
                4. Back
                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
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
            case 4:
                createMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                viewMenu();
                break;
        }
    }
}
