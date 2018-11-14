/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplethreelayer.domain;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import simplethreelayer.dataaccess.DataAccess;
import simplethreelayer.simplethreelayer.interfaces.IDataAccess;
import simplethreelayer.simplethreelayer.interfaces.IStudentIndex;

/**
 *
 * @author Anders
 */
public class StudentIndex implements IStudentIndex {

    private ObservableList<Student> students;
    private IDataAccess da;

    public StudentIndex() {
        da = new DataAccess("students.txt");
        loadStudents();
    }

    public void addStudent(String name, int age) {
        Student s = new Student(name, age);
        storeStudent(s);
    }

    private final void loadStudents() {
        students = FXCollections.observableArrayList();
        List<String> studentStrings = da.load();
        for (String studentString : studentStrings) {
            String[] contents = studentString.split(" ");
            String name = contents[0];
            int age = Integer.parseInt(contents[1]);
            Student s = new Student(name, age);
            students.add(s);
        }
    }

    public ObservableList<Student> getStudents() {
        return students;
    }

    private void storeStudent(Student s) {
        students.add(s);
        List<String> studentStrings = new ArrayList<>();
        for (Student student : students) {
            studentStrings.add(student.toString());
        }
        da.save(studentStrings);
    }

}
