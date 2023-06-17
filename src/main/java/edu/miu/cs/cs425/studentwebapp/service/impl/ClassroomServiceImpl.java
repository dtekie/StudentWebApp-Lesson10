package edu.miu.cs.cs425.studentwebapp.service.impl;


import edu.miu.cs.cs425.studentwebapp.model.Classroom;
import edu.miu.cs.cs425.studentwebapp.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentwebapp.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;


    @Override
    public Classroom addNewClassroom(Classroom newClassroom) {
        return classroomRepository.save(newClassroom);
    }
}
