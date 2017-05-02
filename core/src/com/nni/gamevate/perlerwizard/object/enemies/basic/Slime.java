package com.nni.gamevate.perlerwizard.object.enemies.basic;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class Slime extends Enemy {
	
	public Slime(float x, float y, int waveNumber){
		super(0.7f, 0.7f, x, y, waveNumber);
	}

	public Slime(int width, int height, float x, float y,int waveNumber) {
		super(width, height, x, y,waveNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Skill attack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skill castSpecial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skill castDefense() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(float delta) {
		// TODO Auto-generated method stub
		
	}


}
