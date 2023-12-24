package com.lcwd.user.service.entities;

import lombok.*;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmOneToManyCollectionElementType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private String userId;
    private String ratingId;
    private int rating;
    private String hotelId;
    private String feedback;

    private Hotel hotel;

}
