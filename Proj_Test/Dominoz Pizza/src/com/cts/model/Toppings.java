package com.cts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Toppings {
	
	private Map<String, List<Integer>> toppingsWithPrice;
	
	public Toppings(){
		toppingsWithPrice=new HashMap<String, List<Integer>>();
		populateToppings();
	}
	
	public Map<String, List<Integer>> getToppingsWithPrice() {
		return toppingsWithPrice;
	}

	public void populateToppings()
	{
		toppingsWithPrice.put("Tomato", new ArrayList<Integer>(Arrays.asList(10,20,30)));
		toppingsWithPrice.put("Jalepino", new ArrayList<Integer>(Arrays.asList(10,20,30)));
		toppingsWithPrice.put("Olive", new ArrayList<Integer>(Arrays.asList(20,35,50)));
		toppingsWithPrice.put("Paneer", new ArrayList<Integer>(Arrays.asList(20,35,50)));
		toppingsWithPrice.put("Capsicum", new ArrayList<Integer>(Arrays.asList(10,20,30)));
		toppingsWithPrice.put("Corn", new ArrayList<Integer>(Arrays.asList(10,20,30)));
		toppingsWithPrice.put("Cheese", new ArrayList<Integer>(Arrays.asList(30,45,60)));
	}
	

}
