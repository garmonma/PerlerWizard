
package com.nni.gamevate.perlerwizard.object.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.object.skills.JavelinThrow;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.defense.EnergyShield;
import com.nni.gamevate.perlerwizard.object.skills.defense.Reflect;

public class Knight extends Hero {

	public Knight(int width, int height, float x, float y, int level) {
		super(width, height, x, y, level);
		
		_speed = 6;
		_hitPoints = (int) Math.ceil(_level * 32 * _currentHealthPct);
	}

	@Override
	public Skill attack(int selectedSkill) {
		
		if(JavelinThrow.getLastCast() == null 
				|| TimeUtils.millis() - JavelinThrow.JAVELIN_THROW_LAST_CAST 
				> JavelinThrow.JAVELIN_THROW_REFRESH_TIMER ){
			Gdx.app.log("Casting", "Javelin Throw");
		
			return new JavelinThrow(getX() + getWidth() / 2, getY() + getHeight());	
		}
		
		return null;
	}

	@Override
	public Skill castSpecial() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Skill castDefense() {
		if(Reflect.getLastCast() == null 
				|| TimeUtils.millis() - Reflect.REFLECT_LAST_CAST 
				> Reflect.REFLECT_REFRESH_TIMER){
			
			Gdx.app.log("Casting", "Reflect");
			return new Reflect(getX() - .10f, 
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
