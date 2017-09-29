package cn.kejiang.respository;

import cn.kejiang.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
//通过年龄来查询
    public List<Student> findByStuAge(int age);
}
