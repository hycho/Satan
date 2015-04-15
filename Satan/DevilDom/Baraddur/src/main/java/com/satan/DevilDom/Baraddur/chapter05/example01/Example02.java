package com.satan.DevilDom.Baraddur.chapter05.example01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

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
		
		quiz2();
	}
	
	
	public static void arrayStreamSample() {
		String[] arrayOfWords = {"Goodbye", "World"};
		Stream<String> streamOfWords = Arrays.stream(arrayOfWords);	//문자열을 받아서 스트림을 만드는 Arrays.stream
	}

	//리스트 값에서 고유 문자로 이루어진 리스트를 구하고 싶을경우? ["hello","world"]일경우 h,e,l,o,w,r,d만 가져오고 싶을때 flatmap을 사용해서 할 수 잇다.
	public static void getUniqueCharacters(List<Dish> menu) {
		menu.stream()
			.map(Dish::getName)
			.map(w->w.split(""))
			.flatMap(Arrays::stream)
			.distinct()
			//.collect(toList());
			.forEach(System.out::println);
	}
	
	//숫자 리스트가 주어 졋을때  각 숫자의 제곱근으로 이루어진 리스트를 반환 하시오. 예를 들어 1,2,3,4,5가 주어질 경우 1,4,9,16,25를 반환해야 합니다.
	public static void getSquareRoot() {
		List<Integer> intList = Arrays.asList(1,2,3,4,5);
		
		intList.stream()
				.map(w -> w*w)
				.forEach((Integer a) -> System.out.println(a.toString()));
	}
	
	// 
	public static void quiz1() {
		List<Integer> number1 = Arrays.asList(1,2,3);
		List<Integer> number2 = Arrays.asList(3,4);
		
		List<Object> pairs = number1.stream()
							.flatMap(i -> number2.stream().map(j -> new int[]{i, j}))
							.collect(toList());
		
		int[] a = (int[]) pairs.get(0);
		for(int c : a){
			System.out.println(c);
		}
	}
	
	// 
	public static void quiz2() {
		List<Integer> number1 = Arrays.asList(1,2,3);
		List<Integer> number2 = Arrays.asList(3,4);
		
		List<Object> pairs = number1.stream()
							.flatMap(i -> number2.stream().filter(j -> (i+j)%3 == 0).map(j -> new int[]{i, j}))
							.collect(toList());
		
		int[] a = (int[]) pairs.get(0);
		for(int c : a){
			System.out.println(c);
		}
	}
	
}
