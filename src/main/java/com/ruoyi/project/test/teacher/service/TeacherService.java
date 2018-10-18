package com.ruoyi.project.test.teacher.service;

import com.ruoyi.project.test.teacher.domain.Teacher;

import java.util.List;

/**
 * @author MeiEnQiang
 * @date 2018/10/10/0010
 */
public interface TeacherService {
    int save(Teacher teacher);
    int update(Teacher teacher);
    int delete(Long id);
    List<Teacher> findAll();
}
