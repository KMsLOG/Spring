package com.ssafy.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ssafy.ws")
public class RestaurantConfig {
	
	@Bean
	public List<Review> japaneseReviews(){
		return new ArrayList<>();
	}
	
	@Bean
	public List<Review> koreanReviews(){
		return new ArrayList<>();
	}
	
	@Bean
	public Restaurant japaneseRestaurant() {
		return new JapaneseRestaurant(japaneseReviews());
	}
	
	@Bean
	public Restaurant koreanRestaurant() {
		return new KoreanRestaurant(koreanReviews());
	}

	@Bean
	public RestaurantPrinter koreanRestaurantPrinter(@Qualifier("koreanRestaurant") Restaurant restaurant) {
		return new RestaurantPrinter(restaurant);
	}

	@Bean
	public RestaurantPrinter japaneseRestaurantPrinter(@Qualifier("japaneseRestaurant") Restaurant restaurant) {
		return new RestaurantPrinter(restaurant);
	}
}
