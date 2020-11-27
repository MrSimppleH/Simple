package com.computer.campaign.service.impl;

import com.computer.campaign.mapper.SuperUserMapper;
import com.computer.campaign.mapper.SystemMapper;
import com.computer.campaign.pojo.*;
import com.computer.campaign.service.AdminUserService;
import com.computer.campaign.service.SuperUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mr.Huang
 * @create 2020-05-11 23:30
 */
@Service
public class SuperUserServiceImpl implements SuperUserService {
    @Autowired
    SystemMapper systemMapper;
    @Autowired
    SuperUserMapper superUserMapper;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;


    @Override
    public List<Participant> showAllPartByD_id(Participant participant,String d_id) {
        List<Participant> participantList = systemMapper.showAllPartByD_id(participant);

        return participantList;
    }

    @Override
    public List<Participant> showAllPartsByD_idS_id(Participant participant,String d_id, String s_id) {
        List<Participant> participantList = systemMapper.showAllPartsByD_idS_id(participant);

        return participantList;
    }

    @Override
    public List<Participant> searchByPidName(String p_nameOrp_id) {
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(p_nameOrp_id);
        Participant participant=new Participant();
        if (m.matches()) {//判断是否包含数字
            participant.setP_id(p_nameOrp_id);
        }else {
            participant.setP_name(p_nameOrp_id);
        }
        return superUserMapper.findByP_idP_name(participant);

    }




    @Override
    /*投票，并且在投票前检查是否在该组织该职位投过票，若投过票，返回投票者姓名*/
//    @Cacheable(value = "check",key = "#sup_id+#d_id+','+#s_id",condition = "#result!=null")
    public String vote(SuperUserCampaignDetail superUserCampaignDetail,String s_id,String sup_id,String p_id, String d_id) {
        SuperUserCampaignDetail superUserCampaignDetail1 = superUserMapper.judgeBySu_idS_id(superUserCampaignDetail);

        if(superUserCampaignDetail1!=null){
            String YiTouName = superUserCampaignDetail1.getParticipant().getP_name();
            //如果不为空说明在该组织该竞选类别已投过票
            return YiTouName;
        }else{
            if(superUserMapper.vote(superUserCampaignDetail)>0){//记录投票信息
                superUserMapper.sumPoll(p_id);//为竞选人加10票

                return null;
            }else {
                //抛异常
                return  null;
            }
        }

    }



}
