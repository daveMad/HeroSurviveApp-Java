package com.herosurvice.models;

public class Enemy extends Entity implements ICharacter {

	public String name;

	public Enemy(int position, int hp, int attackPoint, String name) {
		super(position, hp, attackPoint);
		this.name = name;
	}

	public Enemy(String name) {
		if (name == "")
			this.name = "Default Enemy Name";

	}

	public void attack(ICharacter target) {
		// TODO Auto-generated method stub
		target.takeDamage(this.attackPoint);
	}

	public void takeDamage(int damage) {
		// TODO Auto-generated method stub
		this.hp -= damage;
	}

	@Override
	public String toString() {
		return "Enemy =>  Pos : " + this.position + " Hp : " + this.hp + " Attack : " + this.attackPoint;
	}

}
