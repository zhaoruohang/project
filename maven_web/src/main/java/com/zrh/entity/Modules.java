package com.zrh.entity;

public class Modules {
	
	private   Integer Id;
	private   String Name;
	private   Integer   ParentId;
	private   String   Path;
	private   Integer   Weight;
	private   String  Ops;
	private   Integer   Int0;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getParentId() {
		return ParentId;
	}
	public void setParentId(Integer parentId) {
		ParentId = parentId;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public Integer getWeight() {
		return Weight;
	}
	public void setWeight(Integer weight) {
		Weight = weight;
	}
	public String getOps() {
		return Ops;
	}
	public void setOps(String ops) {
		Ops = ops;
	}
	public Integer getInt0() {
		return Int0;
	}
	public void setInt0(Integer int0) {
		Int0 = int0;
	}
	public Modules(Integer id, String name, Integer parentId, String path, Integer weight, String ops, Integer int0) {
		super();
		Id = id;
		Name = name;
		ParentId = parentId;
		Path = path;
		Weight = weight;
		Ops = ops;
		Int0 = int0;
	}
	public Modules() {
		super();
	}
	@Override
	public String toString() {
		return "modules [Id=" + Id + ", Name=" + Name + ", ParentId=" + ParentId + ", Path=" + Path + ", Weight="
				+ Weight + ", Ops=" + Ops + ", Int0=" + Int0 + "]";
	}
	
} 
