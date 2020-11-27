package com.computer.campaign.service;

import com.computer.campaign.pojo.Participant;

/**
 * @author Mr.Huang
 * @create 2020-05-12 23:02
 */
public interface ParticipantService {
    public Participant judge(String s_id);
    //检验是否参与过竞选

    public boolean contend(Participant participant, String d_id);
    //竞选功能

   public Participant checkParticipantFile(Participant participant)throws Exception;
/*校验竞选者图片，并封装图片路径信息*/

}
