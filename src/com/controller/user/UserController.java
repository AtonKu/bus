//package com.controller.user;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import com.edu.entity.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.service.UserService;
//
//@Controller
//@RequestMapping("*")
//public class UserController {
//	@Resource
//	private UserService userService;
//	@RequestMapping("/user/login")
//	public String toLogin(String loginname, String password, String type, String code){
//		User user = userService.seleceUserByUserName(loginname);
//		System.out.println("-=====================");
//		return "";
//	}
//
//	/**
//	 * 用户登陆
//	 * @param userName 用户名
//	 * @param passWord 密码
//	 * @param roleType 用户角色类型 1：学生 2：老师  0：管理员
//	 * @return
//	 */
//	@RequestMapping("login")
//	@ResponseBody
//	public String login(String userName,String passWord,String roleType){
//		Map<String, Object> map = new HashMap<>();
//		map.put("userName", userName);
//		map.put("passWord", passWord);
//		map.put("roleType", roleType);
//		Map<String, Object> user = userService.selectUser(map);
//		if(user!=null && !user.isEmpty()){
//			return "0";
//		}else{
//			return "1";
//		}
//	}
//
//	/**
//	 * 注册
//	 * @param userName
//	 * @param passWord
//	 * @param roleType
//	 * @return
//	 */
//	@RequestMapping("registe")
//	@ResponseBody
//	public String registe(String userName,String passWord,String roleType){
//		Map<String, Object> map = new HashMap<>();
//		map.put("userName", userName);
//		map.put("passWord", passWord);
//		map.put("roleType", roleType);
//		int num = userService.saveUser(map);
//		if(num>0){
//			return "0";
//		}else{
//			return "1";
//		}
//	}
//
//
//
//
//
//
//
//
//}
