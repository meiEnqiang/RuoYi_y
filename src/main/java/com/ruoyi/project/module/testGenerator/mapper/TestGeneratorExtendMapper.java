package com.ruoyi.project.module.testGenerator.mapper;

import com.ruoyi.entity.TestGenerator;
import com.ruoyi.mapper.TestGeneratorMapper;

import java.util.List;

/**
 * 测试 数据层
 * 
 * @author MeiEQ
 * @date 2018-10-19
 */
public interface TestGeneratorExtendMapper extends TestGeneratorMapper{

	/**
     * 查询测试列表
     * 
     * @param testGenerator 测试信息
     * @return 测试集合
     */
	List<TestGenerator> selectTestGeneratorList(TestGenerator testGenerator);

	/**
     * 批量删除测试
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteTestGeneratorByIds(String[] ids);
	
}