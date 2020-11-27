package com.computer.campaign.controller;

import com.computer.campaign.pojo.Department;
import com.computer.campaign.pojo.Sort;
import com.computer.campaign.service.AdminUserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Mr.Huang
 * @create 2020-05-11 21:34
 */
@Controller
public class AdminController {
    @Autowired
    AdminUserService adminService;
    @RequestMapping("/adminShowAll")
    /*管理员界面显示全部信息（组织和竞选类别信息）*/
    public String showAllSepartment(Model model)throws Exception{
        List<Department> departmentList = adminService.showAllDepartment();
        List<Sort> sortList = adminService.showAllSort();
        model.addAttribute("sortList",sortList);
        model.addAttribute("departmentList",departmentList);
        return "test/adminIndex";

    }
    @PostMapping("/insertDepartment")
    /*添加组织信息*/
    public String insertDepartment(Integer level,Department department,Model model)throws Exception{
        if(adminService.insertDepartment(department,level)){
            model.addAttribute("msg","添加成功");
            return "forward:adminShowAll";
        }else {
            model.addAttribute("msg","添加失败");
            return "forward:adminShowAllDepartment";
        }

    }
    @PostMapping("insertSort")
    /*添加竞选类别信息*/
    public String insertSort(Sort sort)throws Exception{
        if(adminService.insert(sort)){
            return "redirect:adminShowAll";
        }else {
            return "redirect:adminShowAll";
        }

    }
    @GetMapping("updateSort")
    /*修改职位信息*/
    public String updateSort(Sort sort,String s_id)throws Exception{
        if (adminService.update(sort, s_id)){
            return "redirect:adminShowAll";
        }else {
            return "redirect:adminShowAll";
        }
    }
    @GetMapping("/deleteSort/{s_id}")
    /*删除组织*/
    public String deleteSort(@PathVariable("s_id") String s_id)throws Exception{
        if (adminService.delete(s_id)){
            return "redirect:adminShowAll";
        }else {
            return "redirect:adminShowAll";
        }
    }

}
