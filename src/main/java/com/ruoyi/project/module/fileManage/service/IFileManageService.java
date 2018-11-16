package com.ruoyi.project.module.fileManage.service;

import com.ruoyi.common.fastDFS.FastDFSFile;
import com.ruoyi.entity.FileManage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件管理 服务层
 * 
 * @author MeiEQ
 * @date 2018-10-26
 */
public interface IFileManageService 
{
	/**
     * 查询文件管理信息
     * 
     * @param fileId 文件管理ID
     * @return 文件管理信息
     */
	FileManage selectFileManageById(Integer fileId);
	
	/**
     * 查询文件管理列表
     * 
     * @param fileManage 文件管理信息
     * @return 文件管理集合
     */
	List<FileManage> selectFileManageList(FileManage fileManage);
	
	/**
     * 新增文件管理
     * 
     * @param fileManage 文件管理信息
     * @return 结果
     */
	int insertFileManage(FileManage fileManage);
	
	/**
     * 修改文件管理
     * 
     * @param fileManage 文件管理信息
	 * @param file 上传的文件
     * @return 结果
     */
	int updateFileManage(FileManage fileManage, MultipartFile file);
	/**
     * 修改文件管理
     *
     * @param fileManage 文件管理信息
     * @return 结果
     */
	int updateFileManage(FileManage fileManage);

	/**
     * 删除文件管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteFileManageByIds(String ids);

	/**
	 * 保存文件
	 * @param fileManage 文件实体类
	 * @param file 上传的文件
	 * @return 保存的条数
	 */
	int saveFile(FileManage fileManage, MultipartFile file);
	/**
	 * 保存文件
	 * @param fileManage 文件实体类
	 * @param files 上传的文件
	 * @return 保存的条数
	 */
	int saveFile(FileManage fileManage, List<MultipartFile> files);

	/**
	 * 根据主id和文件名字判断是否有相同的
	 * @param fileId 文件主id
	 * @param fileName 文件名称
	 * @return string "1" 没有 "0" 有
	 */
	String checkFileNameUnique(Integer fileId, String fileName);

	/**
	 * 根据保存的文件路径获取文件的所有信息
	 * @param filePath 文件路径
	 * @return FastDFSFile
	 */
	FastDFSFile getFastDFSFileByFilePath(String filePath);

	
}
