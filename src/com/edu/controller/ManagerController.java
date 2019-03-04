package com.edu.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: ato
 * @Date: 2019/03/04 上午1:17
 */
@Controller
@RequestMapping("/manager/*")
public class ManagerController {

    @Resource
    private UserService userService;

    @RequestMapping("toStuMa")
    private String toStuMa(){
        return "student-manager";
    }

    @RequestMapping("stuManagers")
    @ResponseBody
    public JSONObject getStuManagePage(){
        JSONObject json = new JSONObject();
        List<Map<String, Object>> users = userService.selectUsersByRoleType(1);
        json.put("users", users);
        return json;
    }
}
