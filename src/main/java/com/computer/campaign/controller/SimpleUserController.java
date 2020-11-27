package com.computer.campaign.controller;

import com.computer.campaign.mapper.SystemMapper;
import com.computer.campaign.pojo.Department;
import com.computer.campaign.pojo.Participant;
import com.computer.campaign.pojo.SimpleUser;
import com.computer.campaign.pojo.SimpleUserCampaignDetail;
import com.computer.campaign.service.SimpleUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-11 21:35
 * 主要以ajax实现
 */
@Controller
public class SimpleUserController {
    @Autowired
    SimpleUserService simpleUserService;
    @Autowired
    SystemMapper systemMapper;
    @RequestMapping("/toRegister")
    @ResponseBody
    /*返回可注册组织信息*/
    public List<Department> toRegister(/*Model model*/)throws Exception{
        List<Department> departmentList = systemMapper.showAllDepartment();
//        model.addAttribute("departmentList",departmentList);
//        return "test/register";
        return departmentList;
    }
    @PostMapping("/checksu_id")
    @ResponseBody
    public String check(String su_id)throws Exception{
        if(simpleUserService.findBySu_id(su_id)){
            return "true";
        }
        return "false";
    }
    @PostMapping("/register")
    /*注册功能*/
    public String insertSimpleUser(SimpleUser simpleUser)throws Exception{
        if(simpleUserService.insertSimpleUser(simpleUser)){
            return "test/login";
        }else {
            return "test/register";
        }
    }
    @RequestMapping("/showAllBy_id")
    /*通过组织d_id获取本组织内全部竞选人*/
    public String showAllD_id(HttpSession session, Model model)throws Exception{
        String d_id= (String) session.getAttribute("d_id");
        List<Participant> participantList = simpleUserService.showAllPartByD_id(d_id);
        if (participantList!=null){
            model.addAttribute("participantList",participantList);
            return "test/simpleIndex";
        }else {
            return "test/simpleIndex";
        }
    }
    @GetMapping("showByS_id")
    /*普通用户按当前组织查看选定职位竞选人*/
    public String showByD_idS_id(Participant participant,String s_id,Model model,HttpSession session)throws Exception{
        String d_id= (String) session.getAttribute("d_id");
        participant.setD_id(d_id);//为安全
        List<Participant> participantList = simpleUserService.showByD_idS_id(participant,d_id,s_id);
        if (participantList!=null){
            model.addAttribute("participantList",participantList);
            return "test/simpleIndex";
        }else {
            model.addAttribute("participantList",participantList);
            return "test/simpleIndex";
        }
    }
    @RequestMapping("/simpleSearch")
    /*普通用户搜索*/
    public String findByPidName(String p_nameOrp_id,String d_id,Model model)throws Exception{
        List<Participant> participantList = simpleUserService.searchByPidNameD_id(p_nameOrp_id,d_id);
        if (participantList!=null){
            model.addAttribute("participantList",participantList);
            return "test/simpleIndex";
        }else {
            model.addAttribute("participantList",participantList);
            return "test/simpleIndex";
        }
    }
    //ajax调用根据返回的值判断输出什么 例如：返回true，弹出框投票成功
    @PostMapping("simpleUser/vote")
    @ResponseBody()
    public String simpleUserVote(SimpleUserCampaignDetail simpleUserCampaignDetail,HttpSession session,String su_id, String p_id, String s_id, String d_id)throws Exception{

        String YiTouName = simpleUserService.vote(simpleUserCampaignDetail, su_id, p_id, s_id, d_id);
        if(YiTouName==null){
            //投票成功
            return "1";
        }else {
            //用于页面提取已投票信息
            return YiTouName;
        }

    }
//    @RequestMapping("showByS_id")
//    //根据组织和职位显示
//    public  String showByD_idS_id(Participant participant,Model model)throws  Exception{
//        List<Participant> participantList = simpleUserService.showByD_idS_id(participant, participant.getD_id(), participant.getS_id());
//        model.addAttribute("participantList",participantList);
//        return "test/simpleIndex";
//    }

}
