package com.satan.DevilDom.Baraddur.chapter05.example01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import com.satan.DevilDom.Baraddur.chapter04.model.Dish;

public class Example01 {
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
		
	}
	
	// map을 통해서 dish의 이름을 리스트로 반환한다.
	public static void getDishNamesViaMap(List<Dish> menu) {
		List<String> dishName = menu.stream()
								.map(Dish::getName)
								.collect(toList());
	}
	
	// map을 토해서 List안의 word들의 Length를 추출한다.
	public static void getWordsLengths(List<Dish> menu) {
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		List<Integer> wordLengths = words.stream()
									.map(String::length)
									.collect(toList());
	}
	
	// 첫번째 name만 추출, 2번째 추출된 name에서 length추출
	public static void getDishNamesLengths(List<Dish> menu) {
		List<Integer> dishNamesLength = menu.stream()
										.map(Dish::getName)
										.map(String::length)
										.collect(toList());
	}
	
	
	
}
