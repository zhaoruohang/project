package com.zrh.servicre;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zrh.entity.Kfz;
import com.zrh.entity.Modules;
import com.zrh.entity.Roles;

public interface RolesService {
  
	public List<Roles> getAllModules(String Name,Integer limit,Integer page);
	/*
	 * 角色增删改查
	 * */
		int getConutModules(String Name);
		int addRoles(String id,String name);
		int deleteRoles(String id);
		int updateRoles(String id,String name);
		/*
		 * 角色权限增删改查
		 */
		//角色权限树
				public List<Modules> getAllModulesByid(String roleId);
		int addrolemodules(Integer mId, String rId);
		int  delrolemodules(String rId);
}
