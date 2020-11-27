package com.computer.campaign.config;


import com.computer.campaign.component.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Mr.Huang
 * @create 2020-04-28 19:55
 */
//WebMvcConfigurerAdapter可以拓展SpringMvc的功能
    //@enablewebmvc 不要就干springmvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean//将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            public void addViewControllers(ViewControllerRegistry registry){
                //super.ddViewControllers(registry)'
                //浏览器发送/atguigu请求到success
               registry.addViewController("/").setViewName("test/login");
//                registry.addViewController("/login.html").setViewName("login");
            }
//注册拦截器
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").
                      excludePathPatterns("/","/toAdminPage","/toAdminLogin","/simpleUserLogin","/superUserLogin"
                              ,"toAdminPage","toAdminLogin","simpleUserLogin","superUserLogin","/选择进入哪个选票系统","/login","/checksu_id","/toLogin","/register","/toRegister");

            }
        };
        return adapter;
    }


}

