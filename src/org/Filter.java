package org;
@TableAnnotation("filter")
public class Filter {
	@FieldAnnotation("ID")
	private int id;
	@FieldAnnotation("userName")
	private String userName;
	@FieldAnnotation("nickName")
	private String nickName;
	@FieldAnnotation("age")
	private int age;
	@FieldAnnotation("city")
	private String city;
	@FieldAnnotation("email")
	private String email;
	@FieldAnnotation("mobile")
	private String mobile;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
