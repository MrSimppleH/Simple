package com.computer.campaign.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-11 21:47
 * 封装高级用户信息（老师，导员，领导等）
 */
public class SuperUser implements Serializable {
    private String sup_id;
    private String sup_name;
    private String sup_pwd;
    private List<SuperUserCampaignDetail> superUserCampaignDetails;//有多条记录 一对多

    public List<SuperUserCampaignDetail> getSuperUserCampaignDetails() {
        return superUserCampaignDetails;
    }

    public void setSuperUserCampaignDetails(List<SuperUserCampaignDetail> superUserCampaignDetails) {
        this.superUserCampaignDetails = superUserCampaignDetails;
    }

    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }

    public String getSup_name() {
        return sup_name;
    }

    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }

    public String getSup_pwd() {
        return sup_pwd;
    }

    public void setSup_pwd(String sup_pwd) {
        this.sup_pwd = sup_pwd;
    }
}
