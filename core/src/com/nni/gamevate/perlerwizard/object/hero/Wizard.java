package com.nni.gamevate.perlerwizard.object.hero;

import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.object.hero.equipment.Equipment;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.Skills;

public class Wizard extends Hero {
	private static final String tag = Wizard.class.getSimpleName();
	
	

	public Wizard(int width, int height, float x, float y, int level) {
		super(width, height, x, y, level);
		speed = 8;
		//cur = (int) Math.ceil(_level * 16 * currentHealth);
		skillManager.addSkills(Skills.MAGIC_CAST);
		skillManager.addSkills(Skills.VOID_CAST);
		skillManager.addSkills(Skills.WATER_CAST);
		skillManager.addSkills(Skills.FIRE_CAST);
		skillManager.addSkills(Skills.LIGHTNING_CAST);
		skillManager.addSkills(Skills.FOREST_CAST);
		texture = PerlerWizard.assetManager.get(AssetDescriptors.WIZARD);
		

	}
	

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
