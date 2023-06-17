package edu.miu.cs.cs425.studentwebapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Student Number is required")
    private String studentNumber;
    //    @Column(nullable = false)
    @NotBlank(message = "First Name is required and it should not be empty, null or blank")
    private String firstName;
    private String middleName;
//    @Column(nullable = false)
    @NotBlank(message = "Last Name is required and it should not be empty, null or blank")
    private String lastName;
    private Double cgpa;
    private LocalDate dateOfEnrollment;
    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "transcript_id" , referencedColumnName = "transcriptId")
    @JoinColumn(name = "transcript_id")

    private Transcript transcript;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classroom_id", referencedColumnName = "classroomId")
    private Classroom classroom;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"))
    private List<Course> courses;
}

