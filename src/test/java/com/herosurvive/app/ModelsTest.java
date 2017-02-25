package com.herosurvive.app;

import static org.junit.Assert.*;

import org.junit.Test;
import com.herosurvice.models.Entity;
import com.herosurvice.models.Hero;;


public class ModelsTest {

	@Test
	public void entityShouldInitialize() {
		Entity instance = new Entity();
		assertEquals(0, instance.position);
		
	}
	
	@Test
	public void heroShouldAddPointToPosition(){
		Hero hero = new Hero();
		hero.Move(12); // initial position equals to 0 
		int expected = 12; // => 0 + 12
		assertEquals(expected, hero.position);
	}

}
