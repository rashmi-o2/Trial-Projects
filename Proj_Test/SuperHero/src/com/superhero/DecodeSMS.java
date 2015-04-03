package com.superhero;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DecodeSMS {
	
	private SuperHeroMapping superHeroMapping;
	
	public DecodeSMS()
	{
		
	}
	
	public DecodeSMS(SuperHeroMapping superHeroMapping)
	{
		this.superHeroMapping = superHeroMapping;
	}
	
	public String getCodefromSMS(String sms)
	{
		return sms.substring(2);
	}
	
	
	public ArrayList<String> getValidSuperHeroList(String sms)
	{
		//superHeroMapping.createSuperHeroList();
		ArrayList<String> validSuperHeroList = new ArrayList<String>();
		int codeLen =sms.length()-2;
		for(String hero :superHeroMapping.superHeroList)
		{
			if(codeLen == hero.length())
				validSuperHeroList.add(hero);
		}
		return validSuperHeroList;
	}
	
	
	public String findSuperHero(String sms)
	{
		ArrayList<String> validSuperHeroList = getValidSuperHeroList(sms);
		String code = getCodefromSMS(sms);
		
		for(int i = 0, n = code.length() ; i < n ; i++) 
		{
			ListIterator<String> validHeroIterator = validSuperHeroList.listIterator();
			char codeCh = code.charAt(i);
			List<String> keyWords =  superHeroMapping.keypadMap.get(String.valueOf(codeCh));
			while(validHeroIterator.hasNext())
			{
					String hero= validHeroIterator.next();
				    char heroCh = hero.charAt(i); 
				    if(!(keyWords.contains(String.valueOf(heroCh))))
				    	validHeroIterator.remove();
			}
		}
			
		if(validSuperHeroList.size()>0)
			return validSuperHeroList.get(0);
		else
			return "Invalid Code";
		
	}
	
	public static void main(String[] args) {
		
		DecodeSMS decode = new DecodeSMS();
		System.out.println(decode.findSuperHero("0 4855"));
		System.out.println(decode.findSuperHero("0 228626"));
		System.out.println(decode.findSuperHero("0 78737626"));
		System.out.println(decode.findSuperHero("0 84670"));
		 
		 }
}
