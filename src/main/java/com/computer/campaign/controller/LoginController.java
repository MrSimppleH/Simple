package com.computer.campaign.controller;

import com.computer.campaign.mapper.SystemMapper;
import com.computer.campaign.pojo.*;
import com.computer.campaign.service.LoginService;
import com.computer.campaign.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-11 21:33
 */
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    SystemService systemService;
    @RequestMapping({"/toLogin","toLogin"})
    public String toLogin(){
        return "test/login";
    }
    @RequestMapping({"/toAdminPage","toAdminPage"})
    public String  toAdminLoginPage(){
        return "test/adminLogin";
    }
    @PostMapping({"/toAdminLogin","toAdminLogin"})
    public String adminLogin(Admin admin, HttpSession session, Model model) throws Exception {
        if(loginService.adminLogin(admin)){
            session.setAttribute("user_name",admin.getA_id());
            return "redirect:/adminShowAll";
        }else {
            model.addAttribute("errorMsg","密码错误");
            return "redirect:/toLogin";
        }
    }
    @RequestMapping({"/simpleUserLogin","simpleUserLogin"})
    public String simpleUserLogin(@RequestParam("id") String su_id, @RequestParam("pwd") String su_pwd, HttpSession session, Model model)throws Exception{
        SimpleUser simpleUser=new SimpleUser();
        simpleUser.setSu_id(su_id);
        simpleUser.setSu_pwd(su_pwd);
        SimpleUser simpleUser1 = loginService.simpleUserLogin(simpleUser);
        if(simpleUser1!=null){
            List<Sort> sortList = systemService.showAllSort(simpleUser1.getD_id());
            session.setAttribute("sortList",sortList);
            //表示身份1表示super，0表示simple

            session.setAttribute("shenfen",0);
            session.setAttribute("user_id",su_id);
            session.setAttribute("d_name",simpleUser1.getDepartment().getD_name());
            session.setAttribute("d_id",simpleUser1.getD_id());
//            String d_name=
//           session.setAttribute("d_name",d_name);//存储组织名
            session.setAttribute("user_name",simpleUser1.getSu_name());
            return "redirect:/showAllBy_id";
        }else {
            model.addAttribute("errorMsg","密码错误");
            return "redirect:/toLogin";
        }
    }
    @PostMapping({"/superUserLogin","superUserLogin"})
    public String superUserLogin(@RequestParam("id") String sup_id, @RequestParam("pwd") String sup_pwd, HttpSession session, Model model)throws  Exception{
        SuperUser superUser=new SuperUser();
        superUser.setSup_id(sup_id);
        superUser.setSup_pwd(sup_pwd);
        SuperUser superUser1 = loginService.superUserLogin(superUser);
        if(superUser1!=null){
            List<Department> departments = systemService.showAllDepartment();
            session.setAttribute("departmentList",departments);

            //表示身份1表示super，0表示simple
            session.setAttribute("shenfen",1);
            session.setAttribute("user_name",superUser1.getSup_name());
            session.setAttribute("user_id",superUser.getSup_id());
            return "test/department";
        }else {
            model.addAttribute("errorMsg","密码错误");
            return "redirect:/toLogin";
        }
    }
    @RequestMapping("/logout")//退出
    public String logout(HttpSession session)throws Exception{
        session.invalidate();
        return "redirect:/toLogin";
    }
}
