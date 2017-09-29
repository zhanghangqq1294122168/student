package cn.kejiang.controller;

import cn.kejiang.aspect.HttpAspect;
import cn.kejiang.domain.Student;
import cn.kejiang.respository.StudentRepository;
import cn.kejiang.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    //查询学生列表
    @GetMapping(value = "/student")
    public List<Student> studentList() {
        logger.info("请求到达studentList");
        return studentRepository.findAll();
    }

    //添加一个女生
    @PostMapping(value = "/student/add")
    //获取设置的默认值做出判断
    public Object studentAdd(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("1");
            return bindingResult.getFieldError().getDefaultMessage();
        }
        student.setStuAge(student.getStuAge());
        student.setStuCupSize(student.getStuCupSize());
        return studentRepository.save(student);
    }

    //根据Id查询
    @GetMapping(value = "/student/{stuId}")
    public Student studentGet(@PathVariable("stuId") int id) {
        return studentRepository.findOne(id);
    }

    //根据Id删除
    @DeleteMapping(value = "/student/{stuId}")
    public void studentDelete(@PathVariable("stuId") int id) {
        studentRepository.delete(id);
    }

    //根据Id修改
    @PutMapping(value = "/student/{stuId}")
    public Student studentUpdate(@PathVariable("stuId") int id,
                                 @RequestParam("stuAge") int age,
                                 @RequestParam("stuCupSize") String cupSize) {
        Student student = new Student();
        student.setStuId(id);
        student.setStuAge(age);
        student.setStuCupSize(cupSize);
        return studentRepository.save(student);
    }

    //通过年龄查询
    @GetMapping(value = "student/age/{stuAge}")
    public List<Student> studentListByAge(@PathVariable("stuAge") int age) {
        return studentRepository.findByStuAge(age);
    }

    //事物管理
    @PostMapping(value = "/student/two")
    public void studentAddTwo() {
        studentService.insertTwo();
    }
}
