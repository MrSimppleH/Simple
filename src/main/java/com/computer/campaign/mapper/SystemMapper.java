package com.computer.campaign.mapper;

import com.computer.campaign.pojo.Department;
import com.computer.campaign.pojo.P_nameP_poll;
import com.computer.campaign.pojo.Participant;
import com.computer.campaign.pojo.Sort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author Mr.Huang
 * @create 2020-05-12 9:16
 * 封装各类用户公用的部分
 * 及系统需要显示的内容
 */
@Mapper
public interface SystemMapper {
    public List<Department> showAllDepartment();
    /*仅显示全部组织信息*/

    public List<Sort> showAllSort(String d_id);
 /*   根据所选组织仅显示全部竞选类别信息*/

//    public List<Participant> showAllPartsByD_idS_id(String d_id, String s_id);
    public List<Participant> showAllPartsByD_idS_id(Participant participant);
/*    根据所选组织的id和竞选类别的id显示所有竞选人
participant和sort，department，关联用于显示竞选者，竞选职位名和所在组织名*/

    public Participant showByP_id(String p_id);
/*    显示竞选者详情
(participant和sort，department，关联用于显示竞选者，竞选职位名和所在组织名)*/

public List<Participant> showAllPartByD_id(Participant participant);

public List<P_nameP_poll> p_pollByD_idS_id(@Param("d_id") String d_id, @Param("s_id") String s_id);
//用于显示扇形统计图的分母，查询该组织该职位的总票数
}
