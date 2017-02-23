package com.nni.gamevate.perlerwizard.object.skills.spells;

import com.badlogic.gdx.utils.TimeUtils;

/**
 * @author Marcus Garmon 12/29/2016
 * 
 *         The Blue Spell travels at normal speed. It has the ability to
 *         explode, breaking off into four smaller pieces.
 */
public class BlueSpell extends Spell {
	
	public long _timeCounter;
	
	public static Long BLUE_SPELL_LAST_CAST;
	public static long BLUE_SPELL_REFRESH_TIMER = 30000;
	
	public static Long getLastCast(){
		return BLUE_SPELL_LAST_CAST;
	}
	
	public BlueSpell(float x, float y){
		super(x, y);
		
		BLUE_SPELL_LAST_CAST = TimeUtils.millis();
		_timeCounter = TimeUtils.millis();
	}

	public BlueSpell(float width, float height, float x, float y) {
		super(width, height, x, y);
		
		BLUE_SPELL_LAST_CAST = TimeUtils.millis();
		_timeCounter = TimeUtils.millis();
	}
	
}