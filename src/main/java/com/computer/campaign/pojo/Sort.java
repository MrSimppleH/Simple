package com.computer.campaign.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-11 21:45
 * 特殊组织（学生会，等）添加外键
 */
//封装竞选类别信息，（例：竞选职位，餐饮菜系）1，cid，2名字 3竞选人数,4要求（管理员通过此类进行职位修改和删除）
public class Sort implements Serializable {
        //封装竞选类别信息，1，cid，2名字 3竞选人数,4要求（管理员通过此类进行竞选类别修改和删除）
        private String s_id;
        private String s_name;//名称
        private String requirement;//要求
        private String effect;//作用
        private String s_poll;//竞选参与数
        private String d_id;//特殊组织的外键。用于表示特殊组织独有的竞选位
        private List<Participant> participants;//竞选类别信息与竞选人，一对多
        private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getS_poll() {
        return s_poll;
    }

    public void setS_poll(String s_poll) {
        this.s_poll = s_poll;
    }
}
