package com.luxeserve.hotel_service.repository;

import com.luxeserve.hotel_service.entites.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface HotelRepository extends JpaRepository<Hotel,String> {

}
