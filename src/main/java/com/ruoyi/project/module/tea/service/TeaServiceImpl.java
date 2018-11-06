package com.ruoyi.project.module.tea.service;

import java.util.List;
import com.ruoyi.entity.Tea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.tea.mapper.TeaExtendMapper;
import com.ruoyi.project.module.tea.service.ITeaService;
import com.ruoyi.common.support.Convert;

/**
 * 教师 服务层实现
 * 
 * @author MeiEQ
 * @date 2018-11-01
 */
@Service
public class TeaServiceImpl implements ITeaService 
{
	@Autowired
	private TeaExtendMapper teaMapper;

	/**
     * 查询教师信息
     * 
     * @param teaId 教师ID
     * @return 教师信息
     */
    @Override
	public Tea selectTeaById(Integer teaId)
	{
	    return teaMapper.selectByPrimaryKey(teaId);
	}
	
	/**
     * 查询教师列表
     * 
     * @param tea 教师信息
     * @return 教师集合
     */
	@Override
	public List<Tea> selectTeaList(Tea tea)
	{
	    return teaMapper.selectTeaList(tea);
	}
	
    /**
     * 新增教师
     * 
     * @param tea 教师信息
     * @return 结果
     */
	@Override
	public int insertTea(Tea tea)
	{
	    return teaMapper.insertSelective(tea);
	}
	
	/**
     * 修改教师
     * 
     * @param tea 教师信息
     * @return 结果
     */
	@Override
	public int updateTea(Tea tea)
	{
	    return teaMapper.updateByPrimaryKeySelective(tea);
	}

	/**
     * 删除教师对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeaByIds(String ids)
	{
		return teaMapper.deleteTeaByIds(Convert.toStrArray(ids));
	}
	
}
