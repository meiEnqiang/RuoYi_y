package com.ruoyi.project.test.student.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author MeiEnQiang
 * @date 2018/10/9/0009
 */
@Entity
@Table(name = "t_student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String account;
    @Column(length = 64)
    private String pwd;
    @Column
    private Date createDate;
    @Column
    private Long teacherId;
    @Column(length = 20)
    private Integer grade;
    public Student() {
        super();
    }
    public Student(Long id,String name,Integer grade){
        super();
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}
