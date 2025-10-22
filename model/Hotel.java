package com.codegnan.model;

public class Hotel {
	private int roomNo;
	private String floor;
	private String type;
	private double cost;
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(int roomNo, String floor, String type, double cost) {
		super();
		this.roomNo = roomNo;
		this.floor = floor;
		this.type = type;
		this.cost = cost;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Hotel [roomNo=" + roomNo + ", floor=" + floor + ", type=" + type + ", cost=" + cost + "]";
	}

}
