package com.ruoyi.project.module.courseArrangement.service;

import com.google.common.collect.Lists;
import com.ruoyi.common.support.Convert;
import com.ruoyi.entity.CourseArrangement;
import com.ruoyi.entity.CourseArrangementExample;
import com.ruoyi.entity.TeaManager;
import com.ruoyi.entitySuper.CourseArrangementSuper;
import com.ruoyi.project.module.courseArrangement.mapper.CourseArrangementExtendMapper;
import com.ruoyi.project.module.teaManager.service.ITeaManagerService;
import com.ruoyi.project.system.dict.domain.DictData;
import com.ruoyi.project.system.dict.service.IDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 课程安排 服务层实现
 * 
 * @author MeiEQ
 * @date 2018-11-01
 */
@Service
public class CourseArrangementServiceImpl implements ICourseArrangementService 
{
	@Autowired
	private CourseArrangementExtendMapper courseArrangementMapper;
	@Autowired
	private ITeaManagerService teaManagerService;
	@Autowired
	private IDictDataService dictDataService;

	/**
     * 查询课程安排信息
     * 
     * @param courseArrangementId 课程安排ID
     * @return 课程安排信息
     */
    @Override
	public CourseArrangement selectCourseArrangementById(Integer courseArrangementId)
	{
	    return courseArrangementMapper.selectByPrimaryKey(courseArrangementId);
	}
	
	/**
     * 查询课程安排列表
     * 
     * @param courseArrangement 课程安排信息
     * @return 课程安排集合
     */
	@Override
	public List<CourseArrangement> selectCourseArrangementList(CourseArrangement courseArrangement)
	{
	    return courseArrangementMapper.selectCourseArrangementList(courseArrangement);
	}
	
    /**
     * 新增课程安排
     * 
     * @param courseArrangement 课程安排信息
     * @return 结果
     */
	@Override
	public int insertCourseArrangement(CourseArrangement courseArrangement)
	{
	    return courseArrangementMapper.insertSelective(courseArrangement);
	}
	
	/**
     * 修改课程安排
     * 
     * @param courseArrangement 课程安排信息
     * @return 结果
     */
	@Override
	public int updateCourseArrangement(CourseArrangement courseArrangement)
	{
	    return courseArrangementMapper.updateByPrimaryKeySelective(courseArrangement);
	}

	/**
     * 删除课程安排对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCourseArrangementByIds(String ids)
	{
		return courseArrangementMapper.deleteCourseArrangementByIds(Convert.toStrArray(ids));
	}
	/**
	 * 获取所有课程安排的详情
	 * @return List<CourseArrangementSuper>
	 */
	@Override
	public List<CourseArrangementSuper> getCourseArrangementSuperList(){
		List<CourseArrangementSuper> result = Lists.newArrayList();
		List<CourseArrangement> list = selectCourseArrangementList(null);
		if(list.size() > 0){
			for (CourseArrangement courseArrangement : list) {
				CourseArrangementSuper courseArrangementSuper = new CourseArrangementSuper();
				int tmId = courseArrangement.getTeaManmgerId();
				TeaManager teaManager = teaManagerService.selectTeaManagerById(tmId);
				int grade = teaManager.getGradeId();
				DictData gradeData = dictDataService.getDictDataByDictTypeAndDictValue("grade_type",
						grade + "");
				String gradeStr = gradeData.getDictLabel();
				String gradeCss = gradeData.getCssClass();
				int subject = teaManager.getSubjectType();
				DictData subjectData = dictDataService.getDictDataByDictTypeAndDictValue("subject_type",
						subject + "");
				String subjectStr = subjectData.getDictLabel();
				String subjectCss = subjectData.getCssClass();
				String textColor = "#0F0B0C";
				if(courseArrangement.getStatus()){
					subjectCss = "#74551A";
					textColor = "#000000";
				}
				courseArrangementSuper.setStart(courseArrangement.getStartTime());
				courseArrangementSuper.setEnd(courseArrangement.getEndTime());
				courseArrangementSuper.setBackgroundColor(subjectCss);
				courseArrangementSuper.setBorderColor(gradeCss);
				courseArrangementSuper.setCourse(subjectStr);
				courseArrangementSuper.setGrade(gradeStr);
				courseArrangementSuper.setTextColor(textColor);
				courseArrangementSuper.setId(courseArrangement.getCourseArrangementId());
				result.add(courseArrangementSuper);
			}
		}
		return result;
	}
	/**
	 * 修改已完成的课时
	 * @return 修改的条数
	 */
	@Override
	public int updateFishStatus(){
		CourseArrangementExample example = new CourseArrangementExample();
		example.createCriteria().andStatusEqualTo(false).andEndTimeLessThanOrEqualTo(new Date());
		CourseArrangement courseArrangement = new CourseArrangement();
		courseArrangement.setStatus(true);
		return courseArrangementMapper.updateByExampleSelective(courseArrangement,example);
	}
}
