package com.satan.DevilDom.Baraddur.chapter04.example02;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import com.satan.DevilDom.Baraddur.chapter04.model.Dish;

public class Example02 {
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
		

		terminalOperationSample(menu);
	}
	
	public static void terminalOperationSample(List<Dish> menu) {
		menu.stream().forEach(System.out::println);
	}
	
	// 중간연산 샘플 쇼트서킷, 루프퓨전을 확인한다.
	public static void intermediateOperationDebug(List<Dish> menu) {
		List<String> names = 
				menu.stream()
				.filter(d -> {
					System.out.println("filtering = "+d.getCalories());
					return d.getCalories() > 300;
				})
				.map(d -> {
					System.out.println("mapping = " + d.getName());
					return d.getName();
				})
				.limit(3)
				.collect(toList());
		System.out.println(names);
	}
	
	// 외부반복 예제
	public static void externalIteration1(List<Dish> menu) {
		List<String> names = new ArrayList<>();
		for(Dish d : menu) {	//명시적 순차 반복
			names.add(d.getName());	//추출해서 리스트에 저장
		}
	}
	
	// 내부적으로 숨겨졋던 iterator를 사용한 외부 반복
	public static void externalIteration2(List<Dish> menu) {
		List<String> names = new ArrayList<>();
		Iterator<Dish> it = menu.iterator();
		while(it.hasNext()) {	//명시적 반복
			Dish d = it.next();
			names.add(d.getName());
		}
	}
	
	// stream을 통한 내부 반복
	public static void internalIteration(List<Dish> menu) {
		// map메서드를 통해 getName으로 요리명을 추출해서 넣는다.
		List<String> names = menu.stream().map(Dish::getName).collect(toList()); //반복자는 필요없다.
	}
	
	public static void consumerStream() {
		List<String> titles = Arrays.asList("Java8", "In", "Action");
		Stream<String> s = titles.stream();
		s.forEach(System.out::println); // 반복하면서 스트림을 소비한다.
		s.forEach(System.out::println); // 여기서는 스트림을 모두 소비해버리는 바람에 오류가 발생한다.
	}
}
