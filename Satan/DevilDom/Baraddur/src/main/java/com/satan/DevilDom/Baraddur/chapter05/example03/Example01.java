package com.satan.DevilDom.Baraddur.chapter05.example03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import com.satan.DevilDom.Baraddur.chapter04.model.Dish;

public class Example01 {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
			new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000),
			new Transaction(raoul, 2011, 400),
			new Transaction(mario, 2012, 710),
			new Transaction(mario, 2012, 700),
			new Transaction(alan, 2012, 950)
		);
		
		//quiz1(transactions);
		//quiz2(transactions);
		//quiz3(transactions);
		//quiz4(transactions);
		//quiz5(transactions);
		//quiz6(transactions);
		//quiz7(transactions);
		quiz8(transactions);
	}
	
	// <Quiz1> 2011년에 일어난 모든 트랜잭션을 찾아 값을  오름차순으로 정리하시오.
	public static void quiz1(List<Transaction> transactions) {
		List<Transaction> sortedTransaction = 
		transactions.stream()
					.filter(t->t.getYear() == 2011)
					.sorted(Comparator.comparing(Transaction::getValue))
					.collect(toList());
		
		for(Transaction t : sortedTransaction) {
			System.out.println(t.getValue());
		}
	}
	
	// <Quiz2> 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
	public static void quiz2(List<Transaction> transactions) {
		List<String> distinctCitys =
		transactions.stream()
					.map(t -> t.getTrader().getCity())
					.distinct()
					.collect(toList());
		
		for(String t : distinctCitys) {
			System.out.println(t);
		}
	}
	
	// <Quiz3> Cambridge에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬 하시오.
	public static void quiz3(List<Transaction> transactions) {
		List<Transaction> sortedTransaction = 
		transactions.stream()
					.filter(x->x.getTrader().getCity().equals("Cambridge"))
					.sorted(Comparator.comparing((Transaction t) -> t.getTrader().getName()))
					.collect(toList());
		
		for(Transaction t : sortedTransaction) {
			System.out.println(t.toString());
		}
	}
	
	// <Quiz4> 모든 거래자의 이름을 아파벳순으로 정렬해서 반환하시오.
	public static void quiz4(List<Transaction> transactions) {
		String result = 
		transactions.stream()
					.map(t -> t.getTrader().getName())
					.distinct()
					.sorted()
					.reduce("", (a, b)->a + "," + b);
		
		System.out.println(result);
	}
	
	// <Quiz5> 밀라노에 거래자가 있나?
	public static void quiz5(List<Transaction> transactions) {
		Optional<Transaction> c = 
		transactions.stream()
					.filter(x->x.getTrader().getCity().equals("Milan"))
					.findAny();
		
		//anymatch를 통해서 아래처럼 구현가능
		transactions.stream()
					.anyMatch(x->x.getTrader().getCity().equals("Milan"));;
					
		System.out.println(c.isPresent());
	}
	
	// <Quiz6> 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
	public static void quiz6(List<Transaction> transactions) {
		List<Integer> t = 
		transactions.stream()
					.filter(x->x.getTrader().getCity().equals("Cambridge"))
					.map(x->x.getValue())
					.collect(toList());
		
		for(Integer c : t) {
			System.out.println(c);
		}
	}
	
	// <Quiz7> 전체 트랜잭션 중 최대값은 얼마인가?
	public static void quiz7(List<Transaction> transactions) {
		System.out.println(transactions.stream()
					.map(x->x.getValue())
					.reduce(Integer::max)
		);
	}
	
	// <Quiz8> 전체 트랜잭션 중 최소값은 얼마인가?
		public static void quiz8(List<Transaction> transactions) {
			System.out.println(transactions.stream()
						.map(x->x.getValue())
						.reduce(Integer::min)
			);
		}
}
