package com.satan.DevilDom.Baraddur.chapter03.example03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Example03 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<String> listOfString = new ArrayList<String>();
		
		Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
		List<String> nonEmpty = filter(listOfString, nonEmptyStringPredicate);
		
		forEach(
			Arrays.asList(1,2,3,4,5),
			(Integer i) -> System.out.println(i)
		);
		
		List<Integer> list = map(Arrays.asList("lam","ddddf","hoho"), (String s) -> s.length());
		for(int c : list) {
			System.out.println(c);
		}
	}
	
	
	/**
	 * java.util.function.Predicate<T> 인터페이스는 test라는 추상메소드를 정의, test는 제네릭 형식 T를 인수로 받아 boolean을 리턴한다.
	 * T형식의 객체를 사용하는 boolean 표현식이 필요한 상황에서 Predicate인터페이스를 사용 할 수 있다.
	 * @param list
	 * @param p
	 * @return
	 */
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for(T s : list) {
			if(p.test(s)) {
				results.add(s);
			}
		}
		return results;
	}
	/**
	 * java.util.function.Consumer<T> 인터페이스는 제네릭 형식 T객체를 받아서 void를 반환하는 accept 추상 메서드를 정의한다.
	 * T 형식의 객체를 받아서 어떤 동작을 수행하고 싶을 때 Consumer 인터페이스를 사용할 수 있다.
	 * @param list
	 * @param c
	 */
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for(T t : list) {
			c.accept(t);
		}
	}
	
	/**
	 * java.util.function.Funtion<T,R> 인터페이스는 제네릭 형식 T를 인수로 받아서 제네릭 형식 R 객체를 반환하는 apply라는 추상 메서드를 정의한다.
	 * 입력을 출력으로 매핑하는 람다를 정의할 때 Function 인터페이스를 활용 할 수 있다.
	 * @param list
	 * @param f
	 * @return
	 */
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for(T t : list) {
			result.add(f.apply(t));
		}
		return result;
	}
	
}