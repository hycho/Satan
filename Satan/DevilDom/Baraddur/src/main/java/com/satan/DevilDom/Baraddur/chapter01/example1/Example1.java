package com.satan.DevilDom.Baraddur.chapter01.example1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Example1 {
	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList<>();
		Apple firstApple = new Apple();
		firstApple.setColor("green");
		firstApple.setWeight(500);
		
		inventory.add(firstApple);
		
		List<Apple> greenApples = filterApples(inventory, Example1::isGreenApple);
		List<Apple> heavyApples = filterApples(inventory, Example1::isHeavyApple);
		System.out.println(greenApples.size());
		System.out.println(heavyApples.size());
		
		List<Apple> greenApples1 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
		List<Apple> heavyApples1 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
		System.out.println(greenApples1.size());
		System.out.println(heavyApples1.size());
	
	}
	
	// color가  green이면  true
	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}
	
	// weight가 150이상 이면 true
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}
	
	// 보통 java.util.function에서 import함. predicate? : 수학에서는 인수로 값을 받아 true, false를 반환하는 함수를  predicate라 한다.
	public interface Predicate<T> {
		boolean test(T t);
	}
	
	// predicate 파라메터 주시.
	static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(p.test(apple)) {	//apple은 p가 제시하는 조건에 맞는가?
				result.add(apple);
			}
		}
		return result;
	}
////////////////////////////////////////////////////	
	
	
	/**
	 * inventory 안의 apple이 녹색인 것만 추출 해서 리턴한다.
	 * @param inventory
	 * @return
	 */
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	
	/**
	 * inventory 안의 apple의 무개가 150그램 이상인 것만 리턴한다.
	 * @param inventory
	 * @return
	 */
	public static List<Apple> filterHeavyApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(apple.getWeight() > 150) {
				result.add(apple);
			}
		}
		return result;
	}
}
