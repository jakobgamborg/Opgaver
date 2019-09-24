package simplethreelayer.simplethreelayer.interfaces;

import simplethreelayer.domain.Student;

import java.util.List;

public interface IStudentIndex {

    public void addStudent(String name, int age);

    public List<Student> getStudents();
}
