package com.ruoyi.project.module.testGenerator.service;

import com.ruoyi.common.support.Convert;
import com.ruoyi.entity.TestGenerator;
import com.ruoyi.project.module.testGenerator.mapper.TestGeneratorExtendMapper;
import com.ruoyi.project.module.testGenerator.repository.TestGeneratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
	@Autowired
	private TestGeneratorRepository testGeneratorRepository;

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
	@Transactional(rollbackFor = Exception.class)
	public int deleteTestGeneratorByIds(String ids)
	{
		//int i = testGeneratorMapper.deleteTestGeneratorByIds(Convert.toStrArray(ids));
		return testGeneratorRepository.deleteAllByIdIn(Convert.toIntArray(ids));
	}
	
}
