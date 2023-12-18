package com.marolix.traveling.service;

import java.util.List;

import com.marolix.traveling.dto.PlaceAndReviewDto;
import com.marolix.traveling.dto.PlaceDto;
import com.marolix.traveling.dto.ReviewDto;
import com.marolix.traveling.dto.Sub_PlaceDto;

public interface PlaceService {
	
  
	
	public ReviewDto addReviewDetails(ReviewDto dto,String name);
	
	public Sub_PlaceDto addSub_place(Sub_PlaceDto dto,String name);
	
	public PlaceAndReviewDto getAndRevieeDetails(String name);
	
	public List<PlaceDto> findAllPlaces();

	public PlaceDto addPlaceDetails(PlaceDto dto);
	
	
	public void deleteByName(String name);
	
	public void deleteSubPlace(String name);
	
	
}
