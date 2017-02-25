package com.herosurvive.app;

import static org.junit.Assert.*;

import org.junit.Test;
import com.herosurvice.models.Entity;;


public class ModelsTest {

	@Test
	public void entityShouldInitialize() {
		Entity instance = new Entity();
		assertEquals(0, instance.position);
		
	}

}
