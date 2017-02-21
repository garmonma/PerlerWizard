package com.nni.gamevate.perlerwizard.object.hero;

import com.badlogic.gdx.Gdx;
import com.nni.gamevate.perlerwizard.object.skills.BlackSpell;
import com.nni.gamevate.perlerwizard.object.skills.BlueSpell;
import com.nni.gamevate.perlerwizard.object.skills.GreenSpell;
import com.nni.gamevate.perlerwizard.object.skills.RedSpell;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.WhiteSpell;
import com.nni.gamevate.perlerwizard.object.skills.YellowSpell;

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
			Gdx.app.log("Casting", "Red Spell");
			return new RedSpell(getX() + getWidth() / 2, getY() + getHeight());
		case 2:
			Gdx.app.log("Casting", "Blue Spell");
			return new BlueSpell(getX() + getWidth() / 2, getY() + getHeight());
		case 3:
			Gdx.app.log("Casting", "Yellow Spell");
			return new YellowSpell(getX() + getWidth() / 2, getY() + getHeight());
		case 4:
			Gdx.app.log("Casting", "Green Spell");
			return new GreenSpell(getX() + getWidth() / 2, getY() + getHeight());
		case 5:
			Gdx.app.log("Casting", "Black Spell");
			return new BlackSpell(getX() + getWidth() / 2, getY() + getHeight());
		default:
			Gdx.app.log("Casting", "White Spell");
			return new WhiteSpell(getX() + getWidth() / 2, getY() + getHeight());
		}
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
