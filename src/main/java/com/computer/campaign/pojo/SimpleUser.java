package com.computer.campaign.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-11 21:45
 * 封装普通用户信息
 */
public class SimpleUser implements Serializable {
    private String su_id;//
    private String su_name;//姓名
    private String d_id;//所属部门
    private String su_pwd;//密码
    private List<SimpleUserCampaignDetail> simpleUserCampaignDetails;
    private Department department;
    //个人投票明细,一个人多个职位的投票记录 一对多

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<SimpleUserCampaignDetail> getSimpleUserCampaignDetails() {
        return simpleUserCampaignDetails;
    }

    public void setSimpleUserCampaignDetails(List<SimpleUserCampaignDetail> simpleUserCampaignDetails) {
        this.simpleUserCampaignDetails = simpleUserCampaignDetails;
    }

    public String getSu_id() {
        return su_id;
    }

    public void setSu_id(String su_id) {
        this.su_id = su_id;
    }

    public String getSu_name() {
        return su_name;
    }

    public void setSu_name(String su_name) {
        this.su_name = su_name;
    }

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getSu_pwd() {
        return su_pwd;
    }

    public void setSu_pwd(String su_pwd) {
        this.su_pwd = su_pwd;
    }
}
