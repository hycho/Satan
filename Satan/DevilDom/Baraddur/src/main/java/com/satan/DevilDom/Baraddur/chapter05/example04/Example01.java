package com.satan.DevilDom.Baraddur.chapter05.example04;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
		
		//printSumCalories(menu);
		//printSumCaloriesViaIntStream(menu);
	}
	
	public static void optionalInt(List<Dish> menu) {
		// 합계는 0이라는 기본값이 주어지기에 별문제가 없지만 max, min경우 0이라는 기본값 때문에 잘못된 결과가 도출 될 수 있다.
		// 스트림 요소가 없을때, 진짜 최대값이 0인 상황을 어떻게 구분할까? 이런것은 Optional을 통해서 처리를 할 수 있으며, 특화 스트림 버전인 OptionalInt, OptionalDouble, OptionalLong 세가지 를 제공한다. 
		OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max(); 
		int max = maxCalories.orElse(1); //값이 없을때 기본 최댓값을 1로 설정.
	}
	
	public static void boxedIntStream(List<Dish> menu) {
		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
		//특화 스트림에서 boxed메소드를 통해 객체 스트림으로 복원 할 수 있다.
		Stream<Integer> steram = intStream.boxed();
	}
	
	//mapToInt는 intstream을 리턴하며 숫자 스트림을 계산할수 있는 max, sum등 자주 사용하는 숫자 관련 리듀싱 메서드를 제공한다.
	public static void printSumCaloriesViaIntStream(List<Dish> menu) {
		int carories = menu.stream()
				.mapToInt(Dish::getCalories)
				.sum();

		System.out.println("칼로리 총합계 = "+carories);
	}
	
	//map,reduce를 통해서 메뉴의 합계를 구하는 로직
	public static void printSumCalories(List<Dish> menu) {
		//여기엔 내부적으로 합계를 계산하기 전에 Integer를 int(기본형)으로 언 박싱 해야한다... 이런 박싱 비용을 피할 수 잇도록 각 요소에 특화된 IntStream...등을 제공한다.		
		int carories = menu.stream()
							.map(Dish::getCalories)
							.reduce(0, Integer::sum);
		
		System.out.println("칼로리 총합계 = "+carories);
	}
	
}
