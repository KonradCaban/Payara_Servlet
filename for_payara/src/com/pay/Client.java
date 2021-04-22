package com.pay;

public class Client
{
	private int id;
	private String name;
	private String surname;
	private String city;
	private String adress;
	private String phone;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Client(int id, String name, String surname, String city, String adress, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.adress = adress;
		this.phone = phone;
	}
	public Client(String name, String surname, String city, String adress, String phone) {
		super();
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.adress = adress;
		this.phone = phone;
	}
	public Client() {
		super();
	}
	
	
}
