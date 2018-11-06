package com.ruoyi.project.module.teaManager.mapper;

import com.ruoyi.entity.TeaManager;
import com.ruoyi.mapper.TeaManagerMapper;

import java.util.List;

/**
 * 教师管理 数据层
 * 
 * @author MeiEQ
 * @date 2018-11-01
 */
public interface TeaManagerExtendMapper extends TeaManagerMapper{

	/**
     * 查询教师管理列表
     * 
     * @param teaManager 教师管理信息
     * @return 教师管理集合
     */
	List<TeaManager> selectTeaManagerList(TeaManager teaManager);

	/**
     * 批量删除教师管理
     * 
     * @param teaManagerIds 需要删除的数据ID
     * @return 结果
     */
	int deleteTeaManagerByIds(String[] teaManagerIds);
	
}