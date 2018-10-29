package com.ruoyi.project.module.testGenerator.service;

import java.util.List;
import com.ruoyi.entity.TestGenerator;
import com.ruoyi.entity.TestGeneratorExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.testGenerator.mapper.TestGeneratorExtendMapper;
import com.ruoyi.project.module.testGenerator.service.ITestGeneratorService;
import com.ruoyi.common.support.Convert;

/**
 * 测试 服务层实现
 * 
 * @author MeiEQ
 * @date 2018-10-19
 */
@Service
public class TestGeneratorServiceImpl implements ITestGeneratorService 
{
	@Autowired
	private TestGeneratorExtendMapper testGeneratorMapper;

	/**
     * 查询测试信息
     * 
     * @param id 测试ID
     * @return 测试信息
     */
    @Override
	public TestGenerator selectTestGeneratorById(Integer id)
	{
	    return testGeneratorMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 查询测试列表
     * 
     * @param testGenerator 测试信息
     * @return 测试集合
     */
	@Override
	public List<TestGenerator> selectTestGeneratorList(TestGenerator testGenerator)
	{
		/*TestGeneratorExample example = new TestGeneratorExample();
		example.createCriteria().andCreateByLike(testGenerator.getCreateBy());
		example.setOrderByClause("id desc");
		testGeneratorMapper.selectByExample(example);*/
	    return testGeneratorMapper.selectTestGeneratorList(testGenerator);
	}
	
    /**
     * 新增测试
     * 
     * @param testGenerator 测试信息
     * @return 结果
     */
	@Override
	public int insertTestGenerator(TestGenerator testGenerator)
	{
	    return testGeneratorMapper.insertSelective(testGenerator);
	}
	
	/**
     * 修改测试
     * 
     * @param testGenerator 测试信息
     * @return 结果
     */
	@Override
	public int updateTestGenerator(TestGenerator testGenerator)
	{
	    return testGeneratorMapper.updateByPrimaryKeySelective(testGenerator);
	}

	/**
     * 删除测试对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTestGeneratorByIds(String ids)
	{
		return testGeneratorMapper.deleteTestGeneratorByIds(Convert.toStrArray(ids));
	}
	
}
