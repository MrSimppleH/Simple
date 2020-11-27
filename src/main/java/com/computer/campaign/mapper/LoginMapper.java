package com.computer.campaign.mapper;

import com.computer.campaign.pojo.Admin;
import com.computer.campaign.pojo.SimpleUser;
import com.computer.campaign.pojo.SuperUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Mr.Huang
 * @create 2020-05-11 21:43
 * 用于各身份的登录验证
 */
@Mapper
public interface LoginMapper {
    public Admin adminLogin(Admin admin);
    /*管理员登录*/

    public SimpleUser simpleUserLogin(SimpleUser simpleUser);
    /*普通用户*/

    public SuperUser superUserLogin(SuperUser superUser);
   /* 高级用户*/

}
