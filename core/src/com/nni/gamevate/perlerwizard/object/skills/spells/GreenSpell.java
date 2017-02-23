package com.nni.gamevate.perlerwizard.object.skills.spells;

import com.badlogic.gdx.utils.TimeUtils;

/**
 * @author Marcus Garmon 12/29/2016
 * 
 *         The GreenSpell travels slower than other spell colors but it has the
 *         ability to absorb life from those it hit and heals the caster upon
 *         touching it.
 */
public class GreenSpell extends Spell {
	
	public long _timeCounter;

	public static Long GREEN_SPELL_LAST_CAST;
	public static long GREEN_SPELL_REFRESH_TIMER = 60000;
	
	public static Long getLastCast(){
		return GREEN_SPELL_LAST_CAST;
	}
	
	public GreenSpell(float x, float y){
		super(x, y);
		GREEN_SPELL_LAST_CAST = TimeUtils.millis();
		_timeCounter = TimeUtils.millis();
		
		_speed = 4.0f;
		_velocity.set(_direction).scl(_speed);
	}

	public GreenSpell(float width, float height, float x, float y) {
		super(width, height, x, y);
		_speed = 4.0f;
		_velocity.set(_direction).scl(_speed);
	}

}