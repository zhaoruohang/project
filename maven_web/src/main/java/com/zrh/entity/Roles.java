package com.zrh.entity;

public class Roles {
     private String Id;
     private String Name;
     private Integer Int0;
     private String String0;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getInt0() {
		return Int0;
	}
	public void setInt0(Integer int0) {
		Int0 = int0;
	}
	public String getString0() {
		return String0;
	}
	public void setString0(String string0) {
		String0 = string0;
	}
	public Roles(String id, String name, Integer int0, String string0) {
		super();
		Id = id;
		Name = name;
		Int0 = int0;
		String0 = string0;
	}
	public Roles() {
		super();
	}
	@Override
	public String toString() {
		return "Roles [Id=" + Id + ", Name=" + Name + ", Int0=" + Int0 + ", String0=" + String0 + "]";
	}
	
     

}
