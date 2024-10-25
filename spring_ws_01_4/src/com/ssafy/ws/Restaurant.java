package com.ssafy.ws;

import java.util.List;

public interface Restaurant {

	List<Review> getReviews();

	void setReviews(List<Review> reviews);

	String[] getMenu();

	void setMenu(String[] menu);

	void getInfo(); // 한식당인지 일식당인지 출력

}
