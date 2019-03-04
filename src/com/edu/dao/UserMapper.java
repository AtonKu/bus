package com.edu.dao;

import java.util.List;
import java.util.Map;

import com.edu.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

	public int saveUser(Map<String, Object> map) ;

	public Map<String, Object> selectUser(Map<String, Object> map);

	public List<Map<String, Object>> selectListBusStop();

	public int delBusStop(String id);

	public int updateBusStop(Map<String, Object> id);

	public void addBusStop(String name);


	User seleceUserByUserName(String loginname);

	int findNumsOfLoginName(String loginName);

	void insertUser(User user);

	User seleceUserByParams(Map<String, Object> map);

    List<Map<String, Object>> selectUsersByRoleType(int type);
}
