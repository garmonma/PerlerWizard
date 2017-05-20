
package com.nni.gamevate.perlerwizard.object.hero;

import com.nni.gamevate.perlerwizard.object.hero.equipment.Equipment;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.Skills;

public class Knight extends Hero {

	public Knight(int width, int height, float x, float y, int level) {
		super(width, height, x, y, level);

		speed = 6;
	}


	@Override
	public Skill castSpecial() {
		return null;
	}

	@Override
	public Skill castDefense() {
		return null;
	}

	@Override
	public void setEquipmentSlotOne(Equipment item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEquipmentSlotTwo(Equipment item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEquipmentSlotThree(Equipment item) {
		// TODO Auto-generated method stub

	}

	@Override
	public Skill attack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skill attack(Skills skill) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Skill attack(int selectedSkill) {
		// TODO Auto-generated method stub
		return null;
	}

}
