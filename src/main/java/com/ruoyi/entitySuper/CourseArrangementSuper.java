package com.ruoyi.entitySuper;

import lombok.Data;

import java.util.Date;

/**
 * @author MeiEnQiang
 * @date 2018/11/1/0001
 */
@Data
public class CourseArrangementSuper {
    private String course;
    private String grade;
    private String borderColor;
    private String backgroundColor;
    private String textColor;
    private Date start;
    private Date end;
    private Integer id;
    private Boolean status;
}
