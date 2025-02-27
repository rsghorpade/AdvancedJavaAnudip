package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Hotel;
import com.example.demo.services.HotelServices;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelServices hotelServices;
	
	//getting data by getMapping
	@GetMapping
	public List<Hotel> getAllHotel(){
		return hotelServices.getAllHotel();
		
	}

	//create Hotel for adding new hotel by postmapping
	@PostMapping()
	public Hotel addHotel (@RequestBody Hotel hotel) {
		return hotelServices.saveHotel(hotel);
	}
	
	//updating hotel data by id
	public ResponseEntity<Hotel> updateHotels(@PathVariable Long id, @RequestBody Hotel updateHotel){
	
	Hotel existingHotel = hotelServices.getHotelbyId(id);
	
	if(existingHotel!=null) {
		existingHotel.setName(updateHotel.getName());
		existingHotel.setHoteltype(updateHotel.getHoteltype());
		existingHotel.setQuality(updateHotel.getQuality());
		
		Hotel saveHotel = hotelServices.saveHotel(existingHotel);
		return ResponseEntity.ok(saveHotel);
		
		}else {
			return ResponseEntity.notFound().build();
			
}
}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHotelById(@PathVariable Long id){
		
		boolean isDeleted = hotelServices.deleteHotelById(id);
		
		if(isDeleted) {
			return ResponseEntity.noContent().build();
		}else {    
			return ResponseEntity. notFound().build();		
		
}
}
}
