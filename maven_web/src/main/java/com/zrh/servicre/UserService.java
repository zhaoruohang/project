package com.zrh.servicre;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zrh.entity.Kfz;
import com.zrh.entity.Roles;
import com.zrh.entity.Users;

public interface UserService {

	public List<Users> getAll(String userName, String beginDate, String endDate, String isLock, Integer limit, Integer page);

	/*
	 * ����
	 */
	int getConut(String userName, String beginDate, String endDate, String isLock);

	/*
	 * ����
	 */
	int addUser(String id_a,String name_a,String pass_a,String suo_a,String CreateTime);

	/*
	 * ɾ��
	 */
	int deleteUser(String id);

	/*
	 * �޸�
	 */
	int updateUser(String id_e,String name_e,String pass_e,String email_e,String tel_e);
	int suo(String id,String isLock);
	int unsuo(String id,String isLock);
	int ressetPass(String id,String Pass);
	
	/*
	 * �����û�id���ɫ��
	 */
	public List<Kfz> getLeft();
	List<Kfz> getRight(String userId);
	/*
	 * ����û���ɫ
	 */
	public int addUserRoles(String uId,String rId);
	public int delUserRole(String uId,String rId);
	/*	  
	 * ����name���û�
	 * ����name�޸�����¼ʱ��
	 */
	Users login(String name,String pass);
	int updateLastTime(String name, String lastLoginTime);

	public List<Roles> getRolesByid(String uid);

	public List<String> getrname(List<Roles> rs);
}
