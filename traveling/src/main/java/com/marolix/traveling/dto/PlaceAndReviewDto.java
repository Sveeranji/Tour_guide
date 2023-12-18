package com.marolix.traveling.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PlaceAndReviewDto {

	private PlaceDto place;
	
	
	
   private	List<ReviewDto> review;

public PlaceDto getPlace() {
	return place;
}

public void setPlace(PlaceDto place) {
	this.place = place;
}



public List<ReviewDto> getReview() {
	return review;
}

public void setReview(List<ReviewDto> review) {
	this.review = review;
}

@Override
public String toString() {
	return "PlaceAndReviewDto [place=" + place + ",  review=" + review + "]";
}

public PlaceAndReviewDto(PlaceDto place,  List<ReviewDto> review) {
	super();
	this.place = place;
	
	this.review = review;
}

public PlaceAndReviewDto() {
	super();
	// TODO Auto-generated constructor stub
}
   
  
}
