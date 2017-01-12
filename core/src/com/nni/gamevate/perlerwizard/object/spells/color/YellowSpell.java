package com.nni.gamevate.perlerwizard.object.spells.color;

import com.badlogic.gdx.graphics.Color;
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
public class YellowSpell extends SpellColor {
	private static long lastSpell;
	
	public YellowSpell(){
		super();
		_color = Color.YELLOW;
		lastSpell = TimeUtils.nanoTime();
	}
	
	
	@Override
	public void initSpellEffect() {
		setCooldown(12000000000l);
		setSpeedMultiplier(1.8f);
		paralyze();
		
	}
	
	@Override
	public boolean isOnCooldown(long cooldown) {
		return YellowSpell.onCooldown(cooldown);
	}

	@Override
	public void reset() {
		YellowSpell.lastSpell = TimeUtils.nanoTime();	
	}
	
	public String toString(){
		return "yellow";
	}
	
	private static boolean onCooldown(long cooldown) {
		if (TimeUtils.timeSinceNanos(YellowSpell.lastSpell) > cooldown) {
			return false;
		}

		return true;
	}
	
	private void paralyze() {
		
	}
}