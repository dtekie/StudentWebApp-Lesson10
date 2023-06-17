package edu.miu.cs.cs425.studentwebapp.repository;


import edu.miu.cs.cs425.studentwebapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
