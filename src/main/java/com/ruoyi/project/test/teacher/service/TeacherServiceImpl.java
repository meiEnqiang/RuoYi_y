package com.ruoyi.project.test.teacher.service;

import com.ruoyi.project.test.teacher.domain.Teacher;
import com.ruoyi.project.test.teacher.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MeiEnQiang
 * @date 2018/10/10/0010
 */
@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public int save(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

    @Override
    public int delete(Long id) {
        return teacherMapper.delete(id);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.getAll();
    }
}
