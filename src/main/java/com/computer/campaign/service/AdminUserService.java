package com.computer.campaign.service;

import com.computer.campaign.pojo.Department;
import com.computer.campaign.pojo.Sort;

import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-11 23:29
 */
public interface AdminUserService {
    public List<Sort> showAllSort() throws Exception;//显示竞选类别（竞选职位，餐饮菜系等）
    public boolean insert(Sort sort) throws Exception;//添加竞选类别
    public boolean update(Sort sort,String s_id) throws Exception;//修改
    public boolean delete(String s_id) throws Exception;
    public Sort showByS_id(String s_id) throws Exception;

    public boolean insertDepartment(Department department,Integer level);
    public List<Department> showAllDepartment();
}
