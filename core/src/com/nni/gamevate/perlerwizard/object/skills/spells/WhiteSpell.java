package com.nni.gamevate.perlerwizard.object.skills.spells;

import com.badlogic.gdx.utils.TimeUtils;

/**
 * 
 * @author Marcus Garmon 11/27/2016
 * 
 *         The most basic spell color. It travels at a normal speed and has a
 *         cooldown of 3 seconds.
 *
 */
public class WhiteSpell extends Spell {
	
	public long _timeCounter;

	public static Long WHITE_SPELL_LAST_CAST;
	public static long WHITE_SPELL_REFRESH_TIMER = 1000;
	
	public static Long getLastCast(){
		return WHITE_SPELL_LAST_CAST;
	}
	
	public WhiteSpell(float x, float y){
		super(x, y);
		
		WHITE_SPELL_LAST_CAST = TimeUtils.millis();
		_timeCounter = TimeUtils.millis();
	}

	public WhiteSpell(float width, float height, float x, float y) {
		super(width, height, x, y);
		
		WHITE_SPELL_LAST_CAST = TimeUtils.millis();
		_timeCounter = TimeUtils.millis();
	}

}