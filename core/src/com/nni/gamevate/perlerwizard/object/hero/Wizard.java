package com.nni.gamevate.perlerwizard.object.hero;

public class Wizard extends Hero {

	public Wizard(int width, int height, float x, float y, int level) {
		super(width, height, x, y, level);
		_speed = 8;
		_hitPoints = _level * 16;
	}

	@Override
	void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void castSpecial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void castDefense() {
		// TODO Auto-generated method stub
		
	}

}
