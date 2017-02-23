package com.nni.gamevate.perlerwizard.object.skills.spells;

import com.badlogic.gdx.utils.TimeUtils;

/**
 * 
 * @author Marcus Garmon 11/27/2016
 * 
 *         The RedSpell has a faster speed than regular spells but it requires a
 *         larger cooldown to use again. A special effect that it could have is
 *         burn which could destroy shields or lower defense.
 *
 */
public class RedSpell extends Spell {

	public long _timeCounter;

	public static Long RED_SPELL_LAST_CAST;
	public static long RED_SPELL_REFRESH_TIMER = 5000;
	
	public static Long getLastCast(){
		return RED_SPELL_LAST_CAST;
	}

	public RedSpell(float x, float y) {
		super(x, y);
		RED_SPELL_LAST_CAST = TimeUtils.millis();
		_timeCounter = TimeUtils.millis();RED_SPELL_LAST_CAST = TimeUtils.millis();
		_timeCounter = TimeUtils.millis();

		_speed = 7.5f;
		_velocity.set(_direction).scl(_speed);
	}

	public RedSpell(float width, float height, float x, float y) {
		super(width, height, x, y);
		
		RED_SPELL_LAST_CAST = TimeUtils.millis();
		_timeCounter = TimeUtils.millis();
		
		_speed = 7.5f;
		_velocity.set(_direction).scl(_speed);
	}

}