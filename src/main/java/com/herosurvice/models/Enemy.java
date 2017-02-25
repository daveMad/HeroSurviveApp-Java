package com.herosurvice.models;

public class Enemy extends Entity implements ICharacter {
	
	public Enemy(int position,int hp, int attackPoint){
		super(position,hp,attackPoint);
	}
	
	public void attack(ICharacter target) {
		// TODO Auto-generated method stub
		target.takeDamage(this.attackPoint);
	}

	public void takeDamage(int damage) {
		// TODO Auto-generated method stub
		this.hp -= damage;
	}

}
