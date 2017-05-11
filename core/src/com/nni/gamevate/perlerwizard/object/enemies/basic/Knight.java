package com.nni.gamevate.perlerwizard.object.enemies.basic;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class Knight extends Enemy {

	public Knight(float x, float y, int waveNumber){
		super(1.0f, 1.0f, x, y, waveNumber);
	}

	public Knight(float width, float height, float x, float y, int waveNumber) {
		super(width, height, x, y, waveNumber);
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
	protected void uniquePattern(float delta) {
		// TODO Auto-generated method stub
		
	}

}
