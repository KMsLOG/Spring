package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RestaurantTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RestaurantConfig.class);
        
        // 일본식 레스토랑 정보를 출력하는 프린터
        RestaurantPrinter jpnPrinter = context.getBean("japaneseRestaurantPrinter", RestaurantPrinter.class);
        jpnPrinter.printRestaurantInfo(); // 일본식 레스토랑 정보 출력

        // 한국식 레스토랑 정보를 출력하는 프린터
        RestaurantPrinter korPrinter = context.getBean("koreanRestaurantPrinter", RestaurantPrinter.class);
        korPrinter.printRestaurantInfo(); // 한국식 레스토랑 정보 출력
    }
}
