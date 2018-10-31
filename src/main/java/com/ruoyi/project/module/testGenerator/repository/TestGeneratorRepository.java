package com.ruoyi.project.module.testGenerator.repository;

import com.ruoyi.entity.TestGenerator;
import com.ruoyi.project.test.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @author MeiEnQiang
 * @date 2018/10/30/0030
 */
public interface TestGeneratorRepository extends JpaRepository<TestGenerator,Long> {
    /**
     * 根据名字模糊查询集合
     * @param name 名字
     * @return List<TestGenerator> 对象集合
     */
    List<TestGenerator> findByNameContaining(String name);

    /**
     * 根据id集合删除对象
     * @param ids 主id集合
     * @return int 成功删除的条数
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    int deleteAllByIdIn(Integer[] ids);

}
