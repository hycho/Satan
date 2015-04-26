package com.satan.DevilDom.Baraddur.chapter06.example02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		
		//howManyDishesViaCounting(menu);
		//manyMin(menu);
		//summingInt(menu);
		//avgCalories(menu);
		summaryStatistics(menu);
	}
	
	public static void summaryStatistics(List<Dish> menu) {
		//Collect.summarizingInt를 사용해서 count, sum, min, average, max를 한번에 구해올 수 있다.
		IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics);
	}
	
	public static void avgCalories(List<Dish> menu) {
		//averagingDouble을 사용하여 칼로리들의 평균을 구한다.
		double avgCalories = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
		System.out.println(avgCalories);
	}
	
	public static void summingInt(List<Dish> menu) {
		int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		System.out.println(totalCalories);
	}
	
	public static void manyMin(List<Dish> menu) {
		Optional<Dish> mostCalorieDish = 
		menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)));	//maxBy를 사용하여 칼로리가 가장 높은 것을 검색해온다.
		mostCalorieDish.ifPresent((Dish d) -> System.out.println(d.getCalories()));
	}
	
	public static void howManyDishesViaCounting(List<Dish> menu) {
		//counting메소드를 통해서 dish의 갯수를 가져온다.
		long howManyDishes = menu.stream().collect(Collectors.counting());
		System.out.println(howManyDishes);
		
		//이렇게도 축소 할 수 있지만. counging 컬랙터는 다른 컬렉터와 함께 사용할 때 좋다.
		long howManyDishes1 = menu.stream().count();
	}
}
