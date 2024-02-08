package src.edu.hogwarts.application;

import java.util.Scanner;

public class MenuHandler {

    private final Scanner scanner;
    private final UserInterface userInterface;

    public MenuHandler(UserInterface userInterface) {
        this.userInterface = userInterface;
        this.scanner = new Scanner(System.in);
        userInterface.setMenuHandler(this);
    }

    public void introMenu() {
        System.out.println("""
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

    public void searchOrFilter() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
            >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            
            Choose what you want to search or filter on:
            1. Search by name
            2. Search by House
            3. Filter by house ascending
            4. Filter by house descending
            5. Filter by age ascending
            6. Filter by age descending
            7. Back
            
            >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            """);

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the name you want to search for: ");
                String name = scanner.next();
                // mangler logik
                break;
            case 2:
                System.out.println("Enter the house you want to search for: ");
                String house = scanner.next();
                // mangler logik
                break;
            case 3:
                // mangler logik
                break;
            case 4:
                // mangler logik
                break;
            case 5:
                // mangler logik
                break;
            case 6:
                // mangler logik
                break;
            case 7:
                viewMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                searchOrFilter();
                break;
        }
    }
}
