package src.edu.hogwarts.application;

import src.edu.hogwarts.controller.StudentController;
import src.edu.hogwarts.controller.TeacherController;
import src.edu.hogwarts.data.HogwartsStudent;
import java.time.LocalDate;
import src.edu.hogwarts.data.House;
import src.edu.hogwarts.data.HogwartsTeacher;


public class InitApp {

    private final StudentController studentController = new StudentController();
    private final TeacherController teacherController = new TeacherController();

    public void initApp() {
        pageLoadStudents();
        pageLoadStaff();

        var ui = new UserInterface(studentController, teacherController);
        MenuHandler menuHandler = new MenuHandler(ui);
        menuHandler.introMenu();
    }

    public void pageLoadStudents() {
        // gryffindor
        var harry = new HogwartsStudent(House.getGryffindor(), false, new String[]{"Quidditch"}, 1991, 1998, false, "Harry James Potter", LocalDate.of(1980, 7, 31));
        var ron = new HogwartsStudent(House.getGryffindor(), false, new String[]{"Quidditch", "Wizard Chess"}, 1991, 1998, false, "Ronald Bilius Weasley", LocalDate.of(1980, 3, 1));
        // hufflepuff
        var hannah = new HogwartsStudent(House.getHufflepuff(), false, new String[]{"Herbology"}, 1991, 1998, false, "Hannah Abbott", LocalDate.of(1980, 3, 1));
        var susan = new HogwartsStudent(House.getHufflepuff(), false, new String[]{"Herbology"}, 1991, 1998, false, "Susan Bones", LocalDate.of(1980, 3, 1));
        // ravenclaw
        var amanda = new HogwartsStudent(House.getRavenclaw(), false, new String[]{"Quidditch"}, 1991, 1998, true, "Amanda", LocalDate.of(1980, 3, 1));
        var terry = new HogwartsStudent(House.getRavenclaw(), false, new String[]{"Quidditch"}, 1991, 1998, true, "Terry Boot", LocalDate.of(1980, 3, 1));
        // slytherin
        var draco = new HogwartsStudent(House.getSlytherin(), false, new String[]{"Quidditch", "Wizard Chess", "Duelling Club"}, 1991, 1998, true, "Draco Malfoy", LocalDate.of(1980, 3, 1));
        var vincent = new HogwartsStudent(House.getSlytherin(), false, new String[]{"Quidditch", "Wizard Chess", "Duelling Club"}, 1991, 1998, true, "Vincent Crabbe", LocalDate.of(1980, 3, 1));

        var students = new HogwartsStudent[]{harry, ron, hannah, susan, amanda, terry, draco, vincent};
        studentController.add(students);
    }

    public void pageLoadStaff() {
        var dumbledore = new HogwartsTeacher(House.getGryffindor(), false, LocalDate.of(1910, 1, 1), LocalDate.of(1997, 6, 30), "Albus P. W.B Dumbledore", LocalDate.of(1881, 7, 1));
        var mcGonagall = new HogwartsTeacher(House.getGryffindor(), true, LocalDate.of(1935, 1, 1), LocalDate.now(), "Minerva McGonagall", LocalDate.of(1925, 10, 4));
        var sprout = new HogwartsTeacher(House.getHufflepuff(), true, LocalDate.of(1935, 1, 1), LocalDate.now(), "Pomona Sprout", LocalDate.of(1925, 5, 15));
        var flitwick = new HogwartsTeacher(House.getRavenclaw(), true, LocalDate.of(1935, 1, 1), LocalDate.now(), "Filius Flitwick", LocalDate.of(1925, 10, 17));
        var snape = new HogwartsTeacher(House.getSlytherin(), true, LocalDate.of(1970, 1, 1), LocalDate.of(1998, 5, 2), "Severus Snape", LocalDate.of(1960, 1, 9));

        var staff = new HogwartsTeacher[]{dumbledore, mcGonagall, sprout, flitwick, snape};
        teacherController.add(staff);
    }
}
