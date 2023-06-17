package edu.miu.cs.cs425.studentwebapp.service;


import edu.miu.cs.cs425.studentwebapp.model.Course;

import java.util.List;

public interface CourseService {
    Course addNewCourse(Course newCourse);
    List<Course> getAllCourses();
}
