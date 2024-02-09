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

    public void searchOrFilterStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        
        Choose what you want to filter or sort on:
        1. Filter by house
        2. Filter by graduated
        3. Sort by Full Name
        4. Sort by Enrollment
        5. Sort by Graduation
        6. Sort by Graduated
        7. Sort by House
        8. Back
        
        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        """);

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("""
                        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                        
                        Enter the house you want to filter by (GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN):
                        
                        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                        """);
                String houseFilter = scanner.next();
                userInterface.filterStudentsByHouse(houseFilter);
                break;
            case 2:
                System.out.println("""
                        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                        
                        Enter 'true' for graduated or 'false' for not graduated
                        
                        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                        """);
                boolean graduatedFilter = scanner.nextBoolean();
                userInterface.filterStudentsByGraduation(graduatedFilter);
                break;
            case 3:
                System.out.println("Sort in ascending order? (true/false): ");
                boolean ascending = scanner.nextBoolean();
                userInterface.sortStudentsByFullName(ascending);
                break;
            case 4:
                System.out.println("Sort in ascending order? (true/false): ");
                boolean enrollmentAscending = scanner.nextBoolean();
                userInterface.sortStudentsByEnrollment(enrollmentAscending);
                break;
            case 5:
                System.out.println("Sort in ascending order? (true/false): ");
                boolean graduationAscending = scanner.nextBoolean();
                userInterface.sortStudentsByGraduation(graduationAscending);
                break;
            case 6:
                System.out.println("Sort in ascending order? (true/false): ");
                boolean graduatedAscending = scanner.nextBoolean();
                userInterface.sortStudentsByGraduated(graduatedAscending);
                break;
            case 7:
                System.out.println("Sort in ascending order? (true/false): ");
                boolean houseAscending = scanner.nextBoolean();
                userInterface.sortStudentsByHouse(houseAscending);
                break;

            case 8:
                viewMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                searchOrFilterStudent();
                break;
        }
    }

    public void searchOrFilterTeacher() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    Choose what you want to filter or sort on:
    1. Filter by house
    2. Filter by Head of House
    3. Sort by Full Name
    4. Sort by Employment
    5. Sort by Employment Start
    6. Sort by Employment End
    7. Sort by House
    8. Head of House
    9. Back
    
    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    """);

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("""
                    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                    
                    Enter the house you want to filter by (GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN):
                    
                    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                    """);
                String houseFilter = scanner.next();
                userInterface.filterTeacherByHouse(houseFilter);
                break;
            case 2:
                System.out.println("""
                    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                    
                    Enter 'true' for Head of House or 'false' for not Head of House
                    
                    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                    """);
                boolean headOfHouseFilter = scanner.nextBoolean();
                userInterface.filterTeachersByHeadOfHouse(headOfHouseFilter);
                break;
            case 3:
                System.out.println("Sort in ascending order? (true/false): ");
                boolean ascendingFullName = scanner.nextBoolean();
                userInterface.sortTeachersByFullName(ascendingFullName);
                break;
            case 4:
                System.out.println("Sort by Employment:");
                System.out.println("1. Sort in ascending order");
                System.out.println("2. Sort in descending order");
                int employmentChoice = scanner.nextInt();
                boolean ascendingEmployment = (employmentChoice == 1);
                userInterface.sortTeachersByEmployment(ascendingEmployment);
                break;
            case 5:
                System.out.println("Sort by Employment Start:");
                System.out.println("1. Sort in ascending order");
                System.out.println("2. Sort in descending order");
                int employmentStartChoice = scanner.nextInt();
                boolean ascendingEmploymentStart = (employmentStartChoice == 1);
                userInterface.sortTeachersByEmploymentStart(ascendingEmploymentStart);
                break;
            case 6:
                System.out.println("Sort by Employment End:");
                System.out.println("1. Sort in ascending order");
                System.out.println("2. Sort in descending order");
                int employmentEndChoice = scanner.nextInt();
                boolean ascendingEmploymentEnd = (employmentEndChoice == 1);
                userInterface.sortTeachersByEmploymentEnd(ascendingEmploymentEnd);
                break;
            case 7:
                System.out.println("Sort by House:");
                System.out.println("1. Sort in ascending order");
                System.out.println("2. Sort in descending order");
                int houseChoice = scanner.nextInt();
                boolean ascendingHouse = (houseChoice == 1);
                userInterface.sortTeachersByHouse(ascendingHouse);
                break;
            case 8:
                System.out.println("Head of House Sort in ascending order? (true/false)");
                boolean ascending = scanner.nextBoolean();
                userInterface.sortTeachersByHouse(ascending);
                break;
            case 9:
                viewMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                searchOrFilterTeacher();
                break;
        }
    }

    public void searchOrFilterAll() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    Choose what you want to filter or sort on:
    1. Filter by house
    2. Sort by Full Name
    3. Sort by Age
    4. Sort by House
    5. Sort by Employment
    6. Back
    
    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    """);

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("""
                    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                    
                    Enter the house you want to filter by (GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN):
                    
                    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                    """);
                String houseFilter = scanner.next();
                userInterface.filterAllByHouse(houseFilter);
                break;
            case 2:
                System.out.println("Sort fullName in ascending order? (true/false): ");
                boolean ascendingFullName = scanner.nextBoolean();
                userInterface.sortAllByFullName(ascendingFullName);
                break;
            case 3:
                System.out.println("Sort in ascending order? (true/false): ");
                boolean ascendingAge = scanner.nextBoolean();
                userInterface.sortAllByAge(ascendingAge);
                break;
            case 4:
                System.out.println("Sort by House:");
                System.out.println("1. Sort in ascending order");
                System.out.println("2. Sort in descending order");
                int houseChoice = scanner.nextInt();
                boolean ascendingHouse = (houseChoice == 1);
                userInterface.sortAllByHouse(ascendingHouse);
                break;
            case 5:
                System.out.println("Sort by Employment ascending order? (true/false): ");
                boolean Employment = scanner.nextBoolean();
                userInterface.sortAllByEmployment(Employment);
                break;
            case 6:
                viewMenu();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                searchOrFilterAll();
                break;
        }
    }
}