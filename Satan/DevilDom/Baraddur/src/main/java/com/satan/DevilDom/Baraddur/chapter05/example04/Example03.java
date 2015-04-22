package com.satan.DevilDom.Baraddur.chapter05.example04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example03 {
	public static void main(String[] args) {
		//firstPita();
		firstPitaNew();
	}
	
	public static void firstPita() {
		Stream<int[]> pitas =  
		IntStream.rangeClosed(1, 100)
			.boxed()	//int를  integer로 boxing
			.flatMap(	//flatMap을 통해서 각각의 고유의 스트림으로 map로직을 동작시킨다고 보면된다.
				a -> IntStream.range(a, 100)	// 각각의 a부터 100까지의 수를 생성한다.
								.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)	//a*a + b*b의 제곱근을 1로 나누었을때 0인경우 정수라고 할 수 있다.
								.mapToObj(b -> new int[] {a, b, (int) Math.sqrt(a*a + b*b)})	//.boxed().map() 대신에 mapToObj를 사용 할 수 있다.
			);
		
		pitas.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
	}
	
	public static void firstPitaNew() {
		Stream<double[]> pitas =  
		IntStream.rangeClosed(1, 100)
			.boxed()	//int를  integer로 boxing
			.flatMap(	//flatMap을 통해서 각각의 고유의 스트림으로 map로직을 동작시킨다고 보면된다.
				a -> IntStream.range(a, 100)	// 각각의 a부터 100까지의 수를 생성한다.
								.mapToObj(b-> new double[] {a, b, Math.sqrt(a*a + b*b)})
								.filter(t -> t[2] % 1 == 0)
			);
		
		pitas.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
	}
}
