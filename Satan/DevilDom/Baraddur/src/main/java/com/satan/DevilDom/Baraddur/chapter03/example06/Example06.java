package com.satan.DevilDom.Baraddur.chapter03.example06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.satan.DevilDom.Baraddur.chapter03.model.Apple;

/**
 * List의 sort기능을 이용해서 소트에 들어갈 전략(구현체)를 마구마구 바꿀수 있는 코드를 만들어보자!
 * 1단계 List Sort메소드가 갖는 파라메터 Comparator을 만든다.
 * @author supejkf
 *
 */
public class Example06 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Apple> inventory = new ArrayList<>();
		Apple firstApple = new Apple();
		firstApple.setColor("green");
		firstApple.setWeight(500);
		inventory.add(firstApple);
		
		functionDefaultMethod();
	}
	
	public static void comparatorDefaultMethod(List<Apple> inventory) {
		//Comparator.compring을 통해 비교에 사용할 키를 추출 하는 Function 기반의 Comparator를 반환.
		Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
		
		// 만약 사과의 무게를 내림차순으로 정렬하고 싶으면 어떻게 할까? reverse라는 디폴트 메서드를 사용하자.
		inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
		
		//만약 무게가 같다면? 두번째로 비교할 것을 지정 할 수 없을까? thenComparing메서드를 통해서 두번째 비교자를 만들수 있다.
		inventory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
	}
	
	public static void predicateDefaultMethod() {
		Predicate<Apple> redApple = (a) -> a.getColor().equals("red");
		
		// 기존 redApple의 predicate를 반전 시킨다.
		Predicate<Apple> notRedApple = redApple.negate();
		
		// and 메서드를 통해 빨간색이면서 무거운 사과를 선택하도록 두 람다식을 조합이 가능하다.
		Predicate<Apple> redAndHeavyApple = redApple.and(a->a.getWeight() > 150);
		
		// or을 통해서 빨간색이면서 무거운 사과 또는 그냥 녹색사과 등 다양한 조건을 만들 수 있다.
		Predicate<Apple> redAndHeavyAppleOrGreen = redApple.and(a->a.getWeight() > 150)
				.or(a->a.getClass().equals("green"));
	}
	
	public static void functionDefaultMethod() {
		Function<Integer, Integer> f = x->x+1;
		Function<Integer, Integer> g = x->x*2;
		Function<Integer, Integer> h = f.andThen(g); //g(f(x)
		System.out.println(h.apply(1));
		
		Function<Integer, Integer> h1 = f.compose(g); //f(g(x)
		System.out.println(h1.apply(1));
	}
	
}