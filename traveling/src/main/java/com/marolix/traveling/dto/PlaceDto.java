package com.marolix.traveling.dto;


import java.util.List;

import com.marolix.traveling.entity.Sub_place;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PlaceDto {

	private String name;
	private String location;
	private String distance;
	private String season;
	private String reason;
	
	private List<Sub_place> sub_places;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public List<Sub_place> getSub_places() {
		return sub_places;
	}

	public void setSub_places(List<Sub_place> sub_places) {
		this.sub_places = sub_places;
	}

	@Override
	public String toString() {
		return "PlaceDto [name=" + name + ", location=" + location + ", distance=" + distance + ", season=" + season
				+ ", reason=" + reason + ", sub_places=" + sub_places + "]";
	}

	public PlaceDto(String name, String location, String distance, String season, String reason,
			List<Sub_place> sub_places) {
		super();
		this.name = name;
		this.location = location;
		this.distance = distance;
		this.season = season;
		this.reason = reason;
		this.sub_places = sub_places;
	}

	public PlaceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
