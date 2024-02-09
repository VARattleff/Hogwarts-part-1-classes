package src.edu.hogwarts.application;

import src.edu.hogwarts.controller.StudentController;
import src.edu.hogwarts.controller.TeacherController;

import src.edu.hogwarts.data.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.time.format.DateTimeParseException;
import java.util.Comparator;


public class UserInterface {

    private final StudentController studentController;
    private final TeacherController teacherController;
    private MenuHandler menuHandler;

    public UserInterface(StudentController studentController, TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    public void setMenuHandler(MenuHandler menuHandler) {
        this.menuHandler = menuHandler;
    }

    public void createStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter house (GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN): ");
        String houseString = scanner.nextLine().toUpperCase();
        HouseOrigin houseOrigin = HouseOrigin.valueOf(houseString);

        House house;
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
                menuHandler.introMenu();
                return;
        }

        System.out.println("Enter if student is a prefect (true/false): ");
        boolean isPrefect = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Enter sports (comma-separated): ");
        String[] sports = scanner.nextLine().split(",");

        System.out.println("Enter start year: ");
        int startYear = scanner.nextInt();

        System.out.println("Enter end year: ");
        int endYear = scanner.nextInt();

        System.out.println("Enter if student is pure-blood (true/false): ");
        boolean isPureBlood = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Enter student name: ");
        String fullName = scanner.nextLine();

        LocalDate birthdate = null;
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.println("Enter student birthdate (yyyy-mm-dd): ");
                birthdate = LocalDate.parse(scanner.nextLine());
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
            }
        }

        HogwartsStudent student = new HogwartsStudent(house, isPrefect, sports, startYear, endYear, isPureBlood, fullName, birthdate);
        studentController.add(student);

        System.out.println("Student created");
        System.out.println("Press enter to return to the main menu.");
        scanner.nextLine();

        menuHandler.introMenu();
    }

    public void createTeacher() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter house (GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN): ");
        String houseString = scanner.nextLine().toUpperCase();
        HouseOrigin houseOrigin = HouseOrigin.valueOf(houseString);

        House house;
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
                menuHandler.introMenu();
                return;
        }

        System.out.println("Enter if teacher is a head (true/false): ");
        boolean isHead = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Enter start date (yyyy-mm-dd): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter end date (yyyy-mm-dd): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter teacher name: ");
        String fullName = scanner.nextLine();

        LocalDate birthdate = null;
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.println("Enter teacher birthdate (yyyy-mm-dd): ");
                birthdate = LocalDate.parse(scanner.nextLine());
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
            }
        }

        HogwartsTeacher teacher = new HogwartsTeacher(house, isHead, startDate, endDate, fullName, birthdate);
        teacherController.add(teacher);
        System.out.println("Teacher created:");
        System.out.println("Press enter to return to the main menu.");
        scanner.nextLine();

        menuHandler.introMenu();
    }


    public void viewStudent() {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        Collections.sort(allStudents, Comparator.comparing(HogwartsStudent::getFullName));
        printStudentsSorted(allStudents);
    }


    public void viewTeacher() {
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();
        Collections.sort(allTeachers, Comparator.comparing(HogwartsTeacher::getFullName));
        printTeachersSorted(allTeachers);
    }


    public void viewAll() {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();
        ArrayList<HogwartsPerson> allPersons = new ArrayList<>();
        allPersons.addAll(allStudents);
        allPersons.addAll(allTeachers);
        Collections.sort(allPersons, Comparator.comparing(HogwartsPerson::getFullName));
        printAllSorted(allPersons);
        menuHandler.searchOrFilterAll();
    }


    public void filterStudentsByHouse(String houseName) {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        ArrayList<HogwartsStudent> filteredStudents = new ArrayList<>();

        for (HogwartsStudent student : allStudents) {
            if (student.getHouse().getName().toString().equalsIgnoreCase(houseName)) {
                filteredStudents.add(student);
            }
        }

        printStudentsSorted(filteredStudents);
    }

    public void filterStudentsByGraduation(boolean isGraduated) {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        ArrayList<HogwartsStudent> filteredStudents = new ArrayList<>();

        for (HogwartsStudent student : allStudents) {
            if (student.isGraduated() == isGraduated) {
                filteredStudents.add(student);
            }
        }

        printStudentsSorted(filteredStudents);
    }

    public void sortStudentsByFullName(boolean ascending) {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        Comparator<HogwartsStudent> fullNameComparator = Comparator.comparing(HogwartsStudent::getFullName);
        if (!ascending) {
            fullNameComparator = fullNameComparator.reversed();
        }
        Collections.sort(allStudents, fullNameComparator);
        printStudentsSorted(allStudents);
    }

    public void sortStudentsByEnrollment(boolean ascending) {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        Comparator<HogwartsStudent> enrollmentComparator = Comparator.comparingInt(HogwartsStudent::getEnrollmentYear);
        if (!ascending) {
            enrollmentComparator = enrollmentComparator.reversed();
        }
        Collections.sort(allStudents, enrollmentComparator);
        printStudentsSorted(allStudents);
    }

    public void sortStudentsByGraduation(boolean ascending) {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        Comparator<HogwartsStudent> graduationComparator = Comparator.comparingInt(HogwartsStudent::getGraduationYear);
        if (!ascending) {
            graduationComparator = graduationComparator.reversed();
        }
        Collections.sort(allStudents, graduationComparator);
        printStudentsSorted(allStudents);
    }

    public void sortStudentsByGraduated(boolean ascending) {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        Comparator<HogwartsStudent> graduatedComparator = Comparator.comparing(HogwartsStudent::isGraduated);
        if (!ascending) {
            graduatedComparator = graduatedComparator.reversed();
        }
        Collections.sort(allStudents, graduatedComparator);
        printStudentsSorted(allStudents);
    }

    public void sortStudentsByHouse(boolean ascending) {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        Comparator<HogwartsStudent> houseComparator = Comparator.comparing(student -> student.getHouse().getName().toString());
        if (!ascending) {
            houseComparator = houseComparator.reversed();
        }
        Collections.sort(allStudents, houseComparator);
        printStudentsSorted(allStudents);
    }

    private void printStudentsSorted(ArrayList<HogwartsStudent> allStudents) {
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("│ Full Name                      │ Employment │ Enrollment   │ Graduation   │ Graduated │ House     ");
        System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────");
        for (HogwartsStudent student : allStudents) {
            System.out.printf("│ %-30s │ %-10s │ %-12d │ %-12d │ %-9b │ %-9s  \n",
                    student.getFullName(), student.getEmployment(), student.getEnrollmentYear(),
                    student.getGraduationYear(), student.isGraduated(), student.getHouse().getName());
        }
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────");
        menuHandler.searchOrFilterStudent();
    }


    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><

    public void filterTeacherByHouse(String houseName) {
        ArrayList<HogwartsTeacher> filteredTeachers = new ArrayList<>();
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();
        for (HogwartsTeacher teacher : allTeachers) {
            if (teacher.getHouse().getName().toString().equalsIgnoreCase(houseName)) {
                filteredTeachers.add(teacher);
            }
        }
        printTeachersSorted(filteredTeachers);
    }

    public void filterTeachersByHeadOfHouse(boolean isHeadOfHouse) {
        ArrayList<HogwartsTeacher> filteredTeachers = new ArrayList<>();
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();
        for (HogwartsTeacher teacher : allTeachers) {
            if (teacher.isHeadOfHouse() == isHeadOfHouse) {
                filteredTeachers.add(teacher);
            }
        }
        printTeachersSorted(filteredTeachers);
    }

    public void sortTeachersByFullName(boolean ascending) {
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();
        Comparator<HogwartsTeacher> fullNameComparator = Comparator.comparing(HogwartsTeacher::getFullName);
        if (!ascending) {
            fullNameComparator = fullNameComparator.reversed();
        }
        Collections.sort(allTeachers, fullNameComparator);
        printTeachersSorted(allTeachers);
    }

    public void sortTeachersByEmployment(boolean ascending) {
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();
        Comparator<HogwartsTeacher> employmentComparator = Comparator.comparing(HogwartsTeacher::getEmployment);
        if (!ascending) {
            employmentComparator = employmentComparator.reversed();
        }
        Collections.sort(allTeachers, employmentComparator);
        printTeachersSorted(allTeachers);
  }

    public void sortTeachersByEmploymentStart(boolean ascending) {
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();
        Comparator<HogwartsTeacher> employmentStartComparator = Comparator.comparing(HogwartsTeacher::getEmploymentStart);
        if (!ascending) {
            employmentStartComparator = employmentStartComparator.reversed();
        }
        Collections.sort(allTeachers, employmentStartComparator);
        printTeachersSorted(allTeachers);
    }

    public void sortTeachersByEmploymentEnd(boolean ascending) {
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();
        Comparator<HogwartsTeacher> employmentEndComparator = Comparator.comparing(HogwartsTeacher::getEmploymentEnd);
        if (!ascending) {
            employmentEndComparator = employmentEndComparator.reversed();
        }
        Collections.sort(allTeachers, employmentEndComparator);
        printTeachersSorted(allTeachers);
    }

    public void sortTeachersByHouse(boolean ascending) {
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();
        Comparator<HogwartsTeacher> houseComparator = Comparator.comparing(teacher -> teacher.getHouse().getName().toString());
        if (!ascending) {
            houseComparator = houseComparator.reversed();
        }
        Collections.sort(allTeachers, houseComparator);
        printTeachersSorted(allTeachers);
    }

    private void printTeachersSorted(ArrayList<HogwartsTeacher> allTeachers) {
        System.out.println("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("│ Full Name                      │ Employment │ Employment Start│ Employment End  │ House      │ Head of House ");
        System.out.println("├────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        for (HogwartsTeacher teacher : allTeachers) {
            System.out.printf("│ %-30s │ %-10s │ %-15s │ %-15s │ %-9s │ %-12b \n",
                    teacher.getFullName(), teacher.getEmployment(), teacher.getEmploymentStart(),
                    teacher.getEmploymentEnd(), teacher.getHouse().getName(), teacher.isHeadOfHouse());
        }
        System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        menuHandler.searchOrFilterTeacher();
    }

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><

    public void filterAllByHouse(String houseFilter) {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();
        ArrayList<HogwartsPerson> allPersons = new ArrayList<>();
        allPersons.addAll(allStudents);
        allPersons.addAll(allTeachers);
        ArrayList<HogwartsPerson> filteredPersons = new ArrayList<>();

        for (HogwartsPerson person : allPersons) {
            if (person.getHouse().getName().equals(houseFilter)) {
                filteredPersons.add(person);
            }
        }

        printAllSorted(filteredPersons);
        menuHandler.searchOrFilterAll();
    }

    public void sortAllByFullName(boolean ascendingFullName) {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();
        ArrayList<HogwartsPerson> allPersons = new ArrayList<>();
        allPersons.addAll(allStudents);
        allPersons.addAll(allTeachers);

        Comparator<HogwartsPerson> fullNameComparator = Comparator.comparing(HogwartsPerson::getFullName);
        if (!ascendingFullName) {
            fullNameComparator = fullNameComparator.reversed();
        }
        Collections.sort(allPersons, fullNameComparator);
        printAllSorted(allPersons);
        menuHandler.searchOrFilterAll();
    }

    public void sortAllByAge(Boolean ascendingAge) {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();
        ArrayList<HogwartsPerson> allPersons = new ArrayList<>();
        allPersons.addAll(allStudents);
        allPersons.addAll(allTeachers);

        Comparator<HogwartsPerson> ageComparator = Comparator.comparingInt(HogwartsPerson::getAge);
        if (!ascendingAge) {
            ageComparator = ageComparator.reversed();
        }
        Collections.sort(allPersons, ageComparator);
        printAllSorted(allPersons);
        menuHandler.searchOrFilterAll();
    }

    public void sortAllByHouse(boolean ascendingHouse) {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();
        ArrayList<HogwartsPerson> allPersons = new ArrayList<>();
        allPersons.addAll(allStudents);
        allPersons.addAll(allTeachers);

        Comparator<HogwartsPerson> houseComparator = Comparator.comparing(person -> person.getHouse().getName().toString());
        if (!ascendingHouse) {
            houseComparator = houseComparator.reversed();
        }
        Collections.sort(allPersons, houseComparator);
        printAllSorted(allPersons);
        menuHandler.searchOrFilterAll();
    }

    public void sortAllByEmployment(boolean ascendingEmployment) {
        ArrayList<HogwartsStudent> allStudents = studentController.getAll();
        ArrayList<HogwartsTeacher> allTeachers = teacherController.getAll();
        ArrayList<HogwartsPerson> allPersons = new ArrayList<>();
        allPersons.addAll(allStudents);
        allPersons.addAll(allTeachers);

        Comparator<HogwartsPerson> employmentComparator = Comparator.comparing(HogwartsPerson::getEmployment);
        if (!ascendingEmployment) {
            employmentComparator = employmentComparator.reversed();
        }
        Collections.sort(allPersons, employmentComparator);
        printAllSorted(allPersons);
        menuHandler.searchOrFilterAll();
    }


    private void printAllSorted(ArrayList<HogwartsPerson> persons) {
        System.out.println("┌───────────────────────────────────────────────────────────────────");
        System.out.println("│ Full Name                      │ Age  │ House     │ Employment ");
        System.out.println("├───────────────────────────────────────────────────────────────────");

        for (HogwartsPerson person : persons) {
            System.out.printf("│ %-30s │ %-4d │ %-6s │ %-10s \n",
                    person.getFullName(), person.getAge(), person.getHouse().getName(), person.getEmployment());
        }

        System.out.println("└───────────────────────────────────────────────────────────────────");
    }


}





