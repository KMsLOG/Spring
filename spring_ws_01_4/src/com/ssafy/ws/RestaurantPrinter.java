package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RestaurantPrinter {

    private Restaurant restaurant;

    
    @Autowired
    public RestaurantPrinter(@Qualifier("japaneseRestaurant") Restaurant restaurant) { // 일본식 레스토랑으로 설정
        this.restaurant = restaurant;
    }


	public void printRestaurantInfo() {
        restaurant.getInfo();
    }
}
