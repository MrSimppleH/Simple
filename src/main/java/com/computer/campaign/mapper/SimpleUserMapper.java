package com.computer.campaign.mapper;

import com.computer.campaign.pojo.Participant;
import com.computer.campaign.pojo.SimpleUser;
import com.computer.campaign.pojo.SimpleUserCampaignDetail;
import com.computer.campaign.pojo.Sort;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-11 21:43
 * 普通用户的操作
 */
@Mapper
public interface SimpleUserMapper {
    //public List<Sort> showAllSort(String d_id);//测试阶段使用
    //显示本组织全部竞选信息，Sort中包含participant（全盘抛出不可取，暂且抛弃）

    public SimpleUser findBySu_id(String su_id);
    /* 检测是否已该id注册过*/

    public int insertSimpleUser(SimpleUser simpleUser);
    /*注册*/
    public int sumd_sum(String d_id);
    /*为所注册组织人员数+1*/

    public List<Participant> showAllPartByD_id(String d_id);
    /*用于首页显示该组织内全部参与竞选的人
     (participant 和 sort 和department关联，用于显示竞选名称，和，所在组织名)*/


    public List<Participant> showPartByD_idS_id(Participant participant);
   /* 通过组织id和竞选类别id显示竞选人(participant 和 sort 和department关联，用于显示竞选名称，和，所在组织名)*/

//    public List<Participant> findPartByP_idP_NameD_id(String p_id, String p_name, String d_id);
    public List<Participant> findPartByP_idP_NameD_id(Participant participant);
    /*搜索,普通用户仅限在该组织内搜索 动态拼接sql，按名字模糊查询，或，按编号查询
     (participant 和 sort和department关联，用于显示竞选名称，和，所在组织名)*/

//    public SimpleUserCampaignDetail judgeBySu_idS_id(String su_id, String s_id, String d_id);
    public SimpleUserCampaignDetail judgeBySu_idS_id(SimpleUserCampaignDetail simpleUserCampaignDetail);
/*    通过个人id和该职位id查询投票明细（用于服务层判断是否投过票）
    （simpleUsercampaign和participant用于映射被投票人姓名）*/

//    public int vote(String su_id, String p_id, String s_id, String d_id);

    public int vote(SimpleUserCampaignDetail simpleUserCampaignDetail);
/*    投票*/
@CacheEvict(value = "participant",key = "#p_id")
    public int sumPoll(String p_id);
/*  参与投票给被投票人总数+1*/
    /*
    *两条sql
    *1.一个写入普通用户投票明细表
    * 2.在竞选者表中的投票数+1
    * （暂不用）一个标签执行多条sql语句需在配置文件开启，参照下面博客
    * https://blog.csdn.net/Kevin___________/article/details/103911854*/

}
