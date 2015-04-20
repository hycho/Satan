package com.satan.DevilDom.Baraddur.chapter05.example02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import com.satan.DevilDom.Baraddur.chapter04.model.Dish;

public class Example01 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		//basicForEach(numbers);
		sumViaReduce(numbers);
	}
	
	// reduce를 통한 합
	public static void sumViaReduce(List<Integer> numbers) {
		//reduce 1param : 초기값, 2param BinaryOperator<T>
		int sum = numbers.stream().reduce(0, (a, b) -> a + b);
		int sum1 = numbers.stream().reduce(0, Integer::sum);	//Integer Sum static 메소드 제공
		int multiply = numbers.stream().reduce(1, (a, b) -> a * b);
		
		System.out.println(sum);
		System.out.println(sum1);
		System.out.println(multiply);
	}
	
	// foreach를 통한 sum
	public static void basicForEach(List<Integer> numbers) {
		int sum = 0;
		for(int x : numbers) {
			sum += x;
		}
		System.out.println(sum);
	}
}
