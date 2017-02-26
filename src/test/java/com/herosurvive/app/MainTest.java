package com.herosurvive.app;

import static org.junit.Assert.*;

import org.junit.Test;

import com.herosurvive.service.LogService;

public class MainTest {

	@Test
	public void shouldHandleInput() {
		App.HandleInput();
		assertEquals(0, LogService.getInstance().errorMessages.size());
	}

}
