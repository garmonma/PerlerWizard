package com.nni.gamevate.pixelwizard.object.spells.color;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * @author Marcus Garmon 12/29/2016
 * 
 *         The GreenSpell travels slower than other spell colors but it has the
 *         ability to absorb life from those it hit and heals the caster upon
 *         touching it.
 */
public class GreenSpell extends SpellColor {
	private static long lastSpell;

	public GreenSpell() {
		super();
		_color = Color.GREEN;
		lastSpell = TimeUtils.nanoTime();

	}

	@Override
	public void initSpellEffect() {
		setCooldown(10000000000l);
		setSpeedMultiplier(0.7f);
		cure();
	}

	@Override
	public boolean isOnCooldown(long cooldown) {
		return GreenSpell.onCooldown(cooldown);
	}

	@Override
	public void reset() {
		GreenSpell.lastSpell = TimeUtils.nanoTime();
	}

	public String toString() {
		return "green";
	}

	private static boolean onCooldown(long cooldown) {
		if (TimeUtils.timeSinceNanos(GreenSpell.lastSpell) > cooldown) {
			return false;
		}

		return true;
	}

	private void cure() {

	}
}