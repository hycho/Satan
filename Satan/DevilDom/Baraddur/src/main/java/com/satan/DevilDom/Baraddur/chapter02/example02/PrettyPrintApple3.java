package com.satan.DevilDom.Baraddur.chapter02.example02;

import java.util.ArrayList;
import java.util.List;
import com.satan.DevilDom.Baraddur.chapter02.example01.Apple;


/**
 * Quiz : 사과 리스트를 인수로 받아 다양항 방법으로 문자열을 생성할 수 있도록 파라미터화된  prettyPrintApple메서드를 전략 패턴과 predicate를 사옹해서 무게, 150이상이면 무겁고 150이하면 가볍다는 출력을
 * 하도록 하는 기능을 구현해봅시다.
 *  
 * 익명 함수도 코드가 길어지니 이번엔 람다 표현식을 통해서 개발해본다.
 * 리스트 추상화와 람다식을 통해서 불필요한 코드 없이 개발을 햇다.
 * 
 * @author supejkf
 *
 */
public class PrettyPrintApple3 {
	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList<>();
		Apple firstApple = new Apple();
		firstApple.setColor("green");
		firstApple.setWeight(500);
		inventory.add(firstApple);
		
		prettyPrintApple(inventory, (Apple apple) -> String.valueOf(apple.getWeight()));
	}

	public interface AppleOutputPredicate<T> {
		String output(T t);
	}
	
	public static <T> void prettyPrintApple(List<T> inventory, AppleOutputPredicate<T> predicate) {
		for(T o : inventory) {
			String output = predicate.output(o);
			System.out.println(output);
		}
	}
}
