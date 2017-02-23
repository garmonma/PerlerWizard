package com.nni.gamevate.perlerwizard.object.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.defense.EnergyShield;
import com.nni.gamevate.perlerwizard.object.skills.spells.BlackSpell;
import com.nni.gamevate.perlerwizard.object.skills.spells.BlueSpell;
import com.nni.gamevate.perlerwizard.object.skills.spells.GreenSpell;
import com.nni.gamevate.perlerwizard.object.skills.spells.RedSpell;
import com.nni.gamevate.perlerwizard.object.skills.spells.WhiteSpell;
import com.nni.gamevate.perlerwizard.object.skills.spells.YellowSpell;

public class Wizard extends Hero {

	public Wizard(int width, int height, float x, float y, int level) {
		super(width, height, x, y, level);
		_speed = 8;
		_hitPoints = (int) Math.ceil(_level * 16 * _currentHealthPct);
	}

	@Override
	public Skill attack(int selectedSkill) {
		
		switch(selectedSkill){
		case 1:
			if(RedSpell.getLastCast() == null 
					|| TimeUtils.millis() - RedSpell.RED_SPELL_LAST_CAST 
					> RedSpell.RED_SPELL_REFRESH_TIMER ){
				Gdx.app.log("Casting", "Red Spell");
				return new RedSpell(getX() + getWidth() / 2, getY() + getHeight());
			}
				
			break;
		case 2:
			if(BlueSpell.getLastCast() == null 
					|| TimeUtils.millis() - BlueSpell.BLUE_SPELL_LAST_CAST 
					> BlueSpell.BLUE_SPELL_REFRESH_TIMER ){
				Gdx.app.log("Casting", "Blue Spell");
				return new BlueSpell(getX() + getWidth() / 2, getY() + getHeight());
			}
				
			break;
		case 3:
			if(YellowSpell.getLastCast() == null 
					|| TimeUtils.millis() - YellowSpell.YELLOW_SPELL_LAST_CAST 
					> YellowSpell.YELLOW_SPELL_REFRESH_TIMER ){
				Gdx.app.log("Casting", "Yellow Spell");
				return new YellowSpell(getX() + getWidth() / 2, getY() + getHeight());
			}
			
			break;
		case 4:
			if(GreenSpell.getLastCast() == null 
					|| TimeUtils.millis() - GreenSpell.GREEN_SPELL_LAST_CAST 
					> GreenSpell.GREEN_SPELL_REFRESH_TIMER ){
				Gdx.app.log("Casting", "Green Spell");
				return new GreenSpell(getX() + getWidth() / 2, getY() + getHeight());	
			}
			
			break;
		case 5:
			if(BlackSpell.getLastCast() == null 
					|| TimeUtils.millis() - BlackSpell.BLACK_SPELL_LAST_CAST 
					> BlackSpell.BLACK_SPELL_REFRESH_TIMER ){
				Gdx.app.log("Casting", "Black Spell");
				return new BlackSpell(getX() + getWidth() / 2, getY() + getHeight());
			}
				
			break;
		}
		
		if(WhiteSpell.getLastCast() == null 
				|| TimeUtils.millis() - WhiteSpell.WHITE_SPELL_LAST_CAST 
				> WhiteSpell.WHITE_SPELL_REFRESH_TIMER ){
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
		if(EnergyShield.getLastCast() == null 
				|| TimeUtils.millis() - EnergyShield.ENERGY_SHIELD_LAST_CAST 
				> EnergyShield.ENERGY_SHIELD_REFRESH_TIMER){
			
			Gdx.app.log("Casting", "Energy Shield");
			return new EnergyShield(getX() - .10f, 
					getY() + getHeight() + .15f,
					this);
		} 
			
		return null;
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
