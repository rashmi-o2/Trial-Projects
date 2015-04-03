package com.cts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.cts.exception.ToppingNotFound;
import com.cts.model.Pizza;

public class PizzaPrice {
	
	private Map<String, List<Integer>> pizzas;

	private Map<String, List<String>> pizzasWithToppings;
	
	private	Map<String, List<Integer>> toppingsWithPrice;
	
	private Pizza pizza;
	
	public PizzaPrice()
	{
		pizza= new Pizza();
		pizzas= pizza.getPizzas();
	}
	
	public Integer calculatePizzaPrice(String pizzaName, String size, List<String> additionalToppings)
	{
		Integer pizzaPrice = 0;
		Integer toppingsPrice =0;
		pizzasWithToppings = pizza.getPizzasWithToppings();
		List<String> toppings =  new ArrayList<String>();
		int pizzaSize = 0 ;
		toppings.addAll(additionalToppings);
		toppings.addAll(pizzasWithToppings.get(pizzaName));
		
		if(size.equals("Small"))
			pizzaSize=0;
		else if(size.equals("Medium"))
			pizzaSize=1;
		else if(size.equals("Large"))
			pizzaSize=2;
		
		pizzaPrice = pizzas.get(pizzaName).get(pizzaSize);
		toppingsPrice = calculateToppinsPrice(toppings,pizzaSize);
		pizzaPrice += toppingsPrice;
		return pizzaPrice;
	}
	
	public Integer calculateToppinsPrice(List<String> toppings, int size)
	{
		Integer toppingsPrice =0;
		toppingsWithPrice= pizza.getToppings().getToppingsWithPrice();
		for(String topping: toppings)
		{
			if(!(toppingsWithPrice.get(topping) == null))
				toppingsPrice += toppingsWithPrice.get(topping).get(size);
			else
				throw new ToppingNotFound("Topping Not Found");
		}
		return toppingsPrice;
	}

	public Map<String, List<Integer>> getPizzas() {
		return pizzas;
	}
	
}
