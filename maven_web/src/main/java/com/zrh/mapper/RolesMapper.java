package com.zrh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zrh.entity.Kfz;
import com.zrh.entity.Modules;
import com.zrh.entity.Roles;

public interface RolesMapper {
	/*
	 * 查询
	 */
	List<Roles> selectAllRoles(@Param("Name") String Name, @Param("limit") Integer limit, @Param("page") Integer page);

	/*
	 * 条数
	 */
	int getConutRoles(@Param("Name") String Name);
	/*
	 * 添加
	 */
	int addRoles(@Param("id")String id,@Param("name")String name);
	/*
	 * 删除
	 */
	int deleteRoles(@Param("id")String id);
	/*
	 * 修改
	 */
	int updateRoles(@Param("id")String id,@Param("name")String name);
	/*
	 * 角色权限增删改查
	 */
	//角色权限
		public List<Modules> getAllModulesByid(@Param("roleId")String roleId);
	int addrolemodules(@Param("mid")Integer mId, @Param("rid")String rId);
	int  delrolemodules(@Param("rid")String rId);
}
