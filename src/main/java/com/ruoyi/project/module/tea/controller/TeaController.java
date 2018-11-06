package com.ruoyi.project.module.tea.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.entity.Tea;
import com.ruoyi.project.module.tea.service.ITeaService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 教师 信息操作处理
 * 
 * @author MeiEQ
 * @date 2018-11-01
 */
@Controller
@RequestMapping("/module/tea")
public class TeaController extends BaseController
{
    private String prefix = "module/tea";
	
	@Autowired
	private ITeaService teaService;
	
	@RequiresPermissions("module:tea:view")
	@GetMapping()
	public String tea()
	{
	    return prefix + "/tea";
	}
	
	/**
	 * 查询教师列表
	 */
	@RequiresPermissions("module:tea:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Tea tea)
	{
		startPage();
        List<Tea> list = teaService.selectTeaList(tea);
		return getDataTable(list);
	}
	
	/**
	 * 新增教师
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存教师
	 */
	@RequiresPermissions("module:tea:add")
	@Log(title = "教师", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Tea tea)
	{		
		return toAjax(teaService.insertTea(tea));
	}

	/**
	 * 修改教师
	 */
	@GetMapping("/edit/{teaId}")
	public String edit(@PathVariable("teaId") Integer teaId, ModelMap mmap)
	{
		Tea tea = teaService.selectTeaById(teaId);
		mmap.put("tea", tea);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存教师
	 */
	@RequiresPermissions("module:tea:edit")
	@Log(title = "教师", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Tea tea)
	{		
		return toAjax(teaService.updateTea(tea));
	}
	
	/**
	 * 删除教师
	 */
	@RequiresPermissions("module:tea:remove")
	@Log(title = "教师", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teaService.deleteTeaByIds(ids));
	}
	
}
