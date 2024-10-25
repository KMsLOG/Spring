package com.ssafy.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JapaneseRestaurant implements Restaurant {
	
	private List<Review> reviews;
	private String[] menu;
	
    @Autowired
    public JapaneseRestaurant( List<Review> japaneseReviews) {
        this.reviews = japaneseReviews;
        this.menu = new String[]{"초밥", "우동", "소바"}; // 메뉴 추가
        reviews.add(new Review("일식리뷰1", "초밥이 신선하고 맛있어요.", "초밥헌터"));
        reviews.add(new Review("일식리뷰2", "우동이 별로네요", "우동사냥꾼"));
    }
	@Override
	public List<Review> getReviews() {
		return reviews;
	}

	@Override
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
		
	}

	@Override
	public String[] getMenu() {
		return menu;
	}

	@Override
	public void setMenu(String[] menu) {
		this.menu = menu;
		
	}

	@Override
	public void getInfo() {
		System.out.println("****** 메뉴 목록 ******");
		for(int i = 0 ;i<menu.length;i++) {
			System.out.println(i+". "+menu[i]);
		}
		System.out.println("****** 리뷰 목록 ******");
		for(Review r : reviews) {
			System.out.println(r.toString());
		}
		
	}
}
