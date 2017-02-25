package com.herosurvice.models;

public class Entity {
	public int position;

	public Entity() {
		this.position = 0;
	}
	
	public Entity(int position){
		this.position = position;
	}
	
	public void Move(int meter){
		this.position += meter;
	}

}
