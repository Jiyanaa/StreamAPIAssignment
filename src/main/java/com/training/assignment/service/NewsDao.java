package com.training.assignment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.training.assignment.model.Fruit;
import com.training.assignment.model.News;

public class NewsDao {
	
	public static List<News> getNewsDetails(){
		News news1 = new News(101, "three", "Anagha", "budget news");
		News news2 = new News(101, "four", "Priya","This  is budget comment");
		News news3 = new News(103, "three", "Rudra","This news is about budget");
		News news4 = new News(104, "two", "Jiya", "This is budget");
		News news5 = new News(102, "one", "Ansh", "This comment is not comment");

		List<News> newsList = new ArrayList<News>();
		newsList.add(news1);
		newsList.add(news2);
		newsList.add(news3);
		newsList.add(news4);
		newsList.add(news5);
		
		return newsList;
	}
	
	public int findNewsIdWhichHaveMaxComments(List<News> newsList){
		
		return 0;
	}
	
	public long countWordBudgetInComments(List<News> newsList) {
		long counter= newsList.stream().map(w -> w.getComment().split("\\s+")).flatMap(Arrays::stream).filter(s->s.contains("budget")).count();
		 System.out.println("Budget word count::"+counter);
		 
		return counter;
	}
	
	public  Map <String, Integer> countOccurenceOfEachWordInComments(List<News> newsList){
		 List <String> list = newsList.stream().map(w -> w.getComment().split("\\s+")).flatMap(Arrays::stream)
		            .collect(Collectors.toList());
		 
		 Map <String, Integer> wordCounter = list.stream()
		            .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
		 
		 System.out.println(wordCounter);
		 
		 return wordCounter;
		 
	}
	
	

}
