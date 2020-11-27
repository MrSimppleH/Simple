package com.computer.campaign.exception;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Huang
 * @create 2020-05-02 12:11
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
        public  String handlerException(Exception e, HttpServletRequest request){
            Map<String,Object> map=new HashMap<>();
            request.setAttribute("javax.servlet.error.status_code",500);
            //设置错误代码让error内的
   // ErrorMvcAutoConfiguration->BasicErrorController extends AbstractErrorController的getStatus(HttpServletRequest request)方法接收到错误代码
            map.put("node","user.not exit");
            map.put("messageErrorAttribute","用户不存在(消息来自自定义异常处理器MyExceptionHandler)");
            request.setAttribute("exc",map);
            return "forward:/error";
        //这个error不是template模板是errorMVCAutoConfiguration的请求处理，在这里进行客户端和浏览器的返回类型
        }
}
