package com.satan.DevilDom.Baraddur.chapter02.example01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Example1 {
	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList<>();
		Apple firstApple = new Apple();
		firstApple.setColor("green");
		firstApple.setWeight(500);
		inventory.add(firstApple);
		
	}
	
	/**
	 * Apple을 위한 predicate interface
	 * @author supejkf
	 *
	 */
	public interface ApplePredicate {
		boolean test (Apple apple);
	}
	
	/**
	 * weight가 150이상 일 경우  true
	 * @author supejkf
	 *
	 */
	public class AppleHeavyWeightPredicate implements ApplePredicate {
		@Override
		public boolean test(Apple apple) {
			return apple.getWeight() > 150;
		}
	}
	
	/**
	 * color가 green일 경우.
	 * @author supejkf
	 *
	 */
	public class AppleGreenPredicate implements ApplePredicate {
		@Override
		public boolean test(Apple apple) {
			return apple.getColor().equals("green");
		}
	}
	
	public static List<Apple> filterApples2(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	/**
	 * inventory 안의 apple이 파라메터 color, 무게에 따른 사과만 추출 해서 리턴한다.(참 안좋은 코드)
	 * @param inventory
	 * @return
	 */
	public static List<Apple> filterApples1(List<Apple> inventory, String color, int weight, boolean flag) {
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
				result.add(apple);
			}
		}
		return result;
	}
	

	/**
	 * inventory 안의 apple이 파라메터 color와 동일 한 것만 추출 해서 리턴한다.
	 * @param inventoryㄷㄷ
	 * @return
	 */
	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(apple.getColor().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}
		
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
