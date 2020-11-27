package com.computer.campaign.mapper;

import com.computer.campaign.pojo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-11 21:43
 */
@Mapper
public interface SuperUserMapper {


//    public List<Department> showAll();
//    //查询全部竞选类别信息并封装在Department中,department封装了sort——>Participant

//    public List<Participant> findByP_idP_name(String p_name, String p_id);
    public List<Participant> findByP_idP_name(Participant participant);
    /*搜索,高级用户不限制搜索
    （participant，sort和department关联，用于显示竞选名称，和，所在组织名）*/

//    public SuperUserCampaignDetail judgeBySu_idS_id(String sup_id, String s_id, String d_id);
    public SuperUserCampaignDetail judgeBySu_idS_id(SuperUserCampaignDetail superUserCampaignDetail);
  /*      通过组织id个人id和该职位id查询投的票数（用于服务层判断是否投过票）
    superUsercampaigndetail和participant关联，显示被投票人姓名*/

//    public int vote(String s_id, String sup_id, String p_id, String d_id);
    public int vote(SuperUserCampaignDetail superUserCampaignDetail);
   /*     投票（各参数id）*/

    public int sumPoll(String p_id);
 /*     高级用户参与投票给被投票人总数+10*/

}
