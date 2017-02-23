package com.nni.gamevate.perlerwizard.object.skills.spells;

import com.badlogic.gdx.utils.TimeUtils;

public class BlackSpell extends Spell {
	
	public long _timeCounter;

	public static Long BLACK_SPELL_LAST_CAST;
	public static long BLACK_SPELL_REFRESH_TIMER = 25000;
	
	public static Long getLastCast(){
		return BLACK_SPELL_LAST_CAST;
	}

	public BlackSpell(float x, float y) {
		super(x, y);
		
		BLACK_SPELL_LAST_CAST = TimeUtils.millis();
		_timeCounter = TimeUtils.millis();
	}

	public BlackSpell(float width, float height, float x, float y) {
		super(width, height, x, y);
		
		BLACK_SPELL_LAST_CAST = TimeUtils.millis();
		_timeCounter = TimeUtils.millis();
	}

}
