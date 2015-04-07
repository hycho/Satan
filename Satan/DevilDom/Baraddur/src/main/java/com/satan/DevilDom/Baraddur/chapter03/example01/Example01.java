package com.satan.DevilDom.Baraddur.chapter03.example01;

public class Example01 {
	public static void main(String[] args) {
		// 람다 사용.
		Runnable r1 = () -> System.out.println("Hello world");
		
		// 익명 클래스를 사용.
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World 2");
			}
		};
		
		process(r1);
		process(r2);
		process(() -> System.out.println("Hello world 3"));
	}
	
	public static void process(Runnable r) {
		r.run();
	}
}
