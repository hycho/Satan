package com.satan.DevilDom.Baraddur.chapter03.example04;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import com.satan.DevilDom.Baraddur.chapter03.model.Apple;

/**
 * # 메서드 레퍼런스
 *  - 특정 메서드만을 호출하는 람다의 축약형, 람다에서 '이 객체의 이메서드를 직접 호출해'라고 명령하는 것보다는 메서드를 가진 클래스+메서드를 직접 써넣는것이 더 가독성이 좋다고 한다 정말인지는...
 * # ClassName::new 처럼 클래스명 + new키워드를 통해서 기존 생성자의 레퍼런스를 만들 수 있다.
 * @author supejkf
 *
 */
public class Example04 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//메서드 레퍼런스
		List<String> str = Arrays.asList("a","b","c","d");
		str.sort(String::compareToIgnoreCase);
		
		//생성자 레퍼런스 -Supplier
		Supplier<Apple> c1 = Apple::new;	//Default생성자 apple()의 생성자 레퍼런스
		Apple a1 = c1.get();	//Supplier의 get메서드를 호출해서 새로운 Apple 객체를 만들 수 있다.
		
		//위예제와 동일한 코드 -Supplier
		Supplier<Apple> c2 = () -> new Apple();
		Apple a2 = c2.get();
		
		//생성자 레퍼런스 -Function
		Function<Integer, Apple> c3 = Apple::new;
		Apple a3 = c3.apply(110);
		
		//위예제와 동일한 코드 -Supplier
		Function<Integer, Apple> c4 = (weight) -> new Apple(weight);
		Apple a4 = c4.apply(500);
		
		List<Integer> weight = Arrays.asList(7,3,5,6);
		List<Apple> apples = map(weight, Apple::new);
		
		// 두개의 인수를 갖는 생성자는 BiFunction인터페이스와 같은 시그너처를 가지므로 다음과 같이 가능
		BiFunction<String, Integer, Apple> c5 = Apple::new;
		Apple a5 = c5.apply("green", 150);
		
		// 위코드는 다음과 같음
		BiFunction<String, Integer, Apple> c6 = (color, weight1) -> new Apple(color, weight1);
		Apple a6 = c6.apply("red", 500);
	}
	
	public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
		List<Apple> result = new ArrayList<>();
		for(Integer e : list) {
			result.add(f.apply(e));
		}
		return result;
	}
}