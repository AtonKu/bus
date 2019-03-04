package com.edu.service;

import com.edu.dao.UserMapper;
import com.edu.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
	@Resource
	private UserMapper userDao;

	public Map<String, Object> selectUser(Map<String, Object> map) {
		Map<String, Object> user = userDao.selectUser(map);
		return user;
	}
	public int saveUser(Map<String, Object> map) {
		int num = userDao.saveUser(map);
		return num;
	}


	public User seleceUserByUserName(String loginname) {
		return userDao.seleceUserByUserName(loginname);
	}

	public int findNumsOfLoginName(String loginName) {
		return userDao.findNumsOfLoginName(loginName);
	}

	public void insertUser(User user) {
		userDao.insertUser(user);
	}

    public User seleceUserByParams(Map<String, Object> map) {
		return userDao.seleceUserByParams(map);
    }

	public List<Map<String, Object>> selectUsersByRoleType(int type) {
		return userDao.selectUsersByRoleType(type);
	}
}
