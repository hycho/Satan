package com.satan.DevilDom.Baraddur.chapter02.example02;

import java.util.ArrayList;
import java.util.List;
import com.satan.DevilDom.Baraddur.chapter02.example01.Apple;


/**
 * Quiz : 사과 리스트를 인수로 받아 다양항 방법으로 문자열을 생성할 수 있도록 파라미터화된  prettyPrintApple메서드를 전략 패턴과 predicate를 사옹해서 무게, 150이상이면 무겁고 150이하면 가볍다는 출력을
 * 하도록 하는 기능을 구현해봅시다.
 * 전략 패턴과 predicate를 사용해서 무거울때나, 가볍거나, 무게를 출력하는 로직이다.
 * 하지만 각 기능에 따라 predicate구현체(전략)를(을) 만들어주는 것은 매우 불편하다.
 * @author supejkf
 *
 */
public class PrettyPrintApple1 {
	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList<>();
		Apple firstApple = new Apple();
		firstApple.setColor("green");
		firstApple.setWeight(500);
		inventory.add(firstApple);
		
		prettyPrintApple(inventory, new AppleWeightOutputPredicate());
	}
	
	public interface AppleOutputPredicate {
		String output(Apple apple);
	}
	
	public static class AppleWeightOutputPredicate implements AppleOutputPredicate{
		@Override
		public String output(Apple apple) {
			return String.valueOf(apple.getWeight());
		}
	}
	
	public static class AppleUpDownOutputPredicate implements AppleOutputPredicate{
		@Override
		public String output(Apple apple) {
			if(apple.getWeight() > 150) {
				return "This apple is heavy";
			} else {
				return "This apple is not heavy";
			}
		}
	}
	
	public static void prettyPrintApple(List<Apple> inventory, AppleOutputPredicate predicate) {
		for(Apple apple : inventory) {
			String output = predicate.output(apple);
			System.out.println(output);
		}
	}
}
