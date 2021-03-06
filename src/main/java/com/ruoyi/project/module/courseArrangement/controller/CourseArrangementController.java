package com.ruoyi.project.module.courseArrangement.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.entity.CourseArrangement;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.module.courseArrangement.service.ICourseArrangementService;
import com.ruoyi.project.module.teaManager.service.ITeaManagerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 课程安排 信息操作处理
 * 
 * @author MeiEQ
 * @date 2018-11-01
 */
@Controller
@RequestMapping("/module/courseArrangement")
public class CourseArrangementController extends BaseController
{
    private String prefix = "module/courseArrangement";
	
	@Autowired
	private ICourseArrangementService courseArrangementService;
	@Autowired
	private ITeaManagerService teaManagerService;

	@RequiresPermissions("module:courseArrangement:view")
	@GetMapping()
	public String courseArrangement(ModelMap mMap, HttpSession session)
	{
	    mMap.addAttribute("list",courseArrangementService.getCourseArrangementSuperList());
		Object timeStr = session.getAttribute("timeStr");
		if(timeStr == null){
			timeStr = DateUtils.parseDateToStr("yyyy-MM-dd",new Date());
		}else {
			session.removeAttribute("timeStr");
		}
		mMap.addAttribute("timeStr", timeStr);
		return prefix + "/fullcalendar";
	}
	
	/**
	 * 查询课程安排列表
	 */
	@RequiresPermissions("module:courseArrangement:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CourseArrangement courseArrangement)
	{
		startPage();
        List<CourseArrangement> list = courseArrangementService.selectCourseArrangementList(courseArrangement);
		return getDataTable(list);
	}
	
	/**
	 * 新增课程安排
	 */
	@GetMapping("/add")
	public String add(String time, ModelMap modelMap, HttpSession session)
	{
		modelMap.addAttribute("teaMangeMap",teaManagerService.getAllMap());
		modelMap.addAttribute("timeStr", time + " 00:00:00");
		session.setAttribute("timeStr", time);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存课程安排
	 */
	@RequiresPermissions("module:courseArrangement:add")
	@Log(title = "课程安排", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CourseArrangement courseArrangement)
	{		
		return toAjax(courseArrangementService.insertCourseArrangement(courseArrangement));
	}

	/**
	 * 修改课程安排
	 */
	@GetMapping("/edit/{courseArrangementId}")
	public String edit(@PathVariable("courseArrangementId") Integer courseArrangementId, ModelMap mmap)
	{
		CourseArrangement courseArrangement = courseArrangementService.selectCourseArrangementById(courseArrangementId);
		mmap.put("courseArrangement", courseArrangement);
		mmap.addAttribute("teaMangeMap",teaManagerService.getAllMap());
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存课程安排
	 */
	@RequiresPermissions("module:courseArrangement:edit")
	@Log(title = "课程安排", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CourseArrangement courseArrangement)
	{		
		return toAjax(courseArrangementService.updateCourseArrangement(courseArrangement));
	}
	
	/**
	 * 删除课程安排
	 */
	@RequiresPermissions("module:courseArrangement:remove")
	@Log(title = "课程安排", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(courseArrangementService.deleteCourseArrangementByIds(ids));
	}
	
}
