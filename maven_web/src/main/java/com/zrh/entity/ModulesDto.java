package com.zrh.entity;

public class ModulesDto {
private int id;
private String name;
private int parentId;
private String url;
private String ops ;
private int weight;
private int into;
private int isChecked;
private String state;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getParentId() {
	return parentId;
}
public void setParentId(int parentId) {
	this.parentId = parentId;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getOps() {
	return ops;
}
public void setOps(String ops) {
	this.ops = ops;
}
public int getWeight() {
	return weight;
}
public void setWeight(int weight) {
	this.weight = weight;
}
public int getInto() {
	return into;
}
public void setInto(int into) {
	this.into = into;
}
public int getIsChecked() {
	return isChecked;
}
public void setIsChecked(int isChecked) {
	this.isChecked = isChecked;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public ModulesDto(int id, String name, int parentId, String url, String ops, int weight, int into, int isChecked,
		String state) {
	super();
	this.id = id;
	this.name = name;
	this.parentId = parentId;
	this.url = url;
	this.ops = ops;
	this.weight = weight;
	this.into = into;
	this.isChecked = isChecked;
	this.state = state;
}
public ModulesDto() {
	super();
}
@Override
public String toString() {
	return "ModulesDto [id=" + id + ", name=" + name + ", parentId=" + parentId + ", url=" + url + ", ops=" + ops
			+ ", weight=" + weight + ", into=" + into + ", isChecked=" + isChecked + ", state=" + state + "]";
}


}
