package com.satan.DevilDom.Baraddur.chapter02.example03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.satan.DevilDom.Baraddur.chapter02.example01.Apple;

/**
 * Compareator로 정렬하기
 * @author supejkf
 *
 */
public class ComparatorRamda {
	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList<>();
		Apple firstApple = new Apple();
		firstApple.setColor("green");
		firstApple.setWeight(1500);
		inventory.add(firstApple);
		
		Apple secondApple = new Apple();
		secondApple.setColor("red");
		secondApple.setWeight(500);
		inventory.add(secondApple);
		
		// java.util.Comparator를 이용, 익명클래스를 통해서 정렬 하기
		inventory.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight() < o2.getWeight() ? -1 : o1.getWeight() < o2.getWeight() ? 1:0; 
			}
		});
		for(Apple apple : inventory) {
			System.out.println(apple.getColor());
		}
		System.out.println("#######################");
		// 람다표현식을 사용해서 진행
		inventory.sort((Apple o1, Apple o2) -> o1.getWeight() < o2.getWeight() ? -1 : o1.getWeight() < o2.getWeight() ? 1:0);
		for(Apple apple : inventory) {
			System.out.println(apple.getColor());
		}
		System.out.println("#######################");
		// 람다표현식을 사용해서 진행
		inventory.sort((Apple o1, Apple o2) -> o1.getColor().compareTo(o2.getColor()));
		for(Apple apple : inventory) {
			System.out.println(apple.getColor());
		}
	}
}
