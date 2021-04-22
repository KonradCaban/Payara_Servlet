package com.pay;

public class Book 
{
	protected int id;
	public Book(int id, String title, String author, int catid, int quantity, int pubid, double price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.catid = catid;
		this.quantity = quantity;
		this.pubid = pubid;
		this.price = price;
	}
	protected String title;
	protected String author;
	public Book(String title, String author, int catid,  int pubid, double price,int quantity) {
		super();
		this.title = title;
		this.author = author;
		this.catid = catid;
		this.quantity = quantity;
		this.pubid = pubid;
		this.price = price;
	}
	protected int catid;
	protected String cat_name;
	protected int quantity;
	
	protected int pubid;
	protected String pub_name;
	public Book(String title, String author, int catid, String cat_name, int pubid, String pub_name, double price,int quantity) {
		super();
		this.title = title;
		this.author = author;
		this.catid = catid;
		this.cat_name = cat_name;
		this.pubid = pubid;
		this.pub_name = pub_name;
		this.price = price;
		this.quantity = quantity;
		
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Book(int id, String title, String author, int catid, String cat_name, int pubid, String pub_name,
			double price,int quantity) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.catid = catid;
		this.cat_name = cat_name;
		this.pubid = pubid;
		this.pub_name = pub_name;
		this.price = price;
		this.quantity = quantity;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public String getPub_name() {
		return pub_name;
	}
	public void setPub_name(String pub_name) {
		this.pub_name = pub_name;
	}
	protected double price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public int getPubid() {
		return pubid;
	}
	public void setPubid(int pubid) {
		this.pubid = pubid;
	}
	public double getprice() {
		return price;
	}
	public void setprice(double price) {
		this.price = price;
	}
}
