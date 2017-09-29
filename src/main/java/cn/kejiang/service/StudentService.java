package cn.kejiang.service;

import cn.kejiang.domain.Student;
import cn.kejiang.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
@Transactional
    public void insertTwo() {
        Student studentA = new Student();
        studentA.setStuAge(22);
        studentA.setStuCupSize("B");
        studentRepository.save(studentA);


        Student studentB = new Student();
        studentB.setStuAge(22);
        studentB.setStuCupSize("BBBBB");
        studentRepository.save(studentB);
    }
}
