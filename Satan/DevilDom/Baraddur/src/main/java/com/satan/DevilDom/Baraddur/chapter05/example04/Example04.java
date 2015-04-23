package com.satan.DevilDom.Baraddur.chapter05.example04;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example04 {
	public static void main(String[] args) {
		//createStreamViaStreamOf();
		//createStreamViaArrays();
		//createStreamViaFile();
		//createInfinityDataViaIterator();
		createInfinityDataViaGenerate();
	}

	public static void createStreamViaStreamOf() {
		//Stream.of를 통해 스트림 생성
		Stream<String> stream = Stream.of("Java8", "Lambdas ", "In ", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);
		
		//Stream.empty()를 통해 빈 스트림을 생성할수 있다.
		Stream<String> emptyStream = Stream.empty();
	}
	
	public static void createStreamViaArrays() {
		//Arrays.stream을 통해서 배열을 스트림으로 만들 수 있다.
		int[] numbers = {2,3,4,5,6,7};
		//Arrays.stream을 이용해서 IntStream을 생성 할 수 있다.
		int sum = Arrays.stream(numbers).sum();
		System.out.println(sum);
	}
	
	public static void createStreamViaFile() {
		// stream을 사용해서 ttt.txt의 단어의 갯수를 샐 수 있다.
		try{
			//Files.lines는 파일의 행을 Stream으로 반환한다.
			Stream<String> lines = Files.lines(Paths.get("E:\\ttt.txt"), Charset.defaultCharset());
			long uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))	//flatMap을 통해서 각 라인의 행들의 단어를 구하고 계산한다.
					.distinct()
					.count();
			System.out.println(uniqueWords);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void createInfinityDataViaIterator() {
		//iterate를 통해서 스트림을 만든다.
		// iterate는 요청할 때마다 값을 생산 할 수 있으며 끝이 없으므로 무한 스트림을 만든다. 이러한 스트림을 언바운드 스트림(unbounded stream)이라 한다.
		Stream.iterate(0, n -> n + 2)
				.limit(10)
				.forEach(System.out::println);
	}
	
	public static void createInfinityDataViaGenerate() {
		// iterate와 다르게 각값을 연속적으로 계산하지 않고 Supplier<T>를 인수로 받아서 새로운 값을 계속 생성한다.
		Stream.generate(Math::random)
		.limit(5)
		.forEach(System.out::println);
	}
}
