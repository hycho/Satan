package com.satan.DevilDom.Baraddur.chapter04.example03;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import com.satan.DevilDom.Baraddur.chapter04.model.Dish;

public class Example03 {
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
		

		distinctSample(menu);
	}
	
	// predicate를 사용한 filtering
	public static void filteringViaPredicate(List<Dish> menu) {
		List<Dish> vegetarianMenu = 
				menu.stream()
				.filter(Dish::isVegetarian)
				.collect(toList());
	}
	
	// distinct를 통해서 중복없이 고유 건만 가져온다.
	public static void distinctSample(List<Dish> menu) {
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream()
			.filter(i-> i % 2 == 0)
			.distinct()
			.forEach(System.out::println);
	}
	
	// limit을 통해서 스트림을 축소 하는 예제
	public static void limitSample(List<Dish> menu) {
		List<Dish> dishes = menu.stream()
								.limit(3)
								.collect(toList());
	}
	
	//skip을 사용해서 요소 건너뛰기
	public static void skipSample(List<Dish> menu) {
		List<Dish> dishes = 
			menu.stream()
			.filter(d->d.getCalories() > 300)
			.skip(2)
			.collect(toList());
	}
	
	
}
