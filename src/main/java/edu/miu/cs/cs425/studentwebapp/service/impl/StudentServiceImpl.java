package edu.miu.cs.cs425.studentwebapp.service.impl;



import edu.miu.cs.cs425.studentwebapp.model.Student;
import edu.miu.cs.cs425.studentwebapp.repository.StudentRepository;
import edu.miu.cs.cs425.studentwebapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getALlStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student editStudent(Long studentId, Student editedStudent) {
        var existingStudent = studentRepository.findById(studentId).orElse(null);
        if (existingStudent == null) {
            throw new IllegalArgumentException("student with id " + studentId + " does not exist");
        }

        existingStudent.setStudentNumber(editedStudent.getStudentNumber());
        existingStudent.setFirstName(editedStudent.getFirstName());
        existingStudent.setMiddleName(editedStudent.getMiddleName());
        existingStudent.setLastName(editedStudent.getLastName());
        existingStudent.setCgpa(editedStudent.getCgpa());
        existingStudent.setDateOfEnrollment(editedStudent.getDateOfEnrollment());
            return studentRepository.save(existingStudent);
    }


    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student updateStudent(Student publisher) {
        return studentRepository.save(publisher);
    }


    public Student updatePublisher(Student student) {
        return studentRepository.save(student);
    }


    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> findStudentByName(String searchString) {
        return studentRepository.findAllByFirstNameContainingOrLastNameContaining(searchString,searchString);
    }


}
