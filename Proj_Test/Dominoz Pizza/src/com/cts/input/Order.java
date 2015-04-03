package com.cts.input;

import java.util.List;
import java.util.Map;
import com.cts.exception.PizzaNotFound;
import com.cts.service.PizzaPrice;


public class Order {
	
	private PizzaPrice pizzaPrice;
	private String  pizzaName;
	private String size;
	private List<String> additionalToppings;
	Order order;
	
	public Order()
	{
		
	}
	public Order(String pizzaName, String size, List<String> additionalToppings)
	{
		this.pizzaPrice= new PizzaPrice();
		this.pizzaName = pizzaName;
		this.size= size;
		this.additionalToppings= additionalToppings;
		checkOrder();
	}

	public void checkOrder()
	{
		Map<String, List<Integer>> pizzas= pizzaPrice.getPizzas();
		if(pizzas.get(pizzaName) ==null)
			throw new PizzaNotFound("Pizza Not Found");
	}
	
	public Integer chargeCustomer(Order order)
	{
		return pizzaPrice.calculatePizzaPrice(order.pizzaName, order.size, order.additionalToppings);
	}
	
}
