package com.ruoyi.project.module.fileManage.controller;

import com.ruoyi.entity.FileManage;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.module.fileManage.service.IFileManageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件管理 信息操作处理
 * 
 * @author MeiEQ
 * @date 2018-10-26
 */
@Controller
@RequestMapping("/module/fileManage")
public class FileManageController extends BaseController
{
    private String prefix = "module/fileManage";
	
	@Autowired
	private IFileManageService fileManageService;
	
	@RequiresPermissions("module:fileManage:view")
	@GetMapping()
	public String fileManage()
	{
	    return prefix + "/fileManage";
	}
	
	/**
	 * 查询文件管理列表
	 */
	@RequiresPermissions("module:fileManage:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FileManage fileManage)
	{
		startPage();
        List<FileManage> list = fileManageService.selectFileManageList(fileManage);
		return getDataTable(list);
	}
	
	/**
	 * 新增文件管理
	 */
	@GetMapping("/add")
	public String add()
	{
		//return prefix + "/index";
		return prefix + "/add";
	}

	/**
	 * 新增保存文件管理
	 */
	@RequiresPermissions("module:fileManage:add")
	@Log(title = "文件管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FileManage fileManage, @RequestParam("file") List<MultipartFile> file)
	{
		return toAjax(fileManageService.saveFile(fileManage,file));
	}

	/**
	 * 修改文件管理
	 */
	@GetMapping("/edit/{fileId}")
	public String edit(@PathVariable("fileId") Integer fileId, ModelMap mmap)
	{
		FileManage fileManage = fileManageService.selectFileManageById(fileId);
		mmap.put("fileManage", fileManage);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存文件管理
	 */
	@RequiresPermissions("module:fileManage:edit")
	@Log(title = "文件管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FileManage fileManage, MultipartFile file)
	{		
		return toAjax(fileManageService.updateFileManage(fileManage, file));
	}
	
	/**
	 * 删除文件管理
	 */
	@RequiresPermissions("module:fileManage:remove")
	@Log(title = "文件管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fileManageService.deleteFileManageByIds(ids));
	}
	/**
	 * 校验部门名称
	 */
	@PostMapping("/checkFileNameUnique")
	@ResponseBody
	public String checkFileNameUnique(Integer fileId, String fileName)
	{
		return fileManageService.checkFileNameUnique(fileId,fileName);
	}
	
}
