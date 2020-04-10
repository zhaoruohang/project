package com.zrh.servicreImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.zrh.entity.Kfz;
import com.zrh.entity.Roles;
import com.zrh.entity.Users;
import com.zrh.mapper.UserMapper;
import com.zrh.servicre.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Resource(name="userMapper")
private UserMapper userMapper;
	
	public List<Users> getAll(String userName, String beginDate, String endDate, String isLock, Integer limit,
			Integer page) {
		// TODO Auto-generated method stub
		return userMapper.selectAll(userName,beginDate, endDate, isLock,limit, page);
	}
	public int getConut(String userName, String beginDate, String endDate, String isLock) {
		// TODO Auto-generated method stub
		return userMapper.getConut(userName,beginDate, endDate, isLock);
	}
	/*
	 * 添加
	 * */
	public int addUser(String id_a,String name_a,String pass_a,String suo_a ,String CreateTime) {
		// TODO Auto-generated method stub
		
		return userMapper.add( id_a, name_a, pass_a, suo_a, CreateTime );
	}
	/*
	 * shanchu
	 * */
	public int deleteUser(String id) {
		// TODO Auto-generated method stub
		return userMapper.delete(id);
	}
	/*
	 * 修改
	 * */
	public int updateUser(String id_e, String name_e, String pass_e, String email_e, String tel_e) {
		// TODO Auto-generated method stub
		return userMapper.update(id_e, name_e, pass_e, email_e, tel_e);
	}
	/*
	 * shangsuo1
	 * */
	public int suo(String id, String isLock) {
		// TODO Auto-generated method stub
		return userMapper.suo(id, isLock);
	}
	/*
	 * 解锁
	 * */
	public int unsuo(String id, String isLock) {
		// TODO Auto-generated method stub
		return userMapper.unsuo(id, isLock);
	}
	/*
	 * 重密
	 * */
	public int ressetPass(String id, String Pass) {
		// TODO Auto-generated method stub
		return userMapper.ressetPass(id, Pass);
	}
	/*
	 * 用户角色
	 * */
	
	public List<Kfz> getLeft() {
		// TODO Auto-generated method stub
		return userMapper.getLeft();
	}
	public List<Kfz> getRight(String userId) {
		// TODO Auto-generated method stub
		return userMapper.getRight(userId);
	}
	/*
	 * 添加用户角色
	 */
	public int addUserRoles(String uId,String rId) {
	
		return userMapper.addUserRoles(uId,rId);
	}
	/*
	 * 删除用户角色
	 */
	public int delUserRole(String uId, String rId) {
		// TODO Auto-generated method stub
		return userMapper.delUserRole(uId, rId);
	}
	/*
	 * 登录
	 */
	public Users login(String name, String pass) {
		// TODO Auto-generated method stub
		return userMapper.login(name, pass);
	}
	public int updateLastTime(String name, String lastLoginTime) {
		// TODO Auto-generated method stub
		return userMapper.updateLastTime(name,lastLoginTime);
	}
	public List<Roles> getRolesByid(String uid) {
		// TODO Auto-generated method stub
		return userMapper.getRolesByUserid(uid);
	}
	public List<String> getrname(List<Roles> rs) {
		// TODO Auto-generated method stub
		List<String> ls= new ArrayList<String>();
		for (int i = 0; i < rs.size(); i++) {
			ls.add(rs.get(i).getName());
		}
		return ls;
	}
}
