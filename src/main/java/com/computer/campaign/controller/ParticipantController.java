package com.computer.campaign.controller;

import com.computer.campaign.pojo.Participant;
import com.computer.campaign.pojo.Sort;
import com.computer.campaign.service.ParticipantService;
import com.computer.campaign.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-16 15:56
 */
@Controller
public class ParticipantController {
    @Autowired
    SystemService systemService;
    @Autowired
    ParticipantService participantService;
    @PostMapping("/checkContend")
    @ResponseBody
    /*检测是否参与过竞选*/
    public String checkContend(String su_id)throws Exception{
       Participant participant = participantService.judge(su_id);//返回竞选信息
        if(participant!=null) {
             String s_name=participant.getSort().getS_name();
           return s_name;
       }else {
            return "1";
        }
    }
    @RequestMapping("/participantPage")
    /*跳转竞选页面*/
    public String toParticipantPage( )throws Exception{
            return "test/participant";
    }
    @PostMapping("/contend")
    /*竞选*/
    public String contend(Participant participant,String d_id)throws Exception{
        //
       Participant participant1 = participantService.checkParticipantFile(participant);//封装文件存储路径的竞选者信息
       participantService.contend(participant1,d_id);//录入竞选信息
        return "redirect:/showAllBy_id";


    }
}
