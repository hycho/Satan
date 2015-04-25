package com.satan.DevilDom.Baraddur.chapter06.example01;

import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.satan.DevilDom.Baraddur.chapter06.model.Trader;
import com.satan.DevilDom.Baraddur.chapter06.model.Transaction;

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
	}
	
	public static void firstCollectSample(List<Transaction> transactions) {
		Map<Trader, List<Transaction>> m = 
		transactions.stream()
			.collect(groupingBy(Transaction::getTrader));	//트레이너 별로 트렌젝션리스트를 Map으로 그룹화 해서 보여준다.
	}
}
