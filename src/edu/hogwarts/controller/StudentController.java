package src.edu.hogwarts.controller;

import src.edu.hogwarts.data.HogwartsStudent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class StudentController extends Controller<HogwartsStudent>  {
    private final HashMap<UUID, HogwartsStudent> students = new HashMap<>();

    public StudentController() {
        super();
    }

    public ArrayList<HogwartsStudent> getAll() {
        return new ArrayList<>(this.students.values());
    }

    public void add(HogwartsStudent student) {
        students.put(student.getId(), student);
    }

    public void add(HogwartsStudent[] students) {
        for (var student : students) {
            add(student);
        }
    }
}
