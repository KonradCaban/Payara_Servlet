package com.pay;

public class Category {
	protected int id;
	public Category(String category_name) {
		super();
		this.category_name = category_name;
	}
	protected String category_name;
	public int getId() {
		return id;
	}
	public Category(int id, String category_name) {
		super();
		this.id = id;
		this.category_name = category_name;
	}
	public Category() {
		super();
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
}
