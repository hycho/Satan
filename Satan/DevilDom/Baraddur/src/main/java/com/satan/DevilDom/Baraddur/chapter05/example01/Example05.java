package com.satan.DevilDom.Baraddur.chapter05.example01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.satan.DevilDom.Baraddur.chapter04.model.Dish;

public class Example05 {
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
	
		findFirstData();
	}

	// findFirst
	public static void findFirstData() {
		List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
		Optional<Integer> firstSquareDivisibleByThree = 
				someNumbers.stream()
				.map(x -> x * x)
				.filter(x -> x % 3 == 0)
				.findFirst();
		
		System.out.println(firstSquareDivisibleByThree.get());
		
		firstSquareDivisibleByThree.ifPresent((Integer a) -> System.out.println(a.toString()));
	}
}
