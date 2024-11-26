package com.luxeserve.rating_service.service.impl;

import com.luxeserve.rating_service.entites.Rating;
import com.luxeserve.rating_service.exceptions.ResourceNotFound;
import com.luxeserve.rating_service.repository.RatingRepository;
import com.luxeserve.rating_service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;  // Inject the HotelRepository to interact with the database

    @Override
    public Rating create(Rating rating) {
        // Generate a unique ID for the hotel (similar to users)
        String randomRatingId = UUID.randomUUID().toString();
        rating.setRatingId(randomRatingId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
