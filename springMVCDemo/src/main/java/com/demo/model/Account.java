package com.demo.model;



public class Account {
	
	//@Size(min=5, max=10)
	private String firstName;
	
	//@Size(min=5, max=10)
	private String lastName;
	
	//@Size(min=5, max=100)
	private String address;
	
	//@Email
	private String email;
	
	//@NotNull @Min(15)
	private int age = 15;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
