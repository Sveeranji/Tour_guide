package com.marolix.traveling.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Sub_place {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
	@Column(name = "FamousLocation",nullable = false)
   private String subplacename;
   
	@Column(name = "DistanceFromMainPlace",nullable = false)
   private String distance;
   
	@Column(name = "Reason",nullable = false)
   private String reason;
   
   

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getSubplacename() {
	return subplacename;
}

public void setSubplacename(String subplacename) {
	this.subplacename = subplacename;
}

public String getDistance() {
	return distance;
}

public void setDistance(String distance) {
	this.distance = distance;
}

public String getReason() {
	return reason;
}

public void setReason(String reason) {
	this.reason = reason;
}


@Override
public String toString() {
	return "Sub_place [id=" + id + ", subplacename=" + subplacename + ", distance=" + distance + ", reason=" + reason
			+  "]";
}

public Sub_place(Long id, String subplacename, String distance, String reason) {
	super();
	this.id = id;
	this.subplacename = subplacename;
	this.distance = distance;
	this.reason = reason;	
}

public Sub_place() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
}
