package com.ssafy.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class KoreanRestaurant implements Restaurant {
	private List<Review> reviews;
	private String[] menu;
	
    @Autowired
    public KoreanRestaurant( List<Review> koreanReviews) {
        this.reviews = koreanReviews;
        this.menu = new String[]{"김치", "불고기", "비빔밥"}; // 메뉴 추가
        reviews.add(new Review("정말 맛있는 김치!", "김치의 맛이 뛰어나고 신선합니다.", "김싸피"));
        reviews.add(new Review("불고기가 최고입니다!", "불고기가 부드럽고 맛있어요.", "박싸피"));
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
