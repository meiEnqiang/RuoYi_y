package com.ruoyi.project.module.courseArrangement.mapper;

import com.ruoyi.entity.CourseArrangement;
import com.ruoyi.mapper.CourseArrangementMapper;

import java.util.List;

/**
 * 课程安排 数据层
 * 
 * @author MeiEQ
 * @date 2018-11-01
 */
public interface CourseArrangementExtendMapper extends CourseArrangementMapper{

	/**
     * 查询课程安排列表
     * 
     * @param courseArrangement 课程安排信息
     * @return 课程安排集合
     */
	List<CourseArrangement> selectCourseArrangementList(CourseArrangement courseArrangement);

	/**
     * 批量删除课程安排
     * 
     * @param courseArrangementIds 需要删除的数据ID
     * @return 结果
     */
	int deleteCourseArrangementByIds(String[] courseArrangementIds);
	
}