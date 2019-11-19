package com.training.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.training.assignment.model.News;
import com.training.assignment.model.Trader;

public class TraderDao {
	
	public List<Trader> getAllTraderDetails(){
		Trader trader1 = new Trader("Anagha", "Mumbai");
		Trader trader2 = new Trader("Veda","Pune");
		Trader trader3 = new Trader("Priya","Indore");
		Trader trader4 = new Trader("Rudra", "Delhi");
		Trader trader5 = new Trader("Ansh","delhi");
		
		List<Trader> traderList = new ArrayList<Trader>();
		traderList.add(trader1);
		traderList.add(trader2);
		traderList.add(trader3);
		traderList.add(trader4);
		traderList.add(trader5);
		return traderList;
	}
	
	
	public List<String> getAllUniqueCitiesWhereTraderWords(List<Trader> traderList) {
		List<String> cityList = traderList.stream()
		.map(trader->trader.getCity().toLowerCase()).distinct().collect(Collectors.toList());
		
		cityList.forEach(System.out::println);
		return cityList;
	}
	
	public List<Trader> findAllTraderWorkInPuneSortByTheirName(List<Trader> traderList){
		List<Trader> list = traderList.stream()
		.filter(trader -> trader.getCity().equalsIgnoreCase("PUNE"))
		.sorted((t1,t2) -> {
			int result  = t1.getName().compareTo(t2.getName());
			if(t1.getName().equalsIgnoreCase(t2.getName()))
				return t1.getCity().compareTo(t2.getCity());
			return result;
		})
		.collect(Collectors.toList());
		
		list.forEach(System.out::println);
		return list;
	}
	
	public List<String> printStringOfAllTradersNameInAplphabeticalOrder(List<Trader> traderList) {
		List<String> actualResult = 
				traderList.stream()
				.sorted((t1,t2) -> {
					int result = t1.getName().compareToIgnoreCase(t2.getName());
					if(t1.getName().equals(t2.getName()))
						return t1.getCity().compareToIgnoreCase(t2.getCity());
					return result;
		
				})
				.map(trader -> trader.getName().toString())
				.collect(Collectors.toList());
		
		System.out.println(actualResult);
		
		return actualResult;
	}
	
	public boolean checkIsAnyTraderWhichBasedInIndore(List<Trader> traderList){		
		boolean result = traderList.stream()
				.anyMatch(trader -> trader.getCity().equalsIgnoreCase("Indore"));
		System.out.println(result);
		return result;
	}

}
