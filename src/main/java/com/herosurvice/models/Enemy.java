package com.herosurvice.models;

public class Enemy extends Entity implements ICharacter {

	public void attack(ICharacter target) {
		// TODO Auto-generated method stub
		target.takeDamage(this.attackPoint);
	}

	public void takeDamage(int damage) {
		// TODO Auto-generated method stub
		this.hp -= damage;
	}

}
