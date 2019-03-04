package com.edu.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.entity.User;
import com.edu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:
 * @Date:
 */
@Controller
@RequestMapping("/login/*")
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("doLogin")
    @ResponseBody
    public JSONObject doLogin(String loginname, String password, Integer type){
        JSONObject json = new JSONObject();
        Map<String, Object> map = new HashMap<>();
        map.put("loginname", loginname);
        map.put("password", password);
        map.put("type", type);
        User user = userService.seleceUserByParams(map);
        if (user!=null) {
            json.put("flag", 0);
            json.put("msg", "登陆成功");
            json.put("userName", user.getUserName());
            return json;
        } else {
            json.put("flag", 1);
            json.put("msg", "用户不存在");
            return json;
        }

    }

}
