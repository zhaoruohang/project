package com.zrh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zrh.entity.Modules;
import com.zrh.entity.Roles;

public interface ModulesMapper {
	//��ɾ�Ĳ�
	  public List<Modules> getAllModules();
	  public Modules getAllModulesbyid(@Param("id")Integer id);
	   public int updateModulesById(Modules modules);
	   public int deleteModulesById(@Param("id")Integer id);
	   public int addModules(Modules modules);
	   
	   //ҳ�浼����
	public List<Roles> getRolesByUseid(@Param("UserId")String uid);
	public List<Modules> getModuleByroleid(List<String> rid);
	
}
