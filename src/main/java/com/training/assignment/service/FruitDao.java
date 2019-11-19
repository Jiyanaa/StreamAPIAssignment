package com.training.assignment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.training.assignment.exception.EmptyListException;
import com.training.assignment.model.Fruit;

public class FruitDao {
	
	public static List<Fruit> getAllFruits(){
		Fruit fruit1 = new Fruit("Mango", 200, 200,"Yellow");
		Fruit fruit2 = new Fruit("Apple", 50, 100, "Red");
		Fruit fruit3 = new Fruit("PineApple", 100, 300, "Yellow");
		Fruit fruit4 = new Fruit("Chickoo", 70, 200, "Brown");
		Fruit fruit5 = new Fruit("Guava", 100, 300, "Green");

		List<Fruit> fruitList = new ArrayList<Fruit>();
		fruitList.add(fruit1);
		fruitList.add(fruit2);
		fruitList.add(fruit3);
		fruitList.add(fruit4);
		fruitList.add(fruit5);
		
		return fruitList;
	}
	
	public List<String> displayFruitNameOfLowCaloriesInDescOrder(List<Fruit> fruits) throws EmptyListException {
		if(fruits.isEmpty()) {
			throw new EmptyListException("List is empty");
		}
		
		List<String> nameList = fruits.stream()
		.filter(fruit -> fruit.getCalories()<100)
		.sorted((f1,f2)->{
			int result = Integer.compare(f2.getCalories(), f1.getCalories());
			if(result==0)
				return Integer.compare(f1.getPrice(), f2.getPrice());
			return result;
		})
		.map(fruit -> fruit.getName()).collect(Collectors.toList());
		
		nameList.forEach(System.out :: println);
		return nameList;	
	}

	
	public List<String> displayListOfFruitNameBasedOnColor(List<Fruit> fruits,String fruitColor) throws EmptyListException{
		if(fruits.isEmpty()) {
			throw new EmptyListException("List is empty");
		}
		
		List<String> nameList = fruits.stream()
		.filter(fruit -> fruit.getColor().equalsIgnoreCase(fruitColor))
		.map(fruit -> fruit.getName()).collect(Collectors.toList());
		
		if(nameList.isEmpty())
			System.out.println("No fruit found of color "+fruitColor);
		else
			nameList.forEach(System.out :: println);
		return nameList;	
	}
	
	public List<Fruit> displayOnlyREDColorFruitSortedBasedOnTheirPrice(List<Fruit> fruits) throws EmptyListException{
		if(fruits.isEmpty()) {
			throw new EmptyListException("List is empty");
		}
		
		List<Fruit> fruitList = fruits.stream()
				.filter(fruit -> fruit.getColor().equalsIgnoreCase("RED"))
				.sorted((f1,f2) -> {
					int result = Integer.compare(f1.getPrice(), f2.getPrice());
					if(result==0)
						return f1.getName().compareTo(f2.getName());
					return result;
				}).collect(Collectors.toList());
		
		fruitList.forEach(System.out::println);
		return fruitList;
		
	}
	
	
	//display fruits based on each color in list
	public static Function< ArrayList<Fruit>, HashMap<String, ArrayList<String>>> fruitNamesByColor = (Fruits) -> {

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        Fruits.stream()
              .forEach(fruit -> {
                  if (map.containsKey(fruit.getColor())) {
                      ArrayList<String> obj = map.get(fruit.getColor());
                      obj.add(fruit.getName());
                      map.put(fruit.getColor(), obj);
                  } else {
                      ArrayList<String> obj = new ArrayList<String>();
                      obj.add(fruit.getName());
                      map.put(fruit.getColor(), obj);
                  }
              });
        
        System.out.println(map);
        return map;
    };
	
	
}
