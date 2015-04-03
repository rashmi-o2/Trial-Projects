package com.cts.main;

import java.util.ArrayList;
import java.util.Arrays;

import com.cts.input.Order;

public class PizzaMain {
	
	public static void main(String[] args) {
		
		Order order = new Order("Cheese N Tamato", "Small", new ArrayList<String>(Arrays.asList("Cheese")));
		Integer pizzaPrice= order.chargeCustomer(order);
		System.out.println("pizzaPrice::"+pizzaPrice);
	}

}
