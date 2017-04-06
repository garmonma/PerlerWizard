package com.nni.gamevate.perlerwizard.object.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.object.hero.equipment.Equipment;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.defense.EnergyShield;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.BlackSpell;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.BlueSpell;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.GreenSpell;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.RedSpell;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.WhiteSpell;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.YellowSpell;
import com.nni.gamevate.perlerwizard.object.skills.throwables.RockThrow;

public class Wizard extends Hero {
	
	private final long ENERGY_SHIELD_REFRESH_TIMER = 30000;
	private final long BLACK_SPELL_REFRESH_TIMER = 25000;
	private final long GREEN_SPELL_REFRESH_TIMER = 60000;
	private final long RED_SPELL_REFRESH_TIMER = 5000;
	private final long WHITE_SPELL_REFRESH_TIMER = 1000;
	private final long YELLOW_SPELL_REFRESH_TIMER = 10000;
	private final long BLUE_SPELL_REFRESH_TIMER = 30000;
	
	private long blackSpellLastCast;
	private long blueSpellLastCast;
	private long greenSpellLastCast;
	private long redSpellLastCast;
	private long whiteSpellLastCast;
	private long yellowSpellLastCast;
	private long energyShieldLastCast;
	

	public Wizard(int width, int height, float x, float y, int level) {
		super(width, height, x, y, level);
		_speed = 8;
		_hitPoints = (int) Math.ceil(_level * 16 * _currentHealthPct);
		
		blackSpellLastCast = 0;
		blueSpellLastCast = 0;
		greenSpellLastCast = 0;
		whiteSpellLastCast = 0;
		redSpellLastCast = 0;
		yellowSpellLastCast = 0;
		energyShieldLastCast = 0;
	}

	public Skill attack(int selectedSkill) {

		switch (selectedSkill) {
		case 1:
			if (redSpellLastCast == 0 || TimeUtils.millis() - redSpellLastCast > RED_SPELL_REFRESH_TIMER) {
				redSpellLastCast = TimeUtils.millis();
				Gdx.app.log("Casting", "Red Spell");
				
				return new RedSpell(getX() + getWidth() / 2, getY() + getHeight());
			}

			break;
		case 2:
			if (blueSpellLastCast == 0 || TimeUtils.millis() - blueSpellLastCast > BLUE_SPELL_REFRESH_TIMER) {
				blueSpellLastCast = TimeUtils.millis();
				Gdx.app.log("Casting", "Blue Spell");
				return new BlueSpell(getX() + getWidth() / 2, getY() + getHeight());
			}

			break;
		case 3:
			if (yellowSpellLastCast == 0 || TimeUtils.millis() - yellowSpellLastCast > YELLOW_SPELL_REFRESH_TIMER) {
				yellowSpellLastCast = TimeUtils.millis();
				Gdx.app.log("Casting", "Yellow Spell");
				return new YellowSpell(getX() + getWidth() / 2, getY() + getHeight());
			}

			break;
		case 4:
			if (greenSpellLastCast == 0 || TimeUtils.millis() - greenSpellLastCast > GREEN_SPELL_REFRESH_TIMER) {
				greenSpellLastCast = TimeUtils.millis();
				Gdx.app.log("Casting", "Green Spell");
				return new GreenSpell(getX() + getWidth() / 2, getY() + getHeight());
			}

			break;
		case 5:
			if (blackSpellLastCast == 0 || TimeUtils.millis() - blackSpellLastCast > BLACK_SPELL_REFRESH_TIMER) {
				blackSpellLastCast = TimeUtils.millis();
				Gdx.app.log("Casting", "Black Spell");
				return new BlackSpell(getX() + getWidth() / 2, getY() + getHeight());
			}

			break;
		}

		if (whiteSpellLastCast == 0 || TimeUtils.millis() - whiteSpellLastCast > WHITE_SPELL_REFRESH_TIMER) {
			whiteSpellLastCast = TimeUtils.millis();
			Gdx.app.log("Casting", "White Spell");
			return new WhiteSpell(getX() + getWidth() / 2, getY() + getHeight());
		}

		return null;
	}

	@Override
	public Skill castSpecial() {
		return null;
	}

	@Override
	public Skill castDefense() {
		if (energyShieldLastCast == 0 || TimeUtils.millis() - energyShieldLastCast > ENERGY_SHIELD_REFRESH_TIMER) {
			energyShieldLastCast = TimeUtils.millis();
			Gdx.app.log("Casting", "Energy Shield");
			return new EnergyShield(getX() - .10f, getY() + getHeight() + .15f, this);
		}

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

}
