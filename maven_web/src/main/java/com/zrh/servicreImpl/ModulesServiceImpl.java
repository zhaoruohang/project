package com.zrh.servicreImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zrh.entity.Modules;
import com.zrh.entity.Roles;
import com.zrh.mapper.ModulesMapper;
import com.zrh.servicre.ModulesService;
@Service
public class ModulesServiceImpl implements ModulesService {
	@Resource(name="modulesMapper")
	private ModulesMapper modulesMapper;

	public List<Modules> getAllModules() {
		// TODO Auto-generated method stub
		return modulesMapper.getAllModules();
	}

	public int updateModulesById(Modules modules) {
		// TODO Auto-generated method stub
		return modulesMapper.updateModulesById(modules);
	}

	public int deleteModulesById(Integer id) {
		// TODO Auto-generated method stub
		return modulesMapper.deleteModulesById(id);
	}

	public int addModules(Modules modules) {
		// TODO Auto-generated method stub
		return modulesMapper.addModules(modules);
	}

	public Modules getAllModulesbyid(Integer id) {
		// TODO Auto-generated method stub
		return modulesMapper.getAllModulesbyid(id);
	}

	
	//根据用户id获得角色集合
	public List<Roles> getRolesByUseid(String uid) {
		// TODO Auo-generated method stub
		return modulesMapper.getRolesByUseid(uid);
	}

	public List<Modules> getModuleByroleid(List<String> rid) {
		// TODO Auto-generated method stub
		return modulesMapper.getModuleByroleid(rid);
	}



	
		

}
