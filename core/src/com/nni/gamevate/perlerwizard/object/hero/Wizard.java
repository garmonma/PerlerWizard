package com.nni.gamevate.perlerwizard.object.hero;

import com.badlogic.gdx.Gdx;
import com.nni.gamevate.perlerwizard.object.hero.equipment.Equipment;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.Skills;

public class Wizard extends Hero {
	private static final String tag = Wizard.class.getSimpleName();
	
	

	public Wizard(int width, int height, float x, float y, int level) {
		super(width, height, x, y, level);
		_speed = 8;
		_hitPoints = (int) Math.ceil(_level * 16 * _currentHealthPct);
		skillManager.addSkills(Skills.WHITE_SPELL);
		skillManager.addSkills(Skills.BLACK_SPELL);
		skillManager.addSkills(Skills.BLUE_SPELL);
		skillManager.addSkills(Skills.RED_SPELL);
		skillManager.addSkills(Skills.YELLOW_SPELL);
		skillManager.addSkills(Skills.GREEN_SPELL);
		
		
		
	}
	
//	@Override
//	public Skill attack(Skills selectedSkill) {
//		//Gdx.app.log(tag, "Attacked");
//		return skillManager.useSkill(selectedSkill, _position.x, _position.y);
//	}

	@Override
	public Skill castSpecial() {
		return null;
	}

	@Override
	public Skill castDefense() {
//		if (energyShieldLastCast == 0 || TimeUtils.millis() - energyShieldLastCast > ENERGY_SHIELD_REFRESH_TIMER) {
//			energyShieldLastCast = TimeUtils.millis();
//			Gdx.app.log("Casting", "Energy Shield");
//			return new EnergyShield(getX() - .10f, getY() + getHeight() + .15f, this);
//		}

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
	public Skill attack(int selectedSkill) {
		// TODO Auto-generated method stub
		return null;
	}

}
