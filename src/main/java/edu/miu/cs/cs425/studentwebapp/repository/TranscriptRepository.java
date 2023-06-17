package edu.miu.cs.cs425.studentwebapp.repository;


import edu.miu.cs.cs425.studentwebapp.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
}
