package com.nni.gamevate.pixelwizard.object.spells.color;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * @author Marcus Garmon 12/29/2016
 * 
 *         The Blue Spell travels at normal speed. It has the ability to
 *         explode, breaking off into four smaller pieces.
 */
public class BlueSpell extends SpellColor {
	private static long lastSpell;

	public BlueSpell() {
		super();
		_color = Color.BLUE;
		lastSpell = TimeUtils.nanoTime();
	}

	@Override
	public void initSpellEffect() {
		setCooldown(8000000000l);
		splash();
	}

	@Override
	public boolean isOnCooldown(long cooldown) {
		return BlueSpell.onCooldown(cooldown);
	}

	@Override
	public void reset() {
		BlueSpell.lastSpell = TimeUtils.nanoTime();
	}

	public String toString() {
		return "blue";
	}

	private static boolean onCooldown(long cooldown) {
		if (TimeUtils.timeSinceNanos(BlueSpell.lastSpell) > cooldown) {
			return false;
		}

		return true;
	}

	private void splash() {

	}
}