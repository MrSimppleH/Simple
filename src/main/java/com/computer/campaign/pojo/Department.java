package com.computer.campaign.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-11 23:40
 * 所属组织（所属班级，所属餐饮菜系，所属部门等）
 * 用于普通用户仅能查看本组织竞选信息
 *
 */
/*组织有划分，普通组织*/
public class Department implements Serializable {
    private String d_id;//普通组织uuid去"-"；特殊组织为纯数字
    private String d_name;//组织名称
    private String d_sum;//组织内人数
    private List<Sort> sorts;//一个特殊组织内有多个类别进行竞选 组织与类别一对多
    private List<SimpleUser> simpleUsers;//一个组织内有多个普通用户 一对多
    private List<Participant> participants;//用于普通用户进入后显示该组织内所有参与竞选的人

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Sort> getSorts() {
        return sorts;
    }

    public void setSorts(List<Sort> sorts) {
        this.sorts = sorts;
    }

    public List<SimpleUser> getSimpleUsers() {
        return simpleUsers;
    }

    public void setSimpleUsers(List<SimpleUser> simpleUsers) {
        this.simpleUsers = simpleUsers;
    }

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_sum() {
        return d_sum;
    }

    public void setD_sum(String d_sum) {
        this.d_sum = d_sum;
    }
}
