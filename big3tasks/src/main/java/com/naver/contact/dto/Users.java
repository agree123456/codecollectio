package com.naver.contact.dto;



public class Users {
	private String  userid;
	private String  userpw;
	private String  name;
	private String  nickname;
	private String  address;
	private int 	phone;
	private String  email;
	private int 	birthday;
	
	public Users() {
	}

	public Users(String userid, String userpw) {
		super();
		this.userid = userid;
		this.userpw = userpw;
	}

	public Users(String userid, String userpw, String nickname) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.nickname = nickname;
	}

	public Users(String userid, String userpw, String name, String nickname, String address, int phone, String email,
			int birthday) {
		this.userid = userid;
		this.userpw = userpw;
		this.name = name;
		this.nickname = nickname;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
	}



	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}



//	@Override
//	public int hashCode() {
//		return Objects.hash(userid, userpw);
//	}



//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Users other = (Users) obj;
//		return Objects.equals(userid, other.userid) && Objects.equals(userpw, other.userpw);
//	}

}
