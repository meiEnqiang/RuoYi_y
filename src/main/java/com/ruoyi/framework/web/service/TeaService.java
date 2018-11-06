package com.ruoyi.framework.web.service;

import com.ruoyi.entity.Tea;
import com.ruoyi.project.module.tea.service.ITeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MeiEnQiang
 * @date 2018/11/2/0002
 */
@Service("tea")
public class TeaService {
    @Autowired
    private ITeaService teaService;

    public String getTeaName(Integer teaId){
        Tea tea = teaService.selectTeaById(teaId);
        if(tea != null){
            return tea.getName();
        }
        return "";
    }
    public List<Tea> getAllTea(){
        return teaService.selectTeaList(null);
    }
}
