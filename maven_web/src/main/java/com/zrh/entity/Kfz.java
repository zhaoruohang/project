package com.zrh.entity;

public class Kfz {
private String value;
private String title;
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Kfz(String value, String title) {
	super();
	this.value = value;
	this.title = title;
}
public Kfz() {
	super();
}
@Override
public String toString() {
	return "Kfz [value=" + value + ", title=" + title + "]";
}


}
