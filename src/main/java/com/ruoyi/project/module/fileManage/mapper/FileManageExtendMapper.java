package com.ruoyi.project.module.fileManage.mapper;

import com.ruoyi.entity.FileManage;
import com.ruoyi.mapper.FileManageMapper;

import java.util.List;

/**
 * 文件管理 数据层
 * 
 * @author MeiEQ
 * @date 2018-10-26
 */
public interface FileManageExtendMapper extends FileManageMapper{

	/**
     * 查询文件管理列表
     * 
     * @param fileManage 文件管理信息
     * @return 文件管理集合
     */
	List<FileManage> selectFileManageList(FileManage fileManage);

	/**
     * 批量删除文件管理
     * 
     * @param fileIds 需要删除的数据ID
     * @return 结果
     */
	int deleteFileManageByIds(String[] fileIds);
	
}