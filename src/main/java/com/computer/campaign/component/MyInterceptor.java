package com.computer.campaign.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr.Huang
 * @create 2020-04-29 11:35
 */

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object root = request.getSession().getAttribute("user_id");
        Object admin=request.getSession().getAttribute("user_name");
        if(root!=null || admin!=null){
            return true;
        }else{
            request.setAttribute("msg","请登录后执行操作");
            request.getRequestDispatcher("/toLogin").forward(request,response);
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
