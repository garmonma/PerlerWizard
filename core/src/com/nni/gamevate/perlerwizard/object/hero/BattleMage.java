package com.nni.gamevate.perlerwizard.object.hero;

import com.nni.gamevate.perlerwizard.object.hero.equipment.Equipment;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.Skills;

public class BattleMage extends Hero {
	

	public BattleMage(int width, int height, float x, float y, int level) {
		super(width, height, x, y, level);
		speed = 7;
		
		skillManager.addSkills(Skills.MAGIC_CAST);
		skillManager.addSkills(Skills.VOID_CAST);
		skillManager.addSkills(Skills.WATER_CAST);
		skillManager.addSkills(Skills.FIRE_CAST);
		skillManager.addSkills(Skills.LIGHTNING_CAST);
		skillManager.addSkills(Skills.FOREST_CAST);
	}
	
	@Override
	public Skill attack() {
		return null;
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
