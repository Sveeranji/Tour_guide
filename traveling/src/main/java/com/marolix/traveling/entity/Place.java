package com.marolix.traveling.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Place_Table")
public class Place {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "placeName",nullable = false)
	private String name;
	@Column(name = "Location",nullable = false)
	private String location;
	@Column(name = "Distance",nullable = false)
	private String distance;
	@Column(name = "Season",nullable = false)
	private String season;
	@Column(name = "Reason",nullable = false)
	private String reason;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Sub_place.class)
	@JoinColumn(name = "s_id",referencedColumnName = "id")
    private List<Sub_place>sub_places;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return "Place [id=" + id + ", name=" + name + ", location=" + location + ", distance=" + distance + ", season="
				+ season + ", reason=" + reason + ", sub_places=" + sub_places + "]";
	}

	public Place(Long id, String name, String location, String distance, String season, String reason,
			List<Sub_place> sub_places) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.distance = distance;
		this.season = season;
		this.reason = reason;
		this.sub_places = sub_places;
	}

	public Place() {
		super();
		// TODO Auto-generated constructor stub
	}

	
   
	
	
}
