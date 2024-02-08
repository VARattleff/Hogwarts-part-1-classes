package edu.hogwarts.application;

import edu.generic.empType;
import edu.hogwarts.data.*;

import java.time.LocalDate;

public class Application {
    House[] houses;
    HogwartsStudent[] students;
    HogwartsTeacher[] teachers;
    Subject[] subjects;
    Course[] courses;
    TeachingMaterial[] materials;

    public static void main(String[] args) {
        Application app = new Application();
        app.pageLoad();
    }

    public void pageLoad() {
        pageLoadHouses();
        pageLoadStudents();
        pageLoadTeachers();
        pageLoadSubject();
        pageLoadCourses();
        pageLoadTeachingMaterials();
    }

    public void pageLoadHouses(){
        var gryffindor = new House();
        var hufflepuff = new House();
        var ravenclaw = new House();
        var slytherin = new House();

        gryffindor.setName("Gryffindor");
        gryffindor.setFounder("Godric Gryffindor");
        gryffindor.setColors(new String[]{"scarlet", "gold"});

        hufflepuff.setName("Hufflepuff");
        hufflepuff.setFounder("Helga Hufflepuff");
        hufflepuff.setColors(new String[]{"yellow", "black"});

        ravenclaw.setName("Ravenclaw");
        ravenclaw.setFounder("Rowena Ravenclaw");
        ravenclaw.setColors(new String[]{"blue", "silver"});

        slytherin.setName("Slytherin");
        slytherin.setFounder("Salazar Slytherin");
        slytherin.setColors(new String[]{"green", "silver"});

        houses = new House[]{gryffindor, hufflepuff, ravenclaw, slytherin};
    }

    public void pageLoadStudents(){
        var harry = new HogwartsStudent();
        var cedric = new HogwartsStudent();
        var luna = new HogwartsStudent();
        var draco = new HogwartsStudent();

        harry.setFullName("Harry James Potter");
        harry.setEnrollmentYear(1991);
        harry.setGraduationYear(1998);
        harry.setGraduated(true);
        harry.setHouse(houses[0]);

        cedric.setFullName("Cedric Diggory");
        cedric.setEnrollmentYear(1990);
        cedric.setGraduationYear(1997);
        cedric.setGraduated(true);
        cedric.setHouse(houses[1]);

        luna.setFullName("Luna Lovegood");
        luna.setEnrollmentYear(1992);
        luna.setGraduationYear(1999);
        luna.setGraduated(true);
        luna.setHouse(houses[2]);

        draco.setFullName("Draco Malfoy");
        draco.setEnrollmentYear(1991);
        draco.setGraduationYear(1998);
        draco.setGraduated(true);
        draco.setHouse(houses[3]);

        students = new HogwartsStudent[]{harry, cedric, luna, draco};
    }


    public void pageLoadTeachers(){
        var snape = new HogwartsTeacher();
        var slughorn = new HogwartsTeacher();

        snape.setFullName("Severus Snape");
        snape.setHouse(houses[3]);
        snape.setHeadOfHouse(true);
        snape.setEmployment(empType.TEACHER);
        snape.setEmploymentStart(LocalDate.of(1981, 9, 1));
        snape.setEmploymentEnd(LocalDate.of(1998, 6, 30));

        slughorn.setFullName("Horace Slughorn");
        slughorn.setHouse(houses[3]);
        slughorn.setHeadOfHouse(false);
        slughorn.setEmployment(empType.TEACHER);
        slughorn.setEmploymentStart(LocalDate.of(1931, 9, 1));
        slughorn.setEmploymentEnd(LocalDate.of(1981, 6, 30));

        teachers = new HogwartsTeacher[]{snape, slughorn};
   }

    protected void pageLoadSubject(){
        var potions = new Subject();

        potions.setName("Potions");
        potions.setSchoolYear(1);
        potions.setElective(false);

        subjects = new Subject[]{potions};
    }

    protected void  pageLoadCourses(){
        var potions = new Course();
        potions.setSubject(subjects[0]);
        potions.setTeacher(teachers[1]);
        potions.setStudents(students);
        potions.setMaterials(materials);

        courses = new Course[]{potions};
    }

    protected void  pageLoadTeachingMaterials() {
        var textBook = new TextBook();
        var wand = new Wand();
        var tool = new Tool();
        var ingredient = new Ingredient();

        textBook.setName("Advanced Potion Making");
        textBook.setAuthor("Libatius Borage");
        textBook.setPublisher("Horace Slughorn");
        textBook.setTitle("Advanced Potion Making");
        textBook.setPublishedYear(1946);
        textBook.setOnShoppingList(true);
        textBook.setNotes("This book is the property of the Half-Blood Prince.");
        textBook.setProvided(true);
        textBook.setRequired(true);

        wand.setName("edu.hogwarts.data.Wand");
        wand.setCore("Phoenix feather");
        wand.setWood("Holly");
        wand.setNotes("The wand chooses the wizard.");
        wand.setProvided(false);
        wand.setRequired(true);
        wand.setOnShoppingList(true);
        wand.setLengthInInches(11);

        tool.setName("Cauldron");
        tool.setDescription("Pewter, standard size 2");
        tool.setNotes("Pewter cauldrons are standard size 2.");
        tool.setProvided(false);
        tool.setRequired(true);
        tool.setOnShoppingList(true);

        ingredient.setName("Bubotuber pus");
        ingredient.setAmount(2);
        ingredient.setUnit("ounces");
        ingredient.setNotes("Bubotuber pus is a magical substance.");
        ingredient.setProvided(false);
        ingredient.setRequired(true);
        ingredient.setOnShoppingList(true);

        materials = new TeachingMaterial[]{textBook, wand, tool, ingredient};
    }
}
