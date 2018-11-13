package com.ruoyi.project.monitor.job.task;

import com.ruoyi.project.module.courseArrangement.service.ICourseArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author MeiEnQiang
 * @date 2018/11/12/0012
 */
@Component("courseTask")
public class CourseTask {
    @Autowired
    ICourseArrangementService courseArrangementService;
    //@Log(title = "课程完成", businessType = BusinessType.OTHER)
    public void courseFish(){
        int i = courseArrangementService.updateFishStatus();
        System.out.println(i + "条课程已完成");
    }
}
