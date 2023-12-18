package com.marolix.traveling.controller;

import java.io.IOException ;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marolix.traveling.dto.PlaceAndReviewDto;
import com.marolix.traveling.dto.PlaceDto;
import com.marolix.traveling.dto.ReviewDto;
import com.marolix.traveling.dto.Sub_PlaceDto;
import com.marolix.traveling.execpetion.UserNotFoundExecption;
import com.marolix.traveling.service.PlaceService;

@RestController
@CrossOrigin("*")
@RequestMapping("/travel")
public class PlaceController {

	@Autowired
	private PlaceService placeService;
	
	
	 @PostMapping("/places")
	    public ResponseEntity<PlaceDto> addPlace(@RequestBody PlaceDto dto) throws IOException  {
		
		  PlaceDto dto2 = placeService.addPlaceDetails(dto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(dto2);
	    }

	    @PostMapping("/{name}/reviews")
	    public ResponseEntity<ReviewDto> addReview(@PathVariable("name") String name, @RequestBody ReviewDto reviewDTO) {
	        ReviewDto review = placeService.addReviewDetails(reviewDTO, name);
	        return ResponseEntity.status(HttpStatus.CREATED).body(review);
	    }
	    
	    @PostMapping("/sub_place/{name}")
	    public ResponseEntity<Sub_PlaceDto> addSub_place(@RequestBody Sub_PlaceDto sub_PlaceDto,@PathVariable("name") String name){
	    	Sub_PlaceDto sub_PlaceDto2=placeService.addSub_place(sub_PlaceDto, name);
	    	return ResponseEntity.status(HttpStatus.CREATED).body(sub_PlaceDto2);
	    }

	    @GetMapping("/{placeName}")
	    public ResponseEntity<PlaceAndReviewDto> getPlaceAndReviews(@PathVariable String placeName) {
	        PlaceAndReviewDto placeReviewDTO = placeService.getAndRevieeDetails(placeName);
	       
	        if(placeReviewDTO==null)
	        {
	        	throw new UserNotFoundExecption("your data is not found :"+ placeName);
	        }
	        return ResponseEntity.ok(placeReviewDTO);
	    }
	    
	    @GetMapping("places")
	    public ResponseEntity<List<PlaceDto>> getAllPlaces()
	    {
	    	List<PlaceDto> dtos=placeService.findAllPlaces();
	    	
	    	return ResponseEntity.status(HttpStatus.OK).body(dtos);
	    }
	    
	    
	    
	   
	    
	    @DeleteMapping("/delete/{name}")
	    public ResponseEntity<String> deletePlace(@PathVariable("name") String name)
	    {
	    	placeService.deleteByName(name);
	    	
	    	return new ResponseEntity<String>("deleted seccussfully", HttpStatus.OK);
	    }
	    
	    @DeleteMapping("/delete/subplace/{name}")
	    public ResponseEntity<String> deleteSubPlace(@PathVariable("name") String name)
	    {
	    	placeService.deleteSubPlace(name);
	    	
	    	return new ResponseEntity<String>("deleted seccussfully", HttpStatus.OK);
	    }
}
