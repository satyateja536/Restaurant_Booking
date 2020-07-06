package com.ucmo.restaurant.dto;

public class RestaurantDTO {
	
	private int restaurantID;
	private String restaurantName;
	private String city;
	private String address;
	private int costPerTwo;
	private float rating;
	
	
	public int getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}	
	public int getCostPerTwo() {
		return costPerTwo;
	}
	public void setCostPerTwo(int costPerTwo) {
		this.costPerTwo = costPerTwo;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

}
