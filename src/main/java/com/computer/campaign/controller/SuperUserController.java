package com.computer.campaign.controller;

import com.computer.campaign.mapper.SystemMapper;
import com.computer.campaign.pojo.Department;
import com.computer.campaign.pojo.Participant;
import com.computer.campaign.pojo.Sort;
import com.computer.campaign.pojo.SuperUserCampaignDetail;
import com.computer.campaign.service.SuperUserService;
import com.computer.campaign.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-11 21:35
 */
@Controller
public class SuperUserController {
    @Autowired
    SuperUserService superUserService;
    @Autowired
    SystemService systemService;
    @RequestMapping("toIndex")
    public String toIndex(){
        return "test/superIndex";
    }


    @RequestMapping("showByD_id")
    public String findByD_id(Participant participant, Department department, Model model, HttpSession session){
        /*按组织查看竞选人*/
        List<Sort> sortList = systemService.showAllSort(department.getD_id());
        session.setAttribute("sortList",sortList);
        List<Participant> participantList = superUserService.showAllPartByD_id(participant,department.getD_id());
        model.addAttribute("participantList",participantList);
        session.setAttribute("d_id",department.getD_id());
        return "test/superIndex";
    }

    @PostMapping("superUser/vote")
    @ResponseBody
    //投票
    public String vote(SuperUserCampaignDetail superUserCampaignDetail)throws Exception{
       String YiTouName= superUserService.vote(superUserCampaignDetail, superUserCampaignDetail.getS_id(), superUserCampaignDetail.getSup_id(), superUserCampaignDetail.getP_id(), superUserCampaignDetail.getD_id());
        if(YiTouName==null) {
            //投票成功
            return "1";
        }else {
            //用于页面提取已投票信息
            return YiTouName;
        }

    }
    @RequestMapping("superSearch")
    //多功能搜索
    public String search(String p_nameOrp_id,Model model)throws Exception{
        List<Participant> participantList = superUserService.searchByPidName(p_nameOrp_id);
        model.addAttribute("participantList",participantList);
        return "test/superIndex";
    }
    @RequestMapping("showByD_idS_id")
    //根据组织和职位显示
    public  String showByD_idS_id(Participant participant,Model model)throws  Exception{
        List<Participant> participantList = superUserService.showAllPartsByD_idS_id(participant, participant.getD_id(), participant.getS_id());
        model.addAttribute("participantList",participantList);

        return "test/superIndex";
    }
}
