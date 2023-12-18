package com.marolix.traveling.serviceimp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marolix.traveling.Reposistry.PlaceReposistry;
import com.marolix.traveling.Reposistry.ReviewReposistry;
import com.marolix.traveling.Reposistry.Sub_PlaceReposistry;
import com.marolix.traveling.dto.PlaceAndReviewDto;
import com.marolix.traveling.dto.PlaceDto;
import com.marolix.traveling.dto.ReviewDto;
import com.marolix.traveling.dto.Sub_PlaceDto;
import com.marolix.traveling.entity.Place;
import com.marolix.traveling.entity.Reviews;
import com.marolix.traveling.entity.Sub_place;
import com.marolix.traveling.execpetion.UserNotFoundExecption;
import com.marolix.traveling.service.PlaceService;

@Service
public class PlaceServiceImp implements PlaceService{

	@Autowired
	private PlaceReposistry placeReposistry;
	
	@Autowired
	private ReviewReposistry reviewReposistry;
	
	@Autowired
	private Sub_PlaceReposistry sub_PlaceReposistry;
	

	@Override
	public PlaceDto addPlaceDetails(PlaceDto dto)  {
		Place place=new Place();
		
		place.setName(dto.getName());
		place.setLocation(dto.getLocation());
		place.setDistance(dto.getDistance());
		place.setSeason(dto.getSeason());
		place.setReason(dto.getReason());
		place.setSub_places(dto.getSub_places());
		placeReposistry.save(place);
		return dto;
	}

	@Override
	public ReviewDto addReviewDetails(ReviewDto dto,String name) {
		Optional<Place> optionalPlace = Optional.ofNullable(placeReposistry.findByName(name));
		 if (optionalPlace.isPresent()) {
	        Place place = optionalPlace.get();
		Reviews reviews=new Reviews();
		reviews.setText(dto.getText());
		reviews.setNum(dto.getNum());
		reviews.setPlace(place);
		 reviewReposistry.save(reviews);
		 return dto;
		 }
		 else {
			throw new UserNotFoundExecption("Place not found with name: " + name);
		}
	}

	@Override
	public PlaceAndReviewDto getAndRevieeDetails(String name) {
		 Place place = placeReposistry.findByName(name);
	        if (place != null) {
	            List<Reviews> list = reviewReposistry.findByPlace(place);

	            PlaceDto placeDTO = new PlaceDto();
	            placeDTO.setName(place.getName());
	            placeDTO.setLocation(place.getLocation());
	            placeDTO.setDistance(place.getDistance());
	            placeDTO.setSub_places(place.getSub_places());
	            List<ReviewDto> reviewDTOs = list.stream()
	            		.map( review -> {
	                        ReviewDto reviewDTO = new ReviewDto();
	                        reviewDTO.setText(review.getText());
	                        reviewDTO.setNum(review.getNum());
	                        return reviewDTO;
	                    }) .collect(Collectors.toList());
	           
	            PlaceAndReviewDto placeReviewDTO = new PlaceAndReviewDto();
	            placeReviewDTO.setPlace(placeDTO);
	            placeReviewDTO.setReview(reviewDTOs);
	           
	            return placeReviewDTO;
	        } else {
	            throw new UserNotFoundExecption("Place not found with name: " + name);
	        }
	    }

	@Override
	public Sub_PlaceDto addSub_place(Sub_PlaceDto dto, String name) {
		Optional<Place>optional=Optional.ofNullable(placeReposistry.findByName(name));
		if(optional.isPresent())
		{
			Place place=optional.get();
			Sub_place sub_place=new Sub_place();
			sub_place.setSubplacename(dto.getSubplacename());
			sub_place.setDistance(dto.getDistance());
			sub_place.setReason(dto.getReason());
			sub_PlaceReposistry.save(sub_place);
			return dto;
		}
		else {
			throw  new UserNotFoundExecption("Place not found with name: " + name); 
		}
	}

	

	@Override
	public List<PlaceDto> findAllPlaces() {
		List<Place> places=placeReposistry.findAll();
		
		return places.stream().map(place->new PlaceDto(place.getName() ,place.getLocation(),place.getDistance(),place.getSeason(),place.getReason(),place.getSub_places())).collect(Collectors.toList());
	}



	@Override
	public void deleteByName(String name) {
		Optional<Place> optional=Optional.ofNullable(placeReposistry.findByName(name));
		
		if(optional .isPresent())
		{
			Place place=optional.get();
			placeReposistry.delete(place);
		}
		else {
			throw  new UserNotFoundExecption("Place not found with name: " + name); 
		}
		
	}

	@Override
	public void deleteSubPlace(String name) {
		Optional<Sub_place> optional=Optional.ofNullable(sub_PlaceReposistry.findBySubplacename(name));
		
		if(optional .isPresent())
		{
			Sub_place sub_place=optional.get();
			sub_PlaceReposistry.delete(sub_place);
			
		}
		else {
			throw  new UserNotFoundExecption("Place not found with name: " + name); 
		}
	}

	
	
	
}
