package com.flyaway;

import java.sql.Time;
import java.util.Date;

public class Flight {

	private String name;
	private int price;
	private int number;
	private String source;
	private String destination;
	private Time sourceTime;
	private Time destinationTime;
	private int totalSeats;
	private int bookedSeats;
	private int seatAvailable;
	private Date date;
	private String classType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Time getSourceTime() {
		return sourceTime;
	}
	public void setSourceTime(Time sourceTime) {
		this.sourceTime = sourceTime;
	}
	public Time getDestinationTime() {
		return destinationTime;
	}
	public void setDestinationTime(Time destinationTime) {
		this.destinationTime = destinationTime;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	public int getSeatAvailable() {
		return seatAvailable;
	}
	public void setSeatAvailable(int seatAvaialable) {
		this.seatAvailable = seatAvaialable;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	
	
}