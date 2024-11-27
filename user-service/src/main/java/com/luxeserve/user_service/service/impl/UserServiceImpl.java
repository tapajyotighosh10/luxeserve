package com.luxeserve.user_service.service.impl;

import com.luxeserve.user_service.entity.Hotel;
import com.luxeserve.user_service.entity.Rating;
import com.luxeserve.user_service.entity.Users;
import com.luxeserve.user_service.exceptions.ResourceNotFound;
import com.luxeserve.user_service.external.services.HotelService;
import com.luxeserve.user_service.repository.UserRepository;
import com.luxeserve.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Override
    public Users saveUser(Users users) {
        //generate a unique user id in string format
       String randomUserID= UUID.randomUUID().toString();
        users.setUserId(randomUserID);
        return userRepository.save(users);
    }

    @Override
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(String userId) {
        // get user from database with the help of user repository
        Users users= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFound("User with given id is not found on server !!:"+userId));
       // fetch rating of the above user from rating service
        Rating[] ratingsOfUser= restTemplate.getForObject("http://RATING-SERVICE/rating/get_rating_by_user/"+users.getUserId(), Rating[].class);
        List<Rating> ratings= Arrays.stream(ratingsOfUser).toList();

     List<Rating> ratingList=   ratings.stream().map(rating -> {
            // api call to hotel service to get hotel
            // set the hotel rating
            // return the rating
         //localhost:9393/hotels/gethotel/f8522c44-0d0c-442f-abe0-66614ad8c216
         ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/gethotel/" + rating.getHotelId(), Hotel.class);

        Hotel hotel= hotelService.getHotel(rating.getHotelId());
        rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        users.setRatings(ratingList);
        return users;
    }
}
