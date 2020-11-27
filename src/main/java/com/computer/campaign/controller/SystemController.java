package com.computer.campaign.controller;

import com.computer.campaign.mapper.SystemMapper;
import com.computer.campaign.pojo.Department;
import com.computer.campaign.pojo.P_nameP_poll;
import com.computer.campaign.pojo.Participant;
import com.computer.campaign.service.SuperUserService;
import com.computer.campaign.service.SystemService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * @author Mr.Huang
 * @create 2020-05-14 17:19
 */
@Controller
public class SystemController {
    @Autowired
   SystemService systemService;

//    @RequestMapping("showByD_id")
//    public String findByD_id(Participant participant, Department department, Model model, HttpSession session){
//        /*按组织查看竞选人*/
//        List<Participant> participantList = superUserService.showAllPartByD_id(participant,department.getD_id());
//        model.addAttribute("participantList",participantList);
//        session.setAttribute("d_id",department.getD_id());
//        return "test/superIndex";
//    }

    @RequestMapping("showPartByP_id/{p_id}")
    //显示个人详细
    public String showPartByP_id(@PathVariable("p_id") String p_id, Model model)throws Exception{
        Participant participant= systemService.showByP_id(p_id);
        model.addAttribute("participant",participant);
        return "test/participantFull";
    }
    @RequestMapping("/showAllPoll")
    @ResponseBody
    public List<P_nameP_poll> showAllP_poll(String d_id,String s_id)throws Exception{
        List<P_nameP_poll> p_nameP_polls = systemService.p_pollByD_idS_id(d_id,s_id);
        //向页面传递该职位该职位总票数
        return p_nameP_polls;
    }
}
