package com.luxeserve.hotel_service.service.impl;

import com.luxeserve.hotel_service.entites.Hotel;
import com.luxeserve.hotel_service.exceptions.ResourceNotFound;  // Custom exception for not found resource
import com.luxeserve.hotel_service.repository.HotelRepository;  // Assuming you have a HotelRepository
import com.luxeserve.hotel_service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;  // Inject the HotelRepository to interact with the database

    @Override
    public Hotel create(Hotel hotel) {
        // Generate a unique ID for the hotel (similar to users)
        String randomHotelId = UUID.randomUUID().toString();
        hotel.setId(randomHotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFound("Hotel with the given id is not found on server !!: " + hotelId));
    }
}
