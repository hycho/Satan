package com.satan.DevilDom.Baraddur.chapter05.example02;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Example02 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(15,5,3,9);
		
		printMaxMin(numbers);
	}
	
	// reduce를 통해서 최대/최소값 구하기
	public static void printMaxMin(List<Integer> numbers) {
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		Optional<Integer> min = numbers.stream().reduce(Integer::min);
		System.out.println("Max = " + max.get());
		System.out.println("Min = " + min.get());
	}
	
	
}
