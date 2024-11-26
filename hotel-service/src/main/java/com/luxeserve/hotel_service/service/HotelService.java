package com.luxeserve.hotel_service.service;

import com.luxeserve.hotel_service.entites.Hotel;

import java.util.List;

public interface HotelService {
    // Create a new hotel
    Hotel create(Hotel hotel);

    // Get all hotels
    List<Hotel> getAllHotels();

    // Get a hotel by ID
    Hotel getHotelById(String hotelId);

    // TODO: Update hotel (to be implemented)
    // TODO: Delete hotel (to be implemented)
}
