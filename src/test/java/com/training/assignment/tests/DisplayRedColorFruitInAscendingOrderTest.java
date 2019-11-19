package com.training.assignment.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.training.assignment.exception.EmptyListException;
import com.training.assignment.model.Fruit;
import com.training.assignment.service.FruitDao;

public class DisplayRedColorFruitInAscendingOrderTest {
	
	FruitDao displayFruits = new FruitDao(); 
	Fruit fruit1,fruit2,fruit3,fruit4,fruit5,fruit6;
	List<Fruit> fruitList;
	
	@Before 
	public void setup() {
		fruit1 = new Fruit("Mango", 200, 200,"Yellow");
		fruit2 = new Fruit("Apple", 50, 300, "Red");
		fruit3 = new Fruit("PineApple", 100, 300, "Yellow");
		fruit4 = new Fruit("Chickoo", 70, 200, "Brown");
		fruit5 = new Fruit("Guava", 100, 300, "Green");
		fruit6 = new Fruit("Lichi",50, 400, "Red");


		fruitList = new ArrayList<Fruit>();
		fruitList.add(fruit1);
		fruitList.add(fruit2);
		fruitList.add(fruit3);
		fruitList.add(fruit4);
		fruitList.add(fruit5);
		fruitList.add(fruit6);
	}
	
	@Test
	public void displayRedColorFruitInAscendingOrderOfTheirPrice() throws EmptyListException{
		List<Fruit> actual = displayFruits.displayOnlyREDColorFruitSortedBasedOnTheirPrice(fruitList);	
		List<Fruit> expected = new ArrayList<Fruit>(Arrays.asList(fruit2,fruit6));
		assertEquals(expected, actual);
	}
	
	@Test(expected = EmptyListException.class)
	public void displayRedColorFruitFromEmptyList() throws EmptyListException{
		List<Fruit> fruits = new ArrayList<Fruit>();
		List<Fruit> actual = displayFruits.displayOnlyREDColorFruitSortedBasedOnTheirPrice(fruits);	
	}

}
