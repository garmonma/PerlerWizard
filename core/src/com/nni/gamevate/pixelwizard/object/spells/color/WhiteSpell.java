package com.nni.gamevate.pixelwizard.object.spells.color;

import java.sql.Time;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * 
 * @author Marcus Garmon
 * 
 *         The most basic spell color. It travels at a normal speed and has a
 *         cooldown of 3 seconds.
 *
 */
public class WhiteSpell extends SpellColor {
	private static long lastSpell;

	public WhiteSpell() {
		_color = Color.WHITE;
		lastSpell = TimeUtils.nanoTime();
	}
	
	private static boolean onCooldown(long cooldown){
		if(TimeUtils.timeSinceNanos(WhiteSpell.lastSpell) > cooldown){
			return false;
		}
		
		return true;
	}
	
	public boolean isOnCooldown(long cooldown){
		return WhiteSpell.onCooldown(cooldown);
	}

	@Override
	public void initSpellEffect() {

	}

	@Override
	public String toString() {
		return "white";
	}
}