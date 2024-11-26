package com.luxeserve.rating_service.service;

import com.luxeserve.rating_service.entites.Rating;

import java.util.List;

public interface RatingService {
    // Create a new hotel
    Rating create(Rating rating);

    // Get all hotels
    List<Rating> getAllRatings();

    // Get a hotel by ID
    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByHotelId(String hotelId);
    // TODO: Update hotel (to be implemented)
    // TODO: Delete hotel (to be implemented)
}
