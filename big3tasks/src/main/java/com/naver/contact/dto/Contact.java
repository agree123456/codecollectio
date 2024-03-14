package com.naver.contact.dto;

import java.sql.Date;

public class Contact {
	private int 	member_id;	
	private String  name;
	private String  address;
	private int 	phone;
	private int 	groups_id;
	private String  email;
	private Date 	birthday;	
	private String 	regdt;
	private String  groups_name;
	
	//디폴트 생성자
	public Contact() {
	}

	//get set
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getGroups_id() {
		return groups_id;
	}

	public void setGroups_id(int groups_id) {
		this.groups_id = groups_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegdt() {
		return regdt;
	}

	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}

	public String getGroups_name() {
		return groups_name;
	}

	public void setGroups_name(String groups_name) {
		this.groups_name = groups_name;
	}

	@Override
	public String toString() {
		return "Contact [member_id=" + member_id + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", groups_id=" + groups_id + ", email=" + email + ", birthday=" + birthday + ", regdt=" + regdt
				+ ", groups_name=" + groups_name + "]";
	}

	
	
	
	
}
	