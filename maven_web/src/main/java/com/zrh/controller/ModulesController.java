package com.zrh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.zrh.entity.Modules;
import com.zrh.entity.ModulesDto;
import com.zrh.entity.Roles;
import com.zrh.servicre.ModulesService;
import com.zrh.util.ModuleCompator;
import com.zrh.util.ModulesDtoCompator;
import com.zrh.util.ModulesUtil;


@RestController
@Transactional
public class ModulesController {
	@Resource(name="modulesServiceImpl")
	private ModulesService modulesServiceImpl;
	 
	//判断子节点
	   public List<Object> pdChild(int id,List<Modules> list){
		   List<Object> m = new ArrayList<Object>();
		   for (Modules ls : list) {
			if(ls.getParentId()==id) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", ls.getId());
				map.put("title", ls.getName());
				map.put("parentId", ls.getParentId());
				//map.put("children", pdChild(ls.getId(), list));
				m.add(map);
			}
		}
		   return m;	   
	   }
	   //渲染数据
	   @RequestMapping("/getAllModules")
	   public List<Object> getAllModules(){
		List<Object> list = new ArrayList<Object>();
		List<Modules> modules = modulesServiceImpl.getAllModules();
		for (Modules m : modules) {
			Map<String, Object> map = new HashMap<String, Object>();
			if(m.getParentId()==0) {
				map.put("id", m.getId());
				map.put("title", m.getName());
				map.put("parentId", m.getParentId());
				map.put("children", pdChild(m.getId(), modules));
				list.add(map);
			}
		}
		   return list;   
	   }
	   //点击获取
	   @RequestMapping("/getAllModulesbyid")
	   public Map<String, Object> getAllModulesbyid(Integer id){
		   Modules m=modulesServiceImpl.getAllModulesbyid(id);
		   Map<String, Object> map = new HashMap<String, Object>();
		   map.put("success",true);
		   map.put("message", m);
		   return map;
	   }
	   //根据id修改节点名称
	   @RequestMapping("/updateModulesById")
	   public   Map<String, Object> updateModulesById(Modules modules) {
		 
		   int  a = modulesServiceImpl.updateModulesById(modules);
		   Map<String, Object> map = new HashMap<String, Object>();
		   if(a>0) {
			   map.put("success",true);
			   map.put("message", "修改成功");
			   }else { 
				   map.put("success",false);
				   map.put("message", "修改失败");
			   }
			   return map; 
	   }
	   //根据id删除节点
	   @RequestMapping("/deleteModulesById")
	   public  Map<String, Object> deleteModulesById(Integer d_id) {
		   int  a = modulesServiceImpl.deleteModulesById(d_id);
		   Map<String, Object> map = new HashMap<String, Object>();
		   if(a>0) {
		   map.put("success",true);
		   map.put("message", "刪除成功");
		   }else { 
			   map.put("success",false);
			   map.put("message", "刪除失败");
		   }
		   return map;   
	   }
	   @RequestMapping("/addModules")
	   public Map<String, Object> addModules(Modules modules) {
		   int  a = modulesServiceImpl.addModules(modules);
		   Map<String, Object> map = new HashMap<String, Object>();
		   if(a>0) {
		   map.put("success",true);
		   map.put("message", "添加成功");
		   }else { 
			   map.put("success",false);
			   map.put("message", "添加失败");
		   }
		   return map;    
	   }
	  
		
	   //登录显示
	   @RequestMapping("/Getindexmoudles")
	   public  List<Object> Getindexmoudles(String uid){
		  List<String> rid = new ArrayList<String>();
		 List<Roles> roles = modulesServiceImpl.getRolesByUseid(uid);
		   if(roles !=null && roles.size()>0){
			   for (int i = 0; i < roles.size(); i++) {	
		rid.add(roles.get(i).getId());
			   }  
		   }
		   //System.out.println(rid);
		   List<Modules> module  =modulesServiceImpl.getModuleByroleid(rid);
		   List<Object> list = new ArrayList<Object>(); 
		   for (Modules m: module) {
			   Map<String, Object> mapArr=new HashMap<String, Object>();
		          if(m.getParentId()==0){//判断是否为父极
		        	 // System.out.println(m.getName());
		            mapArr.put("id", m.getId()); 
		            mapArr.put("title", m.getName()); 
		            mapArr.put("children",menuChild(m.getId(),module));  //去子集查找遍历
		            list.add(mapArr); 
		          } 
		        } 
		return list;		   
	   }
	   public static List<Object> menuChild(int id,  List<Modules> s){ //子集查找遍历
	    	  List<Object> lists = new ArrayList<Object>(); 
	          for(Modules entry: s){ 
	            Map<String,Object> childArray = new HashMap<String, Object>(); 
	            if(entry.getParentId()==id ){ 
	              childArray.put("id", entry.getId()); 
	              childArray.put("title", entry.getName());
	              childArray.put("href", entry.getPath());
	              lists.add(childArray); 
	            } 
	          } 
	          return lists;
	      }
}
