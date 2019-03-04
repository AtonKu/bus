package com.edu.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.entity.User;
import com.edu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ato
 * @Date: 2019/03/03 下午11:49
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Resource
    private UserService userService;

    @RequestMapping("/toRegister")
    public String loadRegister(){
        return "register";
    }

    @RequestMapping("/doRegister")
    @ResponseBody
    public Object toRegister(String loginname, String password, Integer type){
        JSONObject json = new JSONObject();
        int count = userService.findNumsOfLoginName(loginname);
        if (count>0) {
            json.put("flag", 1);
            json.put("msg", "用户名已存在！");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            User user = new User();
            user.setUserName(loginname);
            user.setPassWord(password);
            user.setCreateTime(sdf.format(System.currentTimeMillis()));
            user.setIdDel(0);
            user.setRoleType(type);
            userService.insertUser(user);
            json.put("flag", 0);
            json.put("msg", "注册成功！");
        }
        return json;
    }
}
