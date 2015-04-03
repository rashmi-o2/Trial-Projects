package com.cts.input;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

import com.cts.exception.PizzaNotFound;
import com.cts.exception.ToppingNotFound;


public class TestOrder {
	
	@Test
	public void testChargeCustomer()
	{
		Integer pizzaPrice= 220;
		Order order=  new Order("Cheese N Tamato", "Small", new ArrayList<String>(Arrays.asList("Cheese")));
		Assert.assertEquals(pizzaPrice, order.chargeCustomer(order));
	}
	
	
	@Test(expected = PizzaNotFound.class)  
	public void testPizzaNotFoundException() {  
		new Order("Chees N Tamato", "Small", new ArrayList<String>(Arrays.asList("Cheese")));
	}
	
	@Test(expected = ToppingNotFound.class)  
	public void testToppingNotFoundException() {  
		Order order=  new Order("Cheese N Tamato", "Small", new ArrayList<String>(Arrays.asList("Chees")));
		order.chargeCustomer(order);
	}
}
