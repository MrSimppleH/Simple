package com.computer.campaign.service;

import com.computer.campaign.pojo.Department;
import com.computer.campaign.pojo.P_nameP_poll;
import com.computer.campaign.pojo.Participant;
import com.computer.campaign.pojo.Sort;

import java.util.List;
import java.util.Set;

/**
 * @author Mr.Huang
 * @create 2020-05-15 16:40
 */
public interface SystemService {
    public List<Department> showAllDepartment();
    /*仅显示全部组织信息*/

    public List<Sort> showAllSort(String d_id);
    /*根据所选组织仅显示全部竞选类别信息*/

    public Participant showByP_id(String p_id);
    /*    显示竞选者详情*/


    public List<P_nameP_poll> p_pollByD_idS_id(String d_id, String s_id);
    //获取该组织该职位每个人的得票数


}
