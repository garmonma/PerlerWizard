package com.nni.gamevate.perlerwizard.object.hero;

public class Wizard extends Hero {

	public Wizard(int width, int height, float x, float y, int level) {
		super(width, height, x, y, level);
		_speed = 8;
		_hitPoints = (int) Math.ceil(_level * 16 * _currentHealthPct);
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

	@Override
	void setEquipmentSlotOne(Equipment item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void setEquipmentSlotTwo(Equipment item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void setEquipmentSlotThree(Equipment item) {
		// TODO Auto-generated method stub
		
	}

}