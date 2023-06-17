package edu.miu.cs.cs425.studentwebapp.service.impl;


import edu.miu.cs.cs425.studentwebapp.model.Course;
import edu.miu.cs.cs425.studentwebapp.repository.CourseRepository;
import edu.miu.cs.cs425.studentwebapp.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    @Override
    public Course addNewCourse(Course newCourse) {
        return courseRepository.save(newCourse);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
