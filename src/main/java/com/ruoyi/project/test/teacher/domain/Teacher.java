package com.ruoyi.project.test.teacher.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * @author MeiEnQiang
 * @date 2018/10/10/0010
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_teacher")
@Data
public class Teacher extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String name;
    @Column
    private Date createDate;
}
