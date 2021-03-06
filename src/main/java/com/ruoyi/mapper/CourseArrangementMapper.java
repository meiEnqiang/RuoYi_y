package com.ruoyi.mapper;

import com.ruoyi.entity.CourseArrangement;
import com.ruoyi.entity.CourseArrangementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseArrangementMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_arrangement
     *
     * @mbggenerated
     */
    int countByExample(CourseArrangementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_arrangement
     *
     * @mbggenerated
     */
    int deleteByExample(CourseArrangementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_arrangement
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer courseArrangementId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_arrangement
     *
     * @mbggenerated
     */
    int insert(CourseArrangement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_arrangement
     *
     * @mbggenerated
     */
    int insertSelective(CourseArrangement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_arrangement
     *
     * @mbggenerated
     */
    List<CourseArrangement> selectByExample(CourseArrangementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_arrangement
     *
     * @mbggenerated
     */
    CourseArrangement selectByPrimaryKey(Integer courseArrangementId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_arrangement
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CourseArrangement record, @Param("example") CourseArrangementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_arrangement
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CourseArrangement record, @Param("example") CourseArrangementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_arrangement
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CourseArrangement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_arrangement
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CourseArrangement record);
}