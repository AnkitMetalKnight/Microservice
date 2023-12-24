package com.lcwd.hotel.services;

import com.lcwd.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {

    //to create a hotel
    Hotel create(Hotel hotel);

    //to get all hotel data
    List<Hotel> getAll();

    //to find one hotel by id
    Hotel get(String id);


}
