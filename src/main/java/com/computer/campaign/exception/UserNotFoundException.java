package com.computer.campaign.exception;

/**
 * @author Mr.Huang
 * @create 2020-05-02 11:24
 */
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("信息不存在");
    }
}
