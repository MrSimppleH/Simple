package com.computer.campaign.mapper;

import com.computer.campaign.pojo.Participant;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Mr.Huang
 * @create 2020-05-12 18:04
 */
@Mapper
public interface ParticipantMapper {
    public int contend(Participant participant);
    /*竞选功能*/
    public int sumCpoll(String s_id);
   /* 有人竞选为职位表竞选人数+1*/
    public Participant judge(String p_id);
    /*检验是否参与过竞选，*/
   /* participant和sort关联映射竞选类别名*/



}
