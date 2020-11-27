package com.computer.campaign.service;

import com.computer.campaign.pojo.*;

import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-11 23:28
 */
public interface SuperUserService {

    public List<Participant> showAllPartByD_id(Participant participant,String d_id);
     /* 根据组织显示当前组织内所有竞选人*/

    public List<Participant> showAllPartsByD_idS_id(Participant participant,String d_id,String s_id);
    /*根据所选组织的id和竞选类别的id显示所有竞选人*/

    public List<Participant> searchByPidName(String p_nameOrp_id);
    /* 搜索,高级用户不限制搜索*/


    public String vote (SuperUserCampaignDetail superUserCampaignDetail,String s_id,String sup_id,String p_id, String d_id);
    //    投票（各参数id）


}
