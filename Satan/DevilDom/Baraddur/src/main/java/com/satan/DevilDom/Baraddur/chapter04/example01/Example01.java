package com.satan.DevilDom.Baraddur.chapter04.example01;

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
	
		//printLowCaloricDishs(menu);
		//printLowCaloricDishsNames(menu);
		printThreeHighCaloricDishNames(menu);
		
	}
	
	public static void printThreeHighCaloricDishNames(List<Dish> menu) {
		List<String> threeHighCaloricDishsName = 
				menu.stream()	// menu에서 스트림을 받는다.
					.filter(d -> d.getCalories() > 300)	//dish의 칼로리 300이상되는 것만 가져오도록 필터링 한다.
					.map(Dish::getName)	//필터된 값중 이름만 뽑는다.
					.limit(3)	//선착순 3개만 표시한다.
					.collect(toList());	//리스트로 만들어 반환한다.
		
		for(String s : threeHighCaloricDishsName) {
			System.out.println(s);
		}
	}
	
	/**
	 * 컬렉션과 익명함수 를 사용하여 400칼로리 이햐의 요리를 칼로리 순으로 정렬해서 출력해주는 함수.
	 * @param menu
	 */
	public static void printLowCaloricDishs(List<Dish> menu) {
		List<Dish> lowCaloricDishes = new ArrayList();
		
		//칼로리가 400이하인 식품을 collect한다
		for(Dish d: menu) {	
			if(d.getCalories() < 400) {
				lowCaloricDishes.add(d);
			}
		}
		
		// 칼로리 순으로 정렬한다. (익명함수 사용)
		lowCaloricDishes.sort(new Comparator<Dish>() {
			public int compare(Dish o1, Dish o2) {
				return Integer.compare(o1.getCalories(), o2.getCalories());
			}
		});
		
		for(Dish d : lowCaloricDishes) {
			System.out.println(d.getName()+"'s Calroic is "+d.getCalories()+" Calroric");
		}
	}
	
	/**
	 * steram을 통해 filter, sort, map, collect하는 예제.
	 * @param menu
	 */
	public static void printLowCaloricDishsNames(List<Dish> menu) {
		List<String> lowCaloricDishes = 
				menu.stream()	//병렬처리를 위한다면 menu.parallelStream()을 사용한다.
					.filter(dish -> dish.getCalories() < 400)
					.sorted(comparing(Dish::getCalories))
					.map(Dish::getName)
					.collect(toList());
		
		for(String dName : lowCaloricDishes) {
			System.out.println(dName);
		}
	}
}
