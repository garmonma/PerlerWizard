package com.nni.gamevate.perlerwizard.object.skills.spells;

import com.badlogic.gdx.utils.TimeUtils;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 * 
 * The Yellow Spell travels at a very fast speed. It has the ability
 * to paralyze the first enemy that it hits. special effect
 * resets after bouncing off of the shield.
 *
 */
public class YellowSpell extends Spell {
	public long _timeCounter;
	
	public static Long YELLOW_SPELL_LAST_CAST;
	public static long YELLOW_SPELL_REFRESH_TIMER = 10000;
	
	public static Long getLastCast(){
		return YELLOW_SPELL_LAST_CAST;
	}
	
	public YellowSpell(float x, float y){
		super(x, y);
		
		YELLOW_SPELL_LAST_CAST = TimeUtils.millis();
		_timeCounter = TimeUtils.millis();
		
		_speed = 10;
		_velocity.set(_direction).scl(_speed);
	}

	public YellowSpell(float width, float height, float x, float y) {
		super(width, height, x, y);
		
		YELLOW_SPELL_LAST_CAST = TimeUtils.millis();
		_timeCounter = TimeUtils.millis();
		
		_speed = 10;
		_velocity.set(_direction).scl(_speed);
	}

}