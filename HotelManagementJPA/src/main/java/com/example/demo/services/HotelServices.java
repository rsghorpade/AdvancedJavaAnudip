package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.repository.HotelRepository;

@Service
public class HotelServices {

	@Autowired
	private HotelRepository hotelRepository;

	// getting data
	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}

	// Saving data
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	// Update
	// public Hotel updateHotel(Hotel hotel) {
	// return hotelRepository.save(hotel);
	// }

	public Hotel getHotelbyId(Long id) {
		return hotelRepository.findById(id).orElse(null);
	}

	// deleting hotel by id
	public boolean deleteHotelById(Long id) {
		if (hotelRepository.existsById(id)) {
			hotelRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
