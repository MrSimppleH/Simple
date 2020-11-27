package com.computer.campaign.service.impl;

import com.computer.campaign.mapper.AdminMapper;
import com.computer.campaign.pojo.Department;
import com.computer.campaign.pojo.Sort;
import com.computer.campaign.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Mr.Huang
 * @create 2020-05-11 23:30
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public List<Sort> showAllSort() throws Exception {
        List<Sort> sortList=adminMapper.showAllSort();
        if (sortList.size()>0){//判断是否有数据
            return sortList;
        }
        return null;
    }

    @Override

    public boolean insert(Sort sort) throws Exception {

        sort.setS_id(UUID.randomUUID().toString().replace("-",""));
        if (adminMapper.insert(sort)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Sort sort,String s_id) throws Exception {
        if(adminMapper.update(sort)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String s_id) throws Exception {
        if(adminMapper.delete(s_id)>0){
            return true;
        }
        return false;
    }

    @Override
    public Sort showByS_id(String s_id) throws Exception {
        Sort sort = adminMapper.showByS_id(s_id);
        if(sort!=null){
            return sort;
        }
        return null;
    }

    @Override
    public boolean insertDepartment(Department department,Integer level) {
        if(level==1){//判断添加的组织级别，1为特殊组织则，生成的id为纯数字
            Integer d_id=UUID.randomUUID().toString().hashCode();
            d_id = d_id < 0 ? -d_id : d_id;//验证id视为负数，替换为正数
            department.setD_id(d_id.toString());
            if(adminMapper.insertDepartment(department)>0){
                return true;
            }else {return false;}

        }else {//验证级别为普通则id为普通uuid去-，
            String d_id=UUID.randomUUID().toString().replace("-","");
            department.setD_id(d_id);
            if(adminMapper.insertDepartment(department)>0){
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public List<Department> showAllDepartment() {

        return adminMapper.showAllDepartment();
    }
}
