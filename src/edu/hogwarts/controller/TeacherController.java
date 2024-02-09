package src.edu.hogwarts.controller;

import src.edu.hogwarts.data.HogwartsTeacher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class TeacherController extends Controller<HogwartsTeacher> {
    private final HashMap<UUID, HogwartsTeacher> teachers = new HashMap<>();

    public TeacherController() {
        super();
    }

    public ArrayList<HogwartsTeacher> getAll() {
        return new ArrayList<>(this.teachers.values());
    }

    public void add(HogwartsTeacher teacher) {
        teachers.put(teacher.getId(), teacher);
    }

    public void add(HogwartsTeacher[] teachers) {
        for (var teacher : teachers) {
            add(teacher);
        }
    }
}
