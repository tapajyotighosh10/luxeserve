package com.luxeserve.rating_service.repository;


import com.luxeserve.rating_service.entites.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RatingRepository extends JpaRepository<Rating,String> {
    // custom finder methods
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
