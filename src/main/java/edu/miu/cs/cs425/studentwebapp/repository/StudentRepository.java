package edu.miu.cs.cs425.studentwebapp.repository;

import edu.miu.cs.cs425.studentwebapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByFirstNameContainingOrLastNameContaining(
            String firstName, String lastName);
}
