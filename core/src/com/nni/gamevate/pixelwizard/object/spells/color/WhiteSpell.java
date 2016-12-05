package com.nni.gamevate.pixelwizard.object.spells.color;

import com.badlogic.gdx.graphics.Color;

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
		_color = Color.WHITE;
	}

	@Override
	public void initSpellEffect() {

	}

	@Override
	public String toString() {
		return "white";
	}
}