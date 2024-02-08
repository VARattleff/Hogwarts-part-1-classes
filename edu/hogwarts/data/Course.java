package edu.hogwarts.data;

import edu.generic.Student;
import edu.generic.Teacher;

import java.util.Arrays;

public class Course {
    private Subject subject;
    private Teacher teacher;
    private Student[] students;
    private TeachingMaterial[] materials;

    public  Course(){}
    public Course(Subject subject, Teacher teacher, Student[] students, TeachingMaterial[] materials) {
        this.subject = subject;
        this.teacher = teacher;
        this.students = students;
        this.materials = materials;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public TeachingMaterial[] getMaterials() {
        return materials;
    }

    public void setMaterials(TeachingMaterial[] materials) {
        this.materials = materials;
    }

    public String toString() {
        return "edu.hogwarts.data.Course{" +
                "subject=" + subject +
                ", teacher=" + teacher +
                ", students=" + Arrays.toString(students) +
                ", materials=" + Arrays.toString(materials) +
                '}';
    }
}
