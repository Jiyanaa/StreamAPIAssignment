package com.training.assignment.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.training.assignment.model.Trader;
import com.training.assignment.service.TraderDao;

public class TraderDaoTest {

	TraderDao traderObject = new TraderDao();
	List<Trader> traderList;
	Trader trader1,trader2,trader3,trader4,trader5,trader6;
	@Before
	public void setup() {
		trader1 = new Trader("Anagha", "Mumbai");
		trader2 = new Trader("Veda","Pune");
		trader3 = new Trader("Priya","Indore");
		trader4 = new Trader("Rudra", "Delhi");
		trader5 = new Trader("Ansh","delhi");
		trader6 = new Trader("Anjum","Pune");

		
		traderList = new ArrayList<Trader>();
		traderList.add(trader1);
		traderList.add(trader2);
		traderList.add(trader3);
		traderList.add(trader4);
		traderList.add(trader5);
		traderList.add(trader6);
		
	}
	
	@Test
	public void testForDisplayAllUniqueCityWhereTraderWork() {
		List<String> actual = traderObject.getAllUniqueCitiesWhereTraderWords(traderList);
		List<String> expected = new ArrayList<String>(Arrays.asList("mumbai","pune","indore","delhi"));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testForAllTraderWorkInPuneSortByName() {
		List<Trader> actual = traderObject.findAllTraderWorkInPuneSortByTheirName(traderList);
		List<Trader> expected = new ArrayList<Trader>(Arrays.asList(trader6,trader2));
		assertEquals(expected, actual);
	}

	@Test
	public void testForReturnAllTraderNamesInAlphabeticalOrder() {
		List<String> actual = traderObject.printStringOfAllTradersNameInAplphabeticalOrder(traderList);
		
		List<String> expected = new ArrayList<String>(Arrays.asList("Anagha","Anjum","Ansh","Priya","Rudra","Veda"));
		assertEquals(expected, actual);
	}
	
	@Test
	public void testForCheckingIsAnyTraderBasedInIndore() {
		boolean actual = traderObject.checkIsAnyTraderWhichBasedInIndore(traderList);
		assertEquals(true, actual);
	}

}
