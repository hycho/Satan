package com.satan.DevilDom.Baraddur.chapter05.example04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.satan.DevilDom.Baraddur.chapter04.model.Dish;

public class Example02 {
	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(
				new Dish("소세지", false, 800, Dish.Type.MEAT),
				new Dish("소고기구이", false, 700, Dish.Type.MEAT),
				new Dish("통닭", false, 400, Dish.Type.MEAT),
				new Dish("감자튀김", true, 540, Dish.Type.OTHER),
				new Dish("쌀밥", true, 350, Dish.Type.OTHER),
				new Dish("오늘의 과일", true, 120, Dish.Type.OTHER),
				new Dish("피자", true, 550, Dish.Type.OTHER),
				new Dish("고등어", false, 300, Dish.Type.FISH),
				new Dish("연어", false, 450, Dish.Type.FISH));
		
		printRangeClosedToIntStream();
	}
	
	public static void findPitagorasOperation() {
		
	};
	
	//1-100까지 생성 rangeClosed를 이용해서
	public static void printRangeClosedToIntStream() {
		//rangeClose는 1부터 100까지
		IntStream evenNumbers = IntStream.rangeClosed(1, 100)
											.filter(n -> n % 2 == 0);
		// range는 2부터 99까지 즉 파라메터 1과 100은 무시된다.
		IntStream evenNumbers2 = IntStream.range(1, 100)
											.filter(n -> n % 2 == 0);
		
		System.out.println(evenNumbers.count());
		System.out.println(evenNumbers2.count());
	}
}
