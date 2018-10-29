package com.ruoyi.project.module.testGenerator.service;

import com.ruoyi.entity.TestGenerator;
import java.util.List;

/**
 * 测试 服务层
 * 
 * @author MeiEQ
 * @date 2018-10-19
 */
public interface ITestGeneratorService 
{
	/**
     * 查询测试信息
     * 
     * @param id 测试ID
     * @return 测试信息
     */
	TestGenerator selectTestGeneratorById(Integer id);
	
	/**
     * 查询测试列表
     * 
     * @param testGenerator 测试信息
     * @return 测试集合
     */
	List<TestGenerator> selectTestGeneratorList(TestGenerator testGenerator);
	
	/**
     * 新增测试
     * 
     * @param testGenerator 测试信息
     * @return 结果
     */
	int insertTestGenerator(TestGenerator testGenerator);
	
	/**
     * 修改测试
     * 
     * @param testGenerator 测试信息
     * @return 结果
     */
	int updateTestGenerator(TestGenerator testGenerator);
		
	/**
     * 删除测试信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteTestGeneratorByIds(String ids);
	
}
