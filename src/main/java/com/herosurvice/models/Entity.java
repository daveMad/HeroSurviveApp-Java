package com.herosurvice.models;

public class Entity {
	public int position;

	public Entity() {
		this.position = 0;
	}
	
	public void Move(int meter){
		this.position += meter;
	}

}
