package com.zrh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.zrh.entity.Kfz;
import com.zrh.entity.Modules;
import com.zrh.entity.Roles;
import com.zrh.servicre.RolesService;
import com.zrh.util.Result;

@RestController
@Transactional
public class RolesController {
	@Resource(name = "rolesServiceImpl")
	private RolesService rolesServiceImpl;

	@RequestMapping("/getRoles")
	public String getRoles(String Name, Integer limit, Integer page) {
		int page1 = (page - 1) * limit;
		List<Roles> r = rolesServiceImpl.getAllModules(Name, limit, page1);
		int count = rolesServiceImpl.getConutModules(Name);
		String dd = Result.toClient("0", "", count, r);
		return dd;
	}

	/*
	 * 添加
	 */
	@PostMapping("/addRole")
	public String addR(String id_a, String name_a) {
		int a = rolesServiceImpl.addRoles(id_a, name_a);
		String dd = null;
		if (a != 0) {
			dd = Result.toClient("0", "添加成功");
		} else {
			dd = Result.toClient("1", "添加失败");
		}
		return dd;
	}

	/*
	 * 删除
	 */
	@RequestMapping("/deleteRole")
	public String deleteR(String id_d) {
		int a = rolesServiceImpl.deleteRoles(id_d);
		String dd = null;
		if (a != 0) {
			dd = Result.toClient("0", "删除成功");
		} else {
			dd = Result.toClient("1", "删除失败");
		}
		return dd;

	}

	/*
	 * 修改
	 */
	@RequestMapping("/upateRole")
	public String updateR(String id_e, String name_e) {
		int a = rolesServiceImpl.updateRoles(id_e, name_e);
		String dd = null;
		if (a != 0) {
			dd = Result.toClient("0", "修改成功");
		} else {
			dd = Result.toClient("1", "修改失败");
		}
		return dd;
	}
	
	 //获得初始化选中
	   @RequestMapping("/getrolemodulesByid")
		public List<Object> getrolemodulesByid(String RoleId) {
		   List<Object> list = new ArrayList<Object>();
			List<Modules> modules = rolesServiceImpl.getAllModulesByid(RoleId);
			for (Modules m : modules) {
				Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", m.getId());
						list.add(map);
			}
			   return list;   
		   }

	

	/*
	 * 用户删除权限
	 **/
	@RequestMapping("/delrolemodules")
	public Map<String, Object> delrolemodules(String rId1) {
		System.out.println(rId1);
			  rolesServiceImpl.delrolemodules(rId1);
		
		
	return null;	
	}
	/*
	 * 角色添加权限
	 **/
	@RequestMapping("/addrolemodules")	
	public Map<String, Object> addrolemodules(@RequestParam(value ="mids",required = false) String mids  , String RoleId) {
		
		String[] arr  =mids.split(",");
		int n=0;
		 for (int i = 0; i < arr.length; i++) {
		 n =	 rolesServiceImpl.addrolemodules(Integer.parseInt(arr[i]),RoleId);
		 }
		 Map<String, Object> map = new HashMap<String, Object>();
		if(n>0) {
			map.put("code",0);
		}
		return map;	
		}
}
