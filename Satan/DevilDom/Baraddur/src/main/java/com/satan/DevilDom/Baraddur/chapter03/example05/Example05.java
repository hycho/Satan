package com.satan.DevilDom.Baraddur.chapter03.example05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import com.satan.DevilDom.Baraddur.chapter03.model.Apple;

/**
 * List의 sort기능을 이용해서 소트에 들어갈 전략(구현체)를 마구마구 바꿀수 있는 코드를 만들어보자!
 * 1단계 List Sort메소드가 갖는 파라메터 Comparator을 만든다.
 * @author supejkf
 *
 */
public class Example05 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Apple> inventory = new ArrayList<>();
		Apple firstApple = new Apple();
		firstApple.setColor("green");
		firstApple.setWeight(500);
		inventory.add(firstApple);
		
		inventory.sort(new AppleComparator());
		
		/**
		 * 2단계 AppleComparator를 익명함수를 써서 적용한다.
		 * 1단계를 개선함.
		 */
		inventory.sort(new Comparator<Apple>() {
			public int compare(Apple o1, Apple o2) {
				return o1.getColor().compareTo(o2.getColor());
			}
		});
		
		/**
		 * 3단계 람다표현식 사용
		 */
		inventory.sort((Apple a1, Apple a2) -> a1.getColor().compareTo(a2.getColor()));
		// Comparator.comparing((Function<? super Apple, ? extends String>) key Function을 통해 Comparator생성
		Comparator<Apple> c = Comparator.comparing((Apple a) -> a.getColor());
		
		// Comparing을사용하고 메서드 레퍼런스를 사용해서 더 간결하게 만들었다
		inventory.sort(Comparator.comparing(Apple::getWeight));
	}
	
	/**
	 * 1단계 Comparator인터페이스를 구현하는 구현체 AppleComparator를 만든다.
	 * @author supejkf
	 *
	 */
	public static class AppleComparator implements Comparator<Apple> {
		@Override
		public int compare(Apple o1, Apple o2) {
			return o1.getColor().compareTo(o2.getColor());
		}
	}
	
	/**
	 * 2단계 AppleComparator를 익명함수를 써서
	 */
	
}