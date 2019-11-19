package com.training.assignment.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.training.assignment.model.Trader;
import com.training.assignment.model.Transaction;
import com.training.assignment.service.TransactionDao;

public class TransactionDaoTest {
	TransactionDao transactionObjcet = new TransactionDao();
	Transaction t1,t2,t3,t4,t5,t6;
	List<Transaction> transactionList;
	
	@Before
	public void setup() {
	
		t1 = new Transaction(new Trader("Anagha", "Pune"), 2011, 5000);
		t2 = new Transaction(new Trader("Priya", "delhi"), 2011, 10000);
		t3 = new Transaction(new Trader("Aradhya", "Delhi"), 2010, 15000);
		t4 = new Transaction(new Trader("Veda", "Mumbai"), 2005, 5000);
		t5 = new Transaction(new Trader("Rudra", "Chennai"), 2012, 50000);


		transactionList = new ArrayList<Transaction>();
		transactionList.add(t1);
		transactionList.add(t2);
		transactionList.add(t3);
		transactionList.add(t4);
		transactionList.add(t5);
		
		
	}

	@Test
	public void testToPrintAllTransactionInPurticularYear() {
		List<Transaction> actual = transactionObjcet.findAllTransactionInPurticularYear(transactionList);
		
		List<Transaction>  expected = new ArrayList<Transaction>(Arrays.asList(t1,t2));
		assertEquals(expected, actual);	
	}
	
	
	@Test
	public void testForPrintAllTransactionValuesFromTraderWhichLiveInDelhi() {
		List<Transaction> actual = transactionObjcet.printAllTransactionFromTraderLiveInDelhi(transactionList);	
		List<Transaction> expected = new ArrayList<Transaction>(Arrays.asList(t2,t3));	
		assertEquals(expected, actual);

	}
	@Test
	public void testToPrintMaxValueFromAllTransaction() {
		int actual = transactionObjcet.getHighestValueFromAllTransaction(transactionList);
		assertEquals(50000, actual);	
	}
	
	@Test
	public void testToPrintMinValueFromAllTransaction() {
		int actual = transactionObjcet.getSmallestValueFromAllTransaction(transactionList);
		assertEquals(5000, actual);	
	}
	
	@Test
	public void testToPrintAllTransactionHavingMinValue() {
		List<Transaction> actual = transactionObjcet.getAllTransactionHavingMinValue(transactionList);
	}

}
