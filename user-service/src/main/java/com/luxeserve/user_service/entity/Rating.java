package com.luxeserve.user_service.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonPropertyOrder({"ratingId","userId","hotelId","rating","feedback","hotel"})
public class Rating {
    private String ratingId;
    private String UserId;
    private String hotelId;
    private int rating;
    private String feedback;

    private Hotel hotel;

}
