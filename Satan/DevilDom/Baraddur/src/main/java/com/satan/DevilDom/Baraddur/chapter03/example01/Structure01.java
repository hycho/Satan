package com.satan.DevilDom.Baraddur.chapter03.example01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.satan.DevilDom.Baraddur.chapter02.example01.Apple;

public class Structure01 {
	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList<>();
		Apple firstApple = new Apple();
		firstApple.setColor("green");
		firstApple.setWeight(500);
		inventory.add(firstApple);
		
		/**
		 * 람다의 3부분
		 * 1. 파라메터 리스트
		 *  # Compare 메서드의 파라메터  (Apple a1, Apple a2)
		 * 2. 화살표 
		 *  # 화살표(->)는 람다의 파라미터 리스트와 바디를 구분한다.
		 * 3. 람다의 바디
		 *  # 두 사과의 무게를 비교한다. 람다의 반환값에 해당하는 표현식.
		 */
		Comparator<Apple> byColor = (Apple a1, Apple a2) -> a1.getColor().compareTo(a2.getColor());
		
		/**
		 * - 5개의 람다 표현식 예제 -
		 * 1. String 형식의 파라미터를 1개 가지며 int를 반환하는 표현. 람다는 return이 함축되어 있으니 return 문을 명시적으로 사용 하지 않는다.
		 *  # (String s) -> s.length(); 
		 * 2. Apple형식의 파라메터를 하나 ㅏ가지며 boolean(무게가 150이상일경우 true)를 반환 한다.
		 *  # (Apple a) -> a.getWeight() > 150 
		 * 3. int 형태의 파라메터 2개를 가지며 리턴값이 없다, 람다표현식은 여러 행의 문장을 표현할 수 도 있다.
		 *  # (int x, int y) -> {
		 * 	    System.out.println("Result");
		 *      System.out.println(x+y);
		 *    }
		 * 4.파라메터가 없으며 42라는 인트를 반환한다.
		 *  # () -> 42
		 * 5. Apple형태 파라메터 2개를 받으며 a1과 a2 두개의 무게를 비교결과를 반환한다.
		 *  # (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())
		 */
		
		
	}
}
