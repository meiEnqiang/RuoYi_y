package com.ruoyi.project.test.student.mapper;

import com.ruoyi.project.test.student.domain.Student;
import com.ruoyi.project.test.student.response.GetStudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MeiEnQiang
 * @date 2018/10/9/0009
 */
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByNameStartsWith(String name);
    Student findByNameIs(String name);
    @Transactional(timeout = 10)
    @Modifying
    @Query("update Student s set s.name = ?1 where s.name = ?2")
    int modifyByName(String setname,String name);
    @Query("select s as student,t.name as teacherName from Student s left join Teacher t on s.teacherId = t.id")
    Page<GetStudentResponse> find(Pageable pageable);
}
