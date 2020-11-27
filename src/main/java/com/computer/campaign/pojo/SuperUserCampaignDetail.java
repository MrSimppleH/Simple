package com.computer.campaign.pojo;

import java.io.Serializable;

/**
 * @author Mr.Huang
 * @create 2020-05-11 23:59
 * 封装普通用户的投票明细
 */
public class SuperUserCampaignDetail implements Serializable {
    private String sup_id;
    private String d_id;//组织id
    private String s_id;//类别（例：竞选职位，餐饮菜系）
    private String p_id;//被选者
    private Participant participant;//用于resultMap,选票明细与竞选人一对一
    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
