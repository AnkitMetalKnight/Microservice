package com.lcwd.rating.services;

import com.lcwd.rating.entities.Rating;

import java.util.List;

public interface RatingServices {

    //create ratings
    Rating create(Rating rating);


    //get all ratings
    List<Rating> getRatings();

    //get all ratings by User id
    List<Rating> getRatingByUserId(String userId);

    //get all ratings by Hotel id
    List<Rating> getRatingByHotelId(String hotelId);


}
