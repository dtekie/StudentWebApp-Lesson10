package edu.miu.cs.cs425.studentwebapp.service;



import edu.miu.cs.cs425.studentwebapp.model.Student;

import java.util.List;

public interface StudentService {
    Student addNewStudent(Student student);
    List<Student> getALlStudents();
    Student editStudent(Long studentId, Student editedStudent);
    Student getStudentById(Long studentId);
    Student updateStudent(Student student);
    void deleteStudent(Long studentId);
    List<Student> findStudentByName(String searchString);

}
