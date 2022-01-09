package com.flyaway;

public class Booking {

	private String username;
	private String fullName;
	private int Age;
	private String contact;
	private String flightNo;
	private String travelDate;
	private int passenger;
	
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	
	public int getPassenger() {
		return passenger;
	}
	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
}

