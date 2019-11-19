package com.training.assignment.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.training.assignment.exception.EmptyListException;
import com.training.assignment.model.Fruit;
import com.training.assignment.service.FruitDao;

public class DisplayColorWiseFruitNameTest {


	FruitDao displayFruits = new FruitDao(); 
	Fruit fruit1,fruit2,fruit3,fruit4,fruit5,fruit6;
	List<Fruit> fruitList;
	
	@Before 
	public void setup() {
		fruit1 = new Fruit("Mango", 200, 200,"Yellow");
		fruit2 = new Fruit("Apple", 50, 100, "Red");
		fruit3 = new Fruit("PineApple", 100, 300, "Yellow");
		fruit4 = new Fruit("Cherry", 70, 200, "Red");
		fruit5 = new Fruit("Guava", 100, 300, "Green");
		fruit6 = new Fruit("Banana", 300, 50, "Yellow");

		fruitList = new ArrayList<Fruit>();
		fruitList.add(fruit1);
		fruitList.add(fruit2);
		fruitList.add(fruit3);
		fruitList.add(fruit4);
		fruitList.add(fruit5);
		fruitList.add(fruit6);
	}
	
	@Test
	public void testForToDisplayListOfFruitNameBasedOnColor() throws EmptyListException {
		String color = "Yellow";
		List<String> actual = displayFruits.displayListOfFruitNameBasedOnColor(fruitList,color);
		List<String> expected = new ArrayList<String>(Arrays.asList("Mango","PineApple","Banana"));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testForToDisplayFruitsNameWithNoFruitPresentInList() throws EmptyListException {
		String color = "Pink";
		List<String> actual = displayFruits.displayListOfFruitNameBasedOnColor(fruitList,color);
		List<String> expected = new ArrayList<String>();
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = EmptyListException.class)
	public void testForToDisplayFruitsNameFromEmptyList() throws EmptyListException {
		String color = "Pink";
		List<Fruit> fruitList = new ArrayList<Fruit>();
		List<String> actual = displayFruits.displayListOfFruitNameBasedOnColor(fruitList,color);		
	}
	
	
	//display names of all fruit based on color
	@Test
	public void testForDisplayfruitNamesByColor() {
		HashMap<String,ArrayList<String>> result = FruitDao.fruitNamesByColor.apply((ArrayList<Fruit>) fruitList);
	}
}
