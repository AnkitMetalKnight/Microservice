package com.lcwd.user.service;

import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

//	@Test
//	void create()
//	{
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("This is created using feign").build();
//		Rating saveRating = ratingService.create(rating);
//
//		System.out.println("new rating created");
//	}

}
