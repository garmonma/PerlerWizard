package com.nni.gamevate.perlerwizard.object.hero;

import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class BattleMage extends Hero {

	public BattleMage(int width, int height, float x, float y, int level) {
		super(width, height, x, y, level);
		_speed = 7;
		_hitPoints = (int) Math.ceil(_level * 22 * _currentHealthPct);
	}

	@Override
	public Skill attack(int selectedSkill) {
		return null;
		
	}

	@Override
	public void castSpecial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void castDefense() {
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
