package com.regnant.jdbc;

public class Student {
	int id;
	String name;
	String mail;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getMail() {
		return mail;
	}
	public void setId(int id1) {
		this.id=id1;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setMail(String mail) {
		this.mail=mail;
	}
	public String toString() {
		return id+"  "+name+"  "+mail;
	}
}
