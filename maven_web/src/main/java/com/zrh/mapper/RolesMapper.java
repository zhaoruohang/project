package com.zrh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zrh.entity.Kfz;
import com.zrh.entity.Modules;
import com.zrh.entity.Roles;

public interface RolesMapper {
	/*
	 * ��ѯ
	 */
	List<Roles> selectAllRoles(@Param("Name") String Name, @Param("limit") Integer limit, @Param("page") Integer page);

	/*
	 * ����
	 */
	int getConutRoles(@Param("Name") String Name);
	/*
	 * ���
	 */
	int addRoles(@Param("id")String id,@Param("name")String name);
	/*
	 * ɾ��
	 */
	int deleteRoles(@Param("id")String id);
	/*
	 * �޸�
	 */
	int updateRoles(@Param("id")String id,@Param("name")String name);
	/*
	 * ��ɫȨ����ɾ�Ĳ�
	 */
	//��ɫȨ��
		public List<Modules> getAllModulesByid(@Param("roleId")String roleId);
	int addrolemodules(@Param("mid")Integer mId, @Param("rid")String rId);
	int  delrolemodules(@Param("rid")String rId);
}
