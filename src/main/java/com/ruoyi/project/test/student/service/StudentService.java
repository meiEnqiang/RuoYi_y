package com.ruoyi.project.test.student.service;

import com.ruoyi.project.test.student.domain.Student;
import com.ruoyi.project.test.student.response.GetStudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MeiEnQiang
 * @date 2018/10/9/0009
 */
public interface StudentService {
    Student save(Student student);
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);
    List<Student> findByNameLike(String name);
    Student findByName(String name);
    int updateByName(String setname,String name);
    Page<GetStudentResponse> find(Pageable pageable);
}
