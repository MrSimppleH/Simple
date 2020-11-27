package com.computer.campaign.mapper;

import com.computer.campaign.pojo.Admin;
import com.computer.campaign.pojo.Department;
import com.computer.campaign.pojo.Sort;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-11 21:43
 * 管理员权限
 */
@Mapper
public interface AdminMapper {

    public List<Sort> showAllSort();
    /*仅显示竞选类别（竞选职位，餐饮菜系等）*/
    public int insert(Sort sort);
    /*添加竞选类别*/
    public int update(Sort sort);
    /*修改*/
    public int delete(String s_id);
    public Sort showByS_id(String s_id);

    public int insertDepartment(Department department);
    public List<Department> showAllDepartment();

}
