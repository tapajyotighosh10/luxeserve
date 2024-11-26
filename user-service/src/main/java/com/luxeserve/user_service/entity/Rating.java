package com.luxeserve.user_service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Rating {
    private String ratingId;
    private String UserId;
    private String hotelId;
    private int rating;
    private String feedback;


}
