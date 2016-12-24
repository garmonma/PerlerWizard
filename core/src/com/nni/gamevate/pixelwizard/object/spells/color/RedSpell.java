package com.nni.gamevate.pixelwizard.object.spells.color;

import com.badlogic.gdx.graphics.Color;
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
public class RedSpell extends SpellColor {

	public static long lastSpell;

	public RedSpell() {
		_color = Color.RED;
		lastSpell = TimeUtils.nanoTime();
	}

	@Override
	public void initSpellEffect() {
		setSpeedMultiplier(1.3f);
		setCooldown(3000000000l);
	}
	
	private static boolean onCooldown(long cooldown){
		if(TimeUtils.timeSinceNanos(RedSpell.lastSpell) > cooldown){
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "red";
	}

	@Override
	public boolean isOnCooldown(long cooldown) {
		return RedSpell.onCooldown(cooldown);
	}

	@Override
	public void reset() {
		RedSpell.lastSpell = TimeUtils.nanoTime();	
	}
	
	
}