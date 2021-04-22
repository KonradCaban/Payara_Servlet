package com.pay;

public class Publisher 
{
 protected int id;
 protected String pub_name;
 public Publisher() {
	super();
}
public Publisher(int id, String pub_name) {
	super();
	this.id = id;
	this.pub_name = pub_name;
}
public Publisher(String pub_name) {
	super();
	this.pub_name = pub_name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPub_name() {
	return pub_name;
}
public void setPub_name(String pub_name) {
	this.pub_name = pub_name;
}

 
}
