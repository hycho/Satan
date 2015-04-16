package com.satan.DevilDom.Baraddur.chapter05.example01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

import com.satan.DevilDom.Baraddur.chapter04.model.Dish;

public class Example03 {
	public static void main(String[] args) {
		
		List<Dish> menu = Arrays.asList(
				new Dish("소세지", false, 800, Dish.Type.MEAT),
				new Dish("소고기구이", false, 700, Dish.Type.MEAT),
				new Dish("통닭", false, 1400, Dish.Type.MEAT),
				new Dish("감자튀김", true, 540, Dish.Type.OTHER),
				new Dish("쌀밥", true, 350, Dish.Type.OTHER),
				new Dish("오늘의 과일", true, 120, Dish.Type.OTHER),
				new Dish("피자", true, 550, Dish.Type.OTHER),
				new Dish("고등어", false, 300, Dish.Type.FISH),
				new Dish("연어", false, 450, Dish.Type.FISH));
		
		allMatchByPredicate(menu);
	}
	
	public static void anyMatchByPredicate(List<Dish> menu) {
		// anyMatch같은 경우는 주어진 스트림에서 1개의 요소라도 일치함을 확인 할때 쓸 수 있습니
		if(menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("야채가 존재 합니다.");
		}
	}
	
	public static void allMatchByPredicate(List<Dish> menu) {
		// allMatch메서드는 anyMatch와 달리 스트림의 모든 요소가 주어진 프리디케이트와 일치하는지 검사한다.
		// 모두다 주어진 프리디케이트를 통과해야 true아니면 false
		if(menu.stream().allMatch(d->d.getCalories() < 1000)){
			System.out.println("모두다 건강식");
		}
	}
}
