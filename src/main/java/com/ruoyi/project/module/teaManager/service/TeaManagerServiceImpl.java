package com.ruoyi.project.module.teaManager.service;

import com.ruoyi.common.support.Convert;
import com.ruoyi.entity.TeaManager;
import com.ruoyi.entity.TeaManagerExample;
import com.ruoyi.project.module.teaManager.mapper.TeaManagerExtendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 教师管理 服务层实现
 * 
 * @author MeiEQ
 * @date 2018-11-01
 */
@Service
public class TeaManagerServiceImpl implements ITeaManagerService 
{
	@Autowired
	private TeaManagerExtendMapper teaManagerMapper;

	/**
     * 查询教师管理信息
     * 
     * @param teaManagerId 教师管理ID
     * @return 教师管理信息
     */
    @Override
	public TeaManager selectTeaManagerById(Integer teaManagerId)
	{
	    return teaManagerMapper.selectByPrimaryKey(teaManagerId);
	}
	
	/**
     * 查询教师管理列表
     * 
     * @param teaManager 教师管理信息
     * @return 教师管理集合
     */
	@Override
	public List<TeaManager> selectTeaManagerList(TeaManager teaManager)
	{
	    return teaManagerMapper.selectTeaManagerList(teaManager);
	}
	
    /**
     * 新增教师管理
     * 
     * @param teaManager 教师管理信息
     * @return 结果
     */
	@Override
	public int insertTeaManager(TeaManager teaManager)
	{
	    return teaManagerMapper.insertSelective(teaManager);
	}
	
	/**
     * 修改教师管理
     * 
     * @param teaManager 教师管理信息
     * @return 结果
     */
	@Override
	public int updateTeaManager(TeaManager teaManager)
	{
	    return teaManagerMapper.updateByPrimaryKeySelective(teaManager);
	}

	/**
     * 删除教师管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeaManagerByIds(String ids)
	{
		return teaManagerMapper.deleteTeaManagerByIds(Convert.toStrArray(ids));
	}
	/**
	 * 检查教师类不能相同
	 * @param teaManager 教师管理类
	 * @return string "1" 没有 "0" 有
	 */
	@Override
	public String checkUnique(TeaManager teaManager){
		TeaManagerExample example = new TeaManagerExample();
		Integer teaManagerId = teaManager.getTeaManagerId();
		if(teaManagerId == null){
			teaManagerId = -1;
		}
		example.createCriteria().andGradeIdEqualTo(teaManager.getGradeId())
				.andSubjectTypeEqualTo(teaManager.getSubjectType()).andTeaIdEqualTo(teaManager.getTeaId())
				.andTeaManagerIdNotEqualTo(teaManagerId);
		int count = teaManagerMapper.countByExample(example);
		if(count > 0){
			return "error";
		}
		return "success";
	}
}
