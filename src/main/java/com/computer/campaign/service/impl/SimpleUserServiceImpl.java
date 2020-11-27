package com.computer.campaign.service.impl;

import com.computer.campaign.exception.UserNotFoundException;
import com.computer.campaign.mapper.SimpleUserMapper;
import com.computer.campaign.mapper.SystemMapper;
import com.computer.campaign.pojo.*;
import com.computer.campaign.service.AdminUserService;
import com.computer.campaign.service.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mr.Huang
 * @create 2020-05-11 23:30
 */

@Service
public class SimpleUserServiceImpl implements SimpleUserService {
    @Autowired
    SimpleUserMapper simpleUserMapper;
    @Autowired
    SystemMapper systemMapper;

    @Override
    public boolean findBySu_id(String su_id) {
        if(simpleUserMapper.findBySu_id(su_id)!=null){
            //已注册
            return false;
        }
        return true;
    }

    @Override
    /*普通用户注册*/
    public boolean insertSimpleUser(SimpleUser simpleUser) {
        if(simpleUserMapper.insertSimpleUser(simpleUser)>0){
            //为该组织人员总数+1
            simpleUserMapper.sumd_sum(simpleUser.getD_id());
            return true;
        }
        return false;
    }

    @Override
    /*用于首页显示当前组织下所有参与竞选者*/
    public List<Participant> showAllPartByD_id(String d_id) {
        //id为空抛异常
        List<Participant> participantList = simpleUserMapper.showAllPartByD_id(d_id);
        return participantList;
    }

    @Override
    /*普通用户显示该组某一职位中的全部竞选人*/
    public List<Participant> showByD_idS_id(Participant participant,String d_id, String s_id) {
        List<Participant> participantList = systemMapper.showAllPartsByD_idS_id(participant);
        return participantList;
    }

    @Override
  /*  普通用户搜索仅限在当前组织内*/
    public List<Participant> searchByPidNameD_id(String p_nameOrp_id,String d_id) {
        Participant participant=new Participant();
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(p_nameOrp_id);
        participant.setD_id(d_id);
        if (m.matches()) {//判断是否包含数字，如果包含数字则作为按竞选号搜索
            participant.setP_id(p_nameOrp_id);
        }else {//不包含数字则作为按姓名搜索
            participant.setP_name(p_nameOrp_id);
        }
        return simpleUserMapper.findPartByP_idP_NameD_id(participant);
    }

    @Override
    /*投票，并且在投票前检查是否在该职位投过票，若投过票，返回投票者姓名*/

    public String vote(SimpleUserCampaignDetail simpleUserCampaignDetail,String su_id,String p_id,String s_id,String d_id) throws Exception {
        SimpleUserCampaignDetail simpleUserCampaignDetail1 = simpleUserMapper.judgeBySu_idS_id(simpleUserCampaignDetail);
        if(simpleUserCampaignDetail1!=null){//如果不为空说明在该竞选类别已投过票
            String YiTouName = simpleUserCampaignDetail1.getParticipant().getP_name();
            //如果不为空说明在该竞选类别已投过票
            return YiTouName;
        }else{
            if(simpleUserMapper.vote(simpleUserCampaignDetail)>0){//记录投票信息
                  simpleUserMapper.sumPoll(p_id);//为竞选人加一票
                return null;
            }else {

                return  null;
            }
        }





    }


}
