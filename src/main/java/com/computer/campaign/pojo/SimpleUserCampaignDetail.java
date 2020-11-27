package com.computer.campaign.pojo;

import java.io.Serializable;

/**
 * @author Mr.Huang
 * @create 2020-05-11 23:59
 * 封装高级用户的投票明细
 */
public class SimpleUserCampaignDetail implements Serializable {
    private String su_id;
    private String s_id;//类别
    private String p_id;//被选者
    private String d_id;//组织
    private Participant participant;//用于resultMap，选票明细与被选人，一对一

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public String getSu_id() {
        return su_id;
    }

    public void setSu_id(String su_id) {
        this.su_id = su_id;
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

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }
}
