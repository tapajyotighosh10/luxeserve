package com.luxeserve.rating_service.controller;

import com.luxeserve.rating_service.entites.Rating;
import com.luxeserve.rating_service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    // Create a new hotel
    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating ratingCreated = ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingCreated);
    }

    // Get all ratings
    @GetMapping()
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> rating = ratingService.getAllRatings();
        return ResponseEntity.ok(rating);
    }

    // Get rating by userid
    @GetMapping("/get_rating_by_user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUSerID(@PathVariable String userId) {

        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    // Get ratings by hotelId
    @GetMapping("/get_rating_by_hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) { // Fix: Add @PathVariable
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

}
