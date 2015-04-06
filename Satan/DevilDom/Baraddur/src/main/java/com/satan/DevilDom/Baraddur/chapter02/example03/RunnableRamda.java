package com.satan.DevilDom.Baraddur.chapter02.example03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.satan.DevilDom.Baraddur.chapter02.example01.Apple;

public class RunnableRamda {
	public static void main(String[] args) {

		// Runnable 익명 클래스를 사용해서 Hello world를 찍는다
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world!");
			}
		});
		t.run();
		
		Thread rT = new Thread(() -> System.out.println("Hello world!!"));
		rT.run();
	}
}
