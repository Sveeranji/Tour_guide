package com.marolix.traveling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Sub_PlaceDto {

	private String subplacename;
	   
	   private String distance;
	   
	   private String reason;

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
		return "Sub_PlaceDto [subplacename=" + subplacename + ", distance=" + distance + ", reason=" + reason + "]";
	}

	public Sub_PlaceDto(String subplacename, String distance, String reason) {
		super();
		this.subplacename = subplacename;
		this.distance = distance;
		this.reason = reason;
	}

	public Sub_PlaceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	   
	   
}
