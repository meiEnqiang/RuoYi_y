package com.ruoyi.project.module.tea.mapper;

import com.ruoyi.entity.Tea;
import com.ruoyi.mapper.TeaMapper;

import java.util.List;

/**
 * 教师 数据层
 * 
 * @author MeiEQ
 * @date 2018-11-01
 */
public interface TeaExtendMapper extends TeaMapper{

	/**
     * 查询教师列表
     * 
     * @param tea 教师信息
     * @return 教师集合
     */
	List<Tea> selectTeaList(Tea tea);

	/**
     * 批量删除教师
     * 
     * @param teaIds 需要删除的数据ID
     * @return 结果
     */
	int deleteTeaByIds(String[] teaIds);
	
}