package com.ruoyi.project.module.teaManager.controller;

import com.ruoyi.entity.TeaManager;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.module.tea.service.ITeaService;
import com.ruoyi.project.module.teaManager.service.ITeaManagerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教师管理 信息操作处理
 * 
 * @author MeiEQ
 * @date 2018-11-01
 */
@Controller
@RequestMapping("/module/teaManager")
public class TeaManagerController extends BaseController
{
    private String prefix = "module/teaManager";
	
	@Autowired
	private ITeaManagerService teaManagerService;
	@Autowired
	private ITeaService teaService;

	@RequiresPermissions("module:teaManager:view")
	@GetMapping()
	public String teaManager()
	{
	    return prefix + "/teaManager";
	}
	
	/**
	 * 查询教师管理列表
	 */
	@RequiresPermissions("module:teaManager:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeaManager teaManager)
	{
		startPage();
        List<TeaManager> list = teaManagerService.selectTeaManagerList(teaManager);
		return getDataTable(list);
	}
	
	/**
	 * 新增教师管理
	 */
	@GetMapping("/add")
	public String add(ModelMap modelMap)
	{
	    modelMap.addAttribute("teaList",teaService.selectTeaList(null));
		return prefix + "/add";
	}
	
	/**
	 * 新增保存教师管理
	 */
	@RequiresPermissions("module:teaManager:add")
	@Log(title = "教师管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeaManager teaManager)
	{		
		return toAjax(teaManagerService.insertTeaManager(teaManager));
	}

	/**
	 * 修改教师管理
	 */
	@GetMapping("/edit/{teaManagerId}")
	public String edit(@PathVariable("teaManagerId") Integer teaManagerId, ModelMap mmap)
	{
		TeaManager teaManager = teaManagerService.selectTeaManagerById(teaManagerId);
		mmap.put("teaManager", teaManager);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存教师管理
	 */
	@RequiresPermissions("module:teaManager:edit")
	@Log(title = "教师管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeaManager teaManager)
	{		
		return toAjax(teaManagerService.updateTeaManager(teaManager));
	}
	
	/**
	 * 删除教师管理
	 */
	@RequiresPermissions("module:teaManager:remove")
	@Log(title = "教师管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teaManagerService.deleteTeaManagerByIds(ids));
	}
	/**
	 * 校验保存的是否重复
	 */
	@PostMapping("/checkUnique")
	@ResponseBody
	public String checkUnique(TeaManager teaManager)
	{
		return teaManagerService.checkUnique(teaManager);
	}
	
}
