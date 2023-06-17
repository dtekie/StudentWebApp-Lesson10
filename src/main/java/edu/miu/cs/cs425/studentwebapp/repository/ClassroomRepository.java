package edu.miu.cs.cs425.studentwebapp.repository;


import edu.miu.cs.cs425.studentwebapp.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
}
