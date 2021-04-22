package com.pay;

public class Transaction
{
	public Transaction(int book_id, int client_id, int quantity) {
		super();
		this.book_id = book_id;
		this.client_id = client_id;
		this.quantity = quantity;
	}
	public Transaction() {
		super();
	}
	public Transaction(int book_id, String book_name, int client_id, String client_name, int quantity) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.client_id = client_id;
		this.client_name = client_name;
		this.quantity = quantity;
	}
	public Transaction(int id, int book_id, int client_id, int quantity) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.client_id = client_id;
		this.quantity = quantity;
	}
	public Transaction(int id, int book_id, String book_name, int client_id, String client_name, int quantity) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.book_name = book_name;
		this.client_id = client_id;
		this.client_name = client_name;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	protected int id;
	protected int book_id;
	protected String book_name;
	protected int client_id;
	protected String client_name;
	protected int quantity;
}
