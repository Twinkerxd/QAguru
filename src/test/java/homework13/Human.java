package homework13;

import java.util.HashMap;
import java.util.Map;

public class Human {

    private Map<Integer, String> students = new HashMap<>();

    void printStudentById(Integer id) {
        System.out.println("Student with id: " + id + " is " + students.get(id));
    }

    void addStudent(Integer id, String name) {
        System.out.println("Student " + name + " with id: " + id + " has been added");
        students.put(id, name);
    }

    void removeStudentById(Integer id) {
        System.out.println("Student with id: " + id + " has been removed");
        students.remove(id);
    }

    void printAllOfStudents() {
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("--------");
            System.out.println(entry);
        }
    }
}
