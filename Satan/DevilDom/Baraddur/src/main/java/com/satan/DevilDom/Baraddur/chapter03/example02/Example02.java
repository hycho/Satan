package com.satan.DevilDom.Baraddur.chapter03.example02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Example02 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//일반
		System.out.println(processFile());
		//람다 사용
		System.out.println(processFile((BufferedReader br) -> br.readLine()));
		
		
	}

	/**
	 * C:\exampleData\data.txt의 한줄만 반환 하는 코드. 이것의 기존 설정, 정리과정은 재사용하고 proecssFile만 다른 동작을 수행하도록 할 수 없을까?
	 * 만약 람다를 사용한다면
	 * String result = processFile((BufferedReader br) -> br.readLine()) 형을 쓰면 되지 않을까? 
	 * 즉 BufferedReader -> String과 같은 시그너처를 가진 추상클래스를 가진 함수형인터페이스를 구현하고 그것을 processFile의 파라메터로 받게 하면 되지 않을까?
	 */
	public static String processFile() throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\exampleData\\data.txt"))) {
			return br.readLine();
		}
	}
	
	/**
	 * BufferedReader -> String 형태의 시그너처를 가질 함수 인터페이스 
	 * @author supejkf
	 */
	@FunctionalInterface
	public interface BufferedReaderProcessor {
		String process(BufferedReader br) throws IOException;
	}

	/**
	 * BufferedReaderProcess를 사용한 서비스 
	 * @param p
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String processFile(BufferedReaderProcessor p) throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\exampleData\\data.txt"))) {
			return p.process(br);
		}
	}
}
