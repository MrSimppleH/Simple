package com.computer.campaign.service.impl;

import com.computer.campaign.mapper.LoginMapper;
import com.computer.campaign.pojo.Admin;
import com.computer.campaign.pojo.SimpleUser;
import com.computer.campaign.pojo.SuperUser;
import com.computer.campaign.service.AdminUserService;
import com.computer.campaign.service.LoginService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Mr.Huang
 * @create 2020-05-11 23:30
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;
    @Override
    public boolean adminLogin(Admin admin) throws Exception {
        if(loginMapper.adminLogin(admin)!=null){
            return true;
        }
        return false;
    }

    @Override

    public SimpleUser simpleUserLogin(SimpleUser simpleUser) throws Exception {

        return loginMapper.simpleUserLogin(simpleUser);
    }

    @Override
    public SuperUser superUserLogin(SuperUser superUser) throws Exception {

        return loginMapper.superUserLogin(superUser);
    }
}
