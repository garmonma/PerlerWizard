package com.nni.gamevate.perlerwizard.object.hero;

public class BattleMage extends Hero {

	public BattleMage(int width, int height, float x, float y, int level) {
		super(width, height, x, y, level);
		_speed = 7;
		_hitPoints = level * 22;
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
