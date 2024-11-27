package com.luxeserve.user_service.external.services;

import com.luxeserve.user_service.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("/hotels/gethotel/{hotelId}")
     Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
