
package com.nni.gamevate.perlerwizard.object.hero;

import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class Knight extends Hero {

	public Knight(int width, int height, float x, float y, int level) {
		super(width, height, x, y, level);
		
		_speed = 6;
		_hitPoints = (int) Math.ceil(_level * 32 * _currentHealthPct);
		
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
