package org.recro.hotels.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Country table in database
 */
@Entity
@Table(name="Hotels")
public class Hotel{
	
	@Id
	@Column(name="hotel_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="hotel_name")
	String hotelName;
	
	@Column(name="city")
	String city;
	
	@Column(name="rooms_available")
	int roomsAvailable;
	
	@Column(name="phone_no")
	Long phoneNo;
	
	@Column(name="room_price")
	Long roomPrice;
	
	public Hotel() {
		super();
	}
	
	
	public Hotel(int id, String hotelName, String city, int roomsAvailable, Long phoneNo, Long roomPrice) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.city = city;
		this.roomsAvailable = roomsAvailable;
		this.phoneNo = phoneNo;
		this.roomPrice = roomPrice;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getRoomsAvailable() {
		return roomsAvailable;
	}
	public void setRoomsAvailable(int roomsAvailable) {
		this.roomsAvailable = roomsAvailable;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Long getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(Long roomPrice) {
		this.roomPrice = roomPrice;
	}
	
	
}