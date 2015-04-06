package com.satan.DevilDom.Baraddur.chapter02.example02;

import java.util.ArrayList;
import java.util.List;
import com.satan.DevilDom.Baraddur.chapter02.example01.Apple;


/**
 * Quiz : 사과 리스트를 인수로 받아 다양항 방법으로 문자열을 생성할 수 있도록 파라미터화된  prettyPrintApple메서드를 전략 패턴과 predicate를 사옹해서 무게, 150이상이면 무겁고 150이하면 가볍다는 출력을
 * 하도록 하는 기능을 구현해봅시다.
 * 
 * PrettyPrintApple1은 구현체에 따라 계속 Class르 생성을 해야한다. 즉 불필요 코드가 생겻다.
 * 불필요한 코드 제거방법으로 익명 클래스를 사용해보겟다.
 * 아시겟지만 익명 함수를 써도 new선언 부며, 구현할 함수 구조며 아직도 불필요한 코드가 많다.
 * 
 * @author supejkf
 *
 */
public class PrettyPrintApple2 {
	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList<>();
		Apple firstApple = new Apple();
		firstApple.setColor("green");
		firstApple.setWeight(500);
		inventory.add(firstApple);
		
		prettyPrintApple(inventory, new AppleOutputPredicate() {
			public String output(Apple apple) {
				return String.valueOf(apple.getWeight());
			}
		});
		
		prettyPrintApple(inventory, new AppleOutputPredicate() {
			public String output(Apple apple) {
				if(apple.getWeight() > 150) {
					return "This apple is heavy";
				} else {
					return "This apple is not heavy";
				}
			}
		});
	}
	
	public interface AppleOutputPredicate {
		String output(Apple apple);
	}
	
	public static void prettyPrintApple(List<Apple> inventory, AppleOutputPredicate predicate) {
		for(Apple apple : inventory) {
			String output = predicate.output(apple);
			System.out.println(output);
		}
	}
}
