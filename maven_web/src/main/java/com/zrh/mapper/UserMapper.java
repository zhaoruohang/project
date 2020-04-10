package com.zrh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zrh.entity.Kfz;
import com.zrh.entity.Roles;
import com.zrh.entity.Users;

public interface UserMapper {
	/*
	 * cha
	 */

	List<Users> selectAll(@Param("userName") String userName, @Param("beginDate") String beginDate,
			@Param("endDate") String endDate, @Param("isLock") String isLock, 
			@Param("limit") Integer limit, @Param("page") Integer page);

	/*
	 * 条数
	 */
	int getConut(@Param("userName") String userName, @Param("beginDate") String beginDate, @Param("endDate") String endDate,
			@Param("isLock") String isLock);

	/*
	 * 添加
	 */
	int add(@Param("id")String id_a,@Param("name")String name_a,@Param("pass")String pass_a,@Param("suo")String suo_a ,@Param("CreateTime")String CreateTime);

	/*
	 * 删除
	 */
	int delete(@Param("id")String id);

	/*
	 * 修改
	 */
	int update(@Param("id_e")String id_e,@Param("name_e")String name_e,@Param("pass_e")String pass_e,@Param("email_e")String email_e,@Param("tel_e")String tel_e);
int suo(@Param("id")String id,@Param("onsuo")String isLock);
int unsuo(@Param("id")String id,@Param("unsuo")String isLock);
int ressetPass(@Param("id")String id,@Param("resetPass")String Pass);

/*
 * 用户角色增删改查
 */
List<Kfz> getLeft();
List<Kfz> getRight(@Param("userId")String userId);

int addUserRoles(@Param("uid")String uId, @Param("rid")String rId);
int  delUserRole(@Param("uid")String uId, @Param("rid")String rId);

/*
 * 登录
 */
Users login(@Param("name")String name,@Param("pass")String pass);
int updateLastTime(@Param("name")String name,@Param("lastLoginTime") String lastLoginTime);

List<Roles> getRolesByUserid(@Param("uid")String uid);
}
