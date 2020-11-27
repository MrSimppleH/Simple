package com.computer.campaign.service;

import com.computer.campaign.pojo.Admin;
import com.computer.campaign.pojo.SimpleUser;
import com.computer.campaign.pojo.SuperUser;

/**
 * @author Mr.Huang
 * @create 2020-05-11 23:28
 * 登录业务层
 */
public interface LoginService {
    public boolean adminLogin(Admin admin) throws Exception;
    public SimpleUser simpleUserLogin(SimpleUser simpleUser) throws Exception;
    public SuperUser superUserLogin(SuperUser superUser) throws  Exception;
}
