package com.cts.service;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

public class TestPizzaPrice {
	
	
	@Test
	public void testCalculateToppinsPrice()
	{
		Integer toppingsPrice =55;
		PizzaPrice pizzaPrice= new PizzaPrice();
		Assert.assertEquals(toppingsPrice, pizzaPrice.calculateToppinsPrice( new ArrayList<String>(Arrays.asList("Tomato","Paneer")), 1));
		//assert toppingsPrice == pizzaPrice.calculateToppinsPrice( new ArrayList<String>(Arrays.asList("Tomato","Paneer")), 1);
	}
	
	@Test
	public void testCalculatePizzaPrice()
	{
		Integer price =220;
		PizzaPrice pizzaPrice= new PizzaPrice();
		Assert.assertEquals(price, pizzaPrice.calculatePizzaPrice("Cheese N Tamato", "Small", new ArrayList<String>(Arrays.asList("Cheese"))));
		//assert price == pizzaPrice.calculatePizzaPrice("Cheese N Tamato", "Small", new ArrayList<String>(Arrays.asList("Cheese")));
	}

}
