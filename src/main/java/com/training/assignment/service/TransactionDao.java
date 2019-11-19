package com.training.assignment.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.training.assignment.model.News;
import com.training.assignment.model.Trader;
import com.training.assignment.model.Transaction;

public class TransactionDao {
	
	public static List<Transaction> getTransactionDetails(){
		Transaction t1, t2, t3, t4, t5;
		t1 = new Transaction(new Trader("Anagha", "Pune"), 2011, 5000);
		t2 = new Transaction(new Trader("Priya", "Mumbai"), 2011, 10000);
		t3 = new Transaction(new Trader("Aradhya", "Delhi"), 2010, 15000);
		t4 = new Transaction(new Trader("Veda", "Kanchi"), 2005, 5000);
		t5 = new Transaction(new Trader("Rudra", "Chennai"), 2012, 50000);


		List<Transaction> transactionList = new ArrayList<Transaction>();
		transactionList.add(t1);
		transactionList.add(t2);
		transactionList.add(t3);
		transactionList.add(t4);
		transactionList.add(t5);
		
		return transactionList;
	}
	
	public List<Transaction> findAllTransactionInPurticularYear(List<Transaction> transactionList){
		List<Transaction> list = transactionList.stream()
		.filter(transaction -> transaction.getYear().equals(2011))
		.sorted((t1,t2)-> {
			int result = Integer.compare(t1.getYear(), t2.getYear());
			if(result==0)
				return Integer.compare(t1.getValue(), t2.getValue());
			return result;
			
		}).collect(Collectors.toList());
		
		list.forEach(System.out::println);
		
		return list;
		
	}
	
	public List<Transaction> printAllTransactionFromTraderLiveInDelhi(List<Transaction> transactionList){
		List<Transaction> list = transactionList.stream()
		.filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("delhi"))
		.collect(Collectors.toList());
		
		list.forEach(System.out::println);
		
		return list;	
	}
	
	public int getHighestValueFromAllTransaction(List<Transaction> transactionList) {
		OptionalInt maxValue = transactionList.stream().mapToInt(transaction -> transaction.getValue()).max();
		int result = 0;
		if(maxValue.isPresent()) {
			result = maxValue.getAsInt();
			System.out.println("Max value from all Transaction:"+result);
		}
		else {
			System.out.println("No max value found");
		}
		return result;	
	}
	
	public int getSmallestValueFromAllTransaction(List<Transaction> transactionList) {
		OptionalInt minValue = transactionList.stream().mapToInt(transaction -> transaction.getValue()).min();
		int result = 0;
		if(minValue.isPresent()) {
			result = minValue.getAsInt();
			System.out.println("Min value from all Transaction:"+result);
		}
		else {
			System.out.println("No min value found");
		}
		return result;	
	}
	
	
	public List<Transaction> getAllTransactionHavingMinValue(List<Transaction> transactionList){

		OptionalInt minValue = transactionList.stream().mapToInt(transaction -> transaction.getValue()).min();
		
		List<Transaction> result = transactionList.stream()
		.filter(t->t.getValue().equals(minValue.getAsInt())).collect(Collectors.toList());
		System.out.println(result);
		return result;
	}
	
	

}
