package com.computer.campaign.service.impl;

import com.computer.campaign.mapper.SystemMapper;
import com.computer.campaign.pojo.Department;
import com.computer.campaign.pojo.P_nameP_poll;
import com.computer.campaign.pojo.Participant;
import com.computer.campaign.pojo.Sort;
import com.computer.campaign.service.SystemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author Mr.Huang
 * @create 2020-05-15 16:42
 */

@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    SystemMapper systemMapper;

    @Override

    public List<Department> showAllDepartment() {
        return systemMapper.showAllDepartment();
    }

    @Override

    public List<Sort> showAllSort(String d_id) {
        if(d_id.matches("[0-9]+")){//判断是否为纯数字，纯数字为特殊组织
            return systemMapper.showAllSort(d_id);//返回特殊组织独有的竞选职位
        }else {
            return systemMapper.showAllSort("public");//返回普通组织的竞选职位
        }

    }
    @Override
    public Participant showByP_id(String p_id) {
        Participant participant = systemMapper.showByP_id(p_id);

        return participant;
    }
    @Override
    public List<P_nameP_poll> p_pollByD_idS_id(String d_id, String s_id) {
        return systemMapper.p_pollByD_idS_id(d_id,s_id);
    }

}
