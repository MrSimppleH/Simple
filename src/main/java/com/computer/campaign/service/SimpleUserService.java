package com.computer.campaign.service;

import com.computer.campaign.pojo.Participant;
import com.computer.campaign.pojo.SimpleUser;
import com.computer.campaign.pojo.SimpleUserCampaignDetail;
import com.computer.campaign.pojo.Sort;

import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-11 23:28
 */
public interface SimpleUserService {
    public boolean findBySu_id(String su_id);
    /*检测是否注册过*/

    public boolean insertSimpleUser(SimpleUser simpleUser);
    /*注册*/
    public List<Participant> showAllPartByD_id(String d_id);
    /*用于首页显示该组织内全部参与竞选的人(complete)*/

    public List<Participant> showByD_idS_id(Participant participant,String d_id,String s_id);
    /*通过组织id和竞选类别id显示竞选人(complete)*/

    public List<Participant> searchByPidNameD_id(String p_nameOrp_id,String d_id);
    /*搜索,普通用户仅限在该组织内搜索(complete)*/

    public String vote (SimpleUserCampaignDetail simpleUserCampaignDetail,String su_id,String p_id,String s_id,String d_id)throws  Exception;
    /*    进行投票并返回是否成功(complete)*/

    /**投票包含两个子方法
     *     1. public boolean judgeBySu_idS_id(String su_id, String s_id);
     *     //    通过个人id和该职位id判断是否投过票
     *     2. public int sumPoll(String p_id);
     * //  参与投票给被投票人总数+1
     * */

}
