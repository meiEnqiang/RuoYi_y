package com.ruoyi.project.module.courseArrangement.service;

import com.ruoyi.entity.CourseArrangement;
import com.ruoyi.entitySuper.CourseArrangementSuper;

import java.util.List;

/**
 * 课程安排 服务层
 * 
 * @author MeiEQ
 * @date 2018-11-01
 */
public interface ICourseArrangementService 
{
	/**
     * 查询课程安排信息
     * 
     * @param courseArrangementId 课程安排ID
     * @return 课程安排信息
     */
	CourseArrangement selectCourseArrangementById(Integer courseArrangementId);
	
	/**
     * 查询课程安排列表
     * 
     * @param courseArrangement 课程安排信息
     * @return 课程安排集合
     */
	List<CourseArrangement> selectCourseArrangementList(CourseArrangement courseArrangement);
	
	/**
     * 新增课程安排
     * 
     * @param courseArrangement 课程安排信息
     * @return 结果
     */
	int insertCourseArrangement(CourseArrangement courseArrangement);
	
	/**
     * 修改课程安排
     * 
     * @param courseArrangement 课程安排信息
     * @return 结果
     */
	int updateCourseArrangement(CourseArrangement courseArrangement);
		
	/**
     * 删除课程安排信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteCourseArrangementByIds(String ids);

	/**
	 * 获取所有课程安排的详情
	 * @return List<CourseArrangementSuper>
	 */
	List<CourseArrangementSuper> getCourseArrangementSuperList();
	
}
