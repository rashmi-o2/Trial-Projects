package com.superhero;

import java.util.*;

public class SuperHeroMapping {

	public List<String> superHeroList;
	
	public Map<String, List<String>> keypadMap;
	
	public SuperHeroMapping(List<String> superHeros) {
		superHeroList = superHeros;
		keypadMap = new HashMap<String, List<String>>();
		keypadMap.put("0", new ArrayList<String>(Arrays.asList("")));
		keypadMap.put("1", new ArrayList<String>(Arrays.asList("@",".","?")));
		keypadMap.put("2", new ArrayList<String>(Arrays.asList("A","B","C")));
		keypadMap.put("3", new ArrayList<String>(Arrays.asList("D","E","F")));
		keypadMap.put("4", new ArrayList<String>(Arrays.asList("G","H","I")));
		keypadMap.put("5", new ArrayList<String>(Arrays.asList("J","K","L")));
		keypadMap.put("6", new ArrayList<String>(Arrays.asList("M","N","O")));
		keypadMap.put("7", new ArrayList<String>(Arrays.asList("P","Q","R","S")));
		keypadMap.put("8", new ArrayList<String>(Arrays.asList("T","U","V")));
		keypadMap.put("9", new ArrayList<String>(Arrays.asList("W","X","Y","Z")));
	}

}
