package com.ruoyi.project.module.tea.service;

import com.ruoyi.entity.Tea;
import java.util.List;

/**
 * 教师 服务层
 * 
 * @author MeiEQ
 * @date 2018-11-01
 */
public interface ITeaService 
{
	/**
     * 查询教师信息
     * 
     * @param teaId 教师ID
     * @return 教师信息
     */
	Tea selectTeaById(Integer teaId);
	
	/**
     * 查询教师列表
     * 
     * @param tea 教师信息
     * @return 教师集合
     */
	List<Tea> selectTeaList(Tea tea);
	
	/**
     * 新增教师
     * 
     * @param tea 教师信息
     * @return 结果
     */
	int insertTea(Tea tea);
	
	/**
     * 修改教师
     * 
     * @param tea 教师信息
     * @return 结果
     */
	int updateTea(Tea tea);
		
	/**
     * 删除教师信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteTeaByIds(String ids);
	
}
