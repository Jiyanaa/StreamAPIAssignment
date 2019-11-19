package com.training.assignment.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.training.assignment.exception.EmptyListException;
import com.training.assignment.model.Fruit;
import com.training.assignment.service.FruitDao;

public class DisplayFruitNameOfLowCaloriesTest {
	
	FruitDao displayFruits = new FruitDao(); 
	Fruit fruit1,fruit2,fruit3,fruit4,fruit5;
	List<Fruit> fruitList;
	
	@Before 
	public void setup() {
		fruit1 = new Fruit("Mango", 200, 200,"Yellow");
		fruit2 = new Fruit("Apple", 50, 100, "Red");
		fruit3 = new Fruit("PineApple", 100, 300, "Yellow");
		fruit4 = new Fruit("Chickoo", 70, 200, "Brown");
		fruit5 = new Fruit("Guava", 100, 300, "Green");

		fruitList = new ArrayList<Fruit>();
		fruitList.add(fruit1);
		fruitList.add(fruit2);
		fruitList.add(fruit3);
		fruitList.add(fruit4);
		fruitList.add(fruit5);
	}
	
	@Test
	public void displayFruitNameOfLowCaloriesInDescOrder() throws EmptyListException{
		List<String> actual = displayFruits.displayFruitNameOfLowCaloriesInDescOrder(fruitList);	
		List<String> expected = new ArrayList<String>(Arrays.asList("Chickoo","Apple"));	
		assertEquals(expected, actual);
		
	}
	
	@Test(expected = EmptyListException.class)
	public void displayFruitNameForInvalidInput() throws EmptyListException {
		List<Fruit> fruits = new ArrayList<Fruit>();
		List<String> actual = displayFruits.displayFruitNameOfLowCaloriesInDescOrder(fruits);	
	}
	
	

}
