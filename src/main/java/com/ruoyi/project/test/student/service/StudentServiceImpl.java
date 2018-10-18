package com.ruoyi.project.test.student.service;

import com.ruoyi.project.system.user.mapper.UserMapper;
import com.ruoyi.project.test.student.domain.Student;
import com.ruoyi.project.test.student.mapper.StudentRepository;
import com.ruoyi.project.test.student.response.GetStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MeiEnQiang
 * @date 2018/10/9/0009
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student save(Student student){
        return studentRepository.save(student);
    }
    @Override
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    @Override
    public Page<Student> findAll(Pageable pageable){
        return studentRepository.findAll(pageable);
    }
    @Override
    public List<Student> findByNameLike(String name){
        return studentRepository.findByNameStartsWith(name);
    }
    @Override
    public Student findByName(String name){
        return studentRepository.findByNameIs(name);
    }
    @Override
    public int updateByName(String setname, String name){
        return studentRepository.modifyByName(setname, name);
    }
    @Override
    public Page<GetStudentResponse> find(Pageable pageable){
        return studentRepository.find(pageable);
    }
}
