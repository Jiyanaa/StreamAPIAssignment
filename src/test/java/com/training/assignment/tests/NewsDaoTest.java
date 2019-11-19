package com.training.assignment.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.training.assignment.model.News;
import com.training.assignment.service.NewsDao;

public class NewsDaoTest {
	NewsDao newsObject = new NewsDao();
	
	News news1,news2,news3,news4,news5;
	List<News> newsList;
	
	@Before 
	public void setup() {
		news1 = new News(101, "three", "Anagha", "budget news");
		news2 = new News(101, "four", "Priya","This  is budget comment");
		news3 = new News(103, "three", "Rudra","This news is about budget");
		news4 = new News(104, "two", "Jiya", "This is budget");
		news5 = new News(105, "one", "Ansh", "This comment is not comment");

		newsList = new ArrayList<News>();
		newsList.add(news1);
		newsList.add(news2);
		newsList.add(news3);
		newsList.add(news4);
		newsList.add(news5);
		
	}
	
	
	@Test
	public void testForFindNewsIdWhichHaveMaxComments() {
		int result = newsObject.findNewsIdWhichHaveMaxComments(newsList);
	}
	
	
	@Test
	public void testForFindBudgetWordInNews() {
		long result = newsObject.countWordBudgetInComments(newsList);
		assertEquals(4, result);
	}
	
	@Test
	public void testForDisplayAllWordCountFromComments() {
		Map <String, Integer> actual = newsObject.countOccurenceOfEachWordInComments(newsList);
		
		Map<String,Integer> expected = new HashMap<String, Integer>(){
			{
				put("news",2);
				put("not",1);
				put("about",1);
				put("this",4);
				put("comment",3);
				put("is",4);
				put("budget",4);
			}
		};
		
		assertEquals(expected, actual);
		
		
	
	}

}
