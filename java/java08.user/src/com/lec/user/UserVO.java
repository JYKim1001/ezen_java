package com.lec.user;

public class UserVO {
	
	private String id;
	private String name;
	private String tel;
	private int ssn;
	
	
	public UserVO() {
		this.id = null;
		this.name = null;
		this.tel = null;
		this.ssn = 0;
		
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public int getSsn() {
		return ssn;
	}


	public void setSsn(int ssn) {
		this.ssn = ssn;
	}


	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", tel=" + tel + ", ssn=" + ssn + "]";
	}


	
	
}
