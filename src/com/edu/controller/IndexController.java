package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ato
 * @Date: 2019/03/03 下午10:14
 */
@Controller
@RequestMapping("*")
public class IndexController {

    @RequestMapping("index")
    public String index(int type) {
        if (type==1) {
            return "student-index";
        } else if (type==2) {
            return "teacher-index";
        } else {
            return "index";
        }
    }

}
