package com.herosurvice.models;

public interface IHero extends ICharacter {
	int move();
	int moveRange(int range); // used for testing purposes
}
