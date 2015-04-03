package com.cts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pizza {
	
	
private Map<String, List<Integer>> pizzas;

private Map<String, List<String>> pizzasWithToppings;

private Toppings toppings;

public Toppings getToppings() {
	return toppings;
}


public Map<String, List<Integer>> getPizzas() {
	return pizzas;
}


public Map<String, List<String>> getPizzasWithToppings() {
	return pizzasWithToppings;
}

	
	public Pizza(){
		toppings = new Toppings();
		pizzas=new HashMap<String, List<Integer>>();
		pizzasWithToppings=new HashMap<String, List<String>>();
		populateMenu();
	}
	
	public void populateMenu()
	{
		populatePizzaPrice();
		populatePizzaToppings();
	}

	public void populatePizzaPrice()
	{
		pizzas.put("Margharita", new ArrayList<Integer>(Arrays.asList(150,200,250)));
		pizzas.put("Cheese N Tamato", new ArrayList<Integer>(Arrays.asList(150,200,250)));
		pizzas.put("Farmhouse", new ArrayList<Integer>(Arrays.asList(200,250,300)));
		pizzas.put("Veg Supreme", new ArrayList<Integer>(Arrays.asList(200,250,300)));
		pizzas.put("Mexican Green Wave", new ArrayList<Integer>(Arrays.asList(250,300,350)));
		pizzas.put("Peppy Paneer", new ArrayList<Integer>(Arrays.asList(250,300,350)));

	}
	
	public void populatePizzaToppings()
	{
		pizzasWithToppings.put("Margharita", new ArrayList<String>(Arrays.asList("Olive","Cheese","Tomato")));
		pizzasWithToppings.put("Cheese N Tamato", new ArrayList<String>(Arrays.asList("Cheese","Tomato")));
		pizzasWithToppings.put("Farmhouse", new ArrayList<String>(Arrays.asList("Cheese","Corn","Tomato","Jalepino")));
		pizzasWithToppings.put("Veg Supreme", new ArrayList<String>(Arrays.asList("Capsicum","Corn","Tomato")));
		pizzasWithToppings.put("Mexican Green Wave", new ArrayList<String>(Arrays.asList("Olive","Capsicum","Jalepino")));
		pizzasWithToppings.put("Peppy Paneer", new ArrayList<String>(Arrays.asList("Paneer","Capsicum")));
	}
	
}
