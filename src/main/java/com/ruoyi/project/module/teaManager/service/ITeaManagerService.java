package com.ruoyi.project.module.teaManager.service;

import com.ruoyi.entity.TeaManager;
import java.util.List;
import java.util.Map;

/**
 * 教师管理 服务层
 * 
 * @author MeiEQ
 * @date 2018-11-01
 */
public interface ITeaManagerService 
{
	/**
     * 查询教师管理信息
     * 
     * @param teaManagerId 教师管理ID
     * @return 教师管理信息
     */
	TeaManager selectTeaManagerById(Integer teaManagerId);
	
	/**
     * 查询教师管理列表
     * 
     * @param teaManager 教师管理信息
     * @return 教师管理集合
     */
	List<TeaManager> selectTeaManagerList(TeaManager teaManager);
	
	/**
     * 新增教师管理
     * 
     * @param teaManager 教师管理信息
     * @return 结果
     */
	int insertTeaManager(TeaManager teaManager);
	
	/**
     * 修改教师管理
     * 
     * @param teaManager 教师管理信息
     * @return 结果
     */
	int updateTeaManager(TeaManager teaManager);
		
	/**
     * 删除教师管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteTeaManagerByIds(String ids);

	/**
	 * 检查教师类不能相同
	 * @param teaManager 教师管理类
	 * @return string "1" 没有 "0" 有
	 */
	String checkUnique(TeaManager teaManager);

	/**
	 * 获取所有教师管理
	 * @return Map<Integer,String>
	 */
	Map<Integer,String> getAllMap();
	
}
