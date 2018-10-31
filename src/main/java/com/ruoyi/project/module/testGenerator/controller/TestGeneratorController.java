package com.ruoyi.project.module.testGenerator.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.entity.TestGenerator;
import com.ruoyi.project.module.testGenerator.service.ITestGeneratorService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 测试 信息操作处理
 * 
 * @author MeiEQ
 * @date 2018-10-19
 */
@Controller
@RequestMapping("/module/testGenerator")
public class TestGeneratorController extends BaseController
{
    private String prefix = "module/testGenerator";
	
	@Autowired
	private ITestGeneratorService testGeneratorService;
	
	@RequiresPermissions("module:testGenerator:view")
	@GetMapping()
	public String testGenerator()
	{
	    return prefix + "/testGenerator";
	}
	
	/**
	 * 查询测试列表
	 */
	@RequiresPermissions("module:testGenerator:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TestGenerator testGenerator)
	{
		startPage();
        List<TestGenerator> list = testGeneratorService.selectTestGeneratorList(testGenerator);
		return getDataTable(list);
	}
	
	/**
	 * 新增测试
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存测试
	 */
	@RequiresPermissions("module:testGenerator:add")
	@Log(title = "测试", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TestGenerator testGenerator)
	{		
		return toAjax(testGeneratorService.insertTestGenerator(testGenerator));
	}

	/**
	 * 修改测试
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TestGenerator testGenerator = testGeneratorService.selectTestGeneratorById(id);
		mmap.put("testGenerator", testGenerator);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存测试
	 */
	@RequiresPermissions("module:testGenerator:edit")
	@Log(title = "测试", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TestGenerator testGenerator)
	{		
		return toAjax(testGeneratorService.updateTestGenerator(testGenerator));
	}
	
	/**
	 * 删除测试
	 */
	@RequiresPermissions("module:testGenerator:remove")
	@Log(title = "测试", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@Transactional(rollbackFor = Exception.class)
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(testGeneratorService.deleteTestGeneratorByIds(ids));
	}
	
}
