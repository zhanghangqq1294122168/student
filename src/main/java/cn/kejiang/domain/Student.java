package cn.kejiang.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int stuId;
    //设置默认值一下的禁止添加
    @Min(value = 18,message = "未成年少女禁止入内")
    private int stuAge;
    private String stuCupSize;

    public Student() {
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuCupSize() {
        return stuCupSize;
    }

    public void setStuCupSize(String stuCupSize) {
        this.stuCupSize = stuCupSize;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuAge=" + stuAge +
                ", stuCupSize='" + stuCupSize + '\'' +
                '}';
    }
}
