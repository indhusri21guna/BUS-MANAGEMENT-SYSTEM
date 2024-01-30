package com.mkce.springbootbasics;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bus_details")
public class Bus {

	@Override
	public String toString() {
		return "Student [bus_id=" + bus_id + ", source_location=" + source_location + ", dest_location=" + dest_location + ", bus_fare=" + bus_fare + "]";
	}
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bus(Long bus_id, String source_location, String dest_location, int bus_fare) {
		super();
		this.bus_id = bus_id;
		this.source_location = source_location;
		this.dest_location = dest_location;
		this.bus_fare = bus_fare;
	}
	@Id
	private Long bus_id;
	public Long getBus_id() {
		return bus_id;
	}
	public void setBus_id(Long bus_id) {
		this.bus_id = bus_id;
	}
	public String getsource_location() {
		return source_location;
	}
	public void setsource_location(String source_location) {
		this.source_location = source_location;
	}
	public String getdest_location() {
		return dest_location;
	}
	public void setdest_location(String dest_loc) {
		this.dest_location= dest_location;
	}
	public int getbus_fare() {
		return bus_fare;
	}
	public void setbus_fare(int bus_fare ) {
		this.bus_fare = bus_fare;
	}
	private String source_location ;
	private String dest_location;
	private int  bus_fare;
	
}
