package com.ruoyi.project.test.teacher.mapper;

import com.ruoyi.project.test.teacher.domain.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author MeiEnQiang
 * @date 2018/10/10/0010
 */
@Mapper
public interface TeacherMapper {
    @Insert("insert into t_teacher(name,create_date) values(#{name},#{createDate})")
    int insert(Teacher teacher);
    @Select("SELECT * FROM t_teacher")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name")
    })
    List<Teacher> getAll();
    @Update("UPDATE t_teacher SET name=#{name} WHERE id =#{id}")
    int update(Teacher teacher);

    @Delete("DELETE FROM t_teacher WHERE id =#{id}")
    int delete(Long id);
}
