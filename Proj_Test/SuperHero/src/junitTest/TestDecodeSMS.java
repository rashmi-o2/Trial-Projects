package junitTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import com.superhero.DecodeSMS;
import com.superhero.SuperHeroMapping;

public class TestDecodeSMS {

	DecodeSMS decode = new DecodeSMS();
	
	@Test
	public void testFindSuperHero() {
		List<String> list = new ArrayList<String>();
		list.add("THOR");
		list.add("HULK");
		list.add("ROBIN");
		list.add("IRONMAN");
		list.add("GHOSTRIDER");
		list.add("CAPTAINAMERICA");
		list.add("FLASH");
		list.add("WOLVERINE");
		list.add("BATMAN");
		list.add("SUPERMAN");
		list.add("BLADE");
		list.add("SUPERMAN");
		list.add("PHANTOM");
		list.add("SPIDERMAN");
		list.add("BLACKWIDOW");
		list.add("HELLBOY");
		list.add("PUNISHER");
		SuperHeroMapping heroMapping = new SuperHeroMapping(list);
		assertEquals("HULK",decode.findSuperHero("0 4855"));
	}
}
