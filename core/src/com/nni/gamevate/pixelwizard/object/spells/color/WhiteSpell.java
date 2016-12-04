package com.nni.gamevate.pixelwizard.object.spells.color;

/**
 * 
 * @author Marcus Garmon
 * 
 *         The most basic spell color. It travels at a normal speed and has a
 *         cooldown of 3 seconds.
 *
 */
public class WhiteSpell extends SpellColor {

	public static boolean _onCooldown;

	public WhiteSpell() {

		_onCooldown = true;
	}

	@Override
	public void initSpellEffect() {

	}

	@Override
	public String toString() {
		return "white";
	}
}